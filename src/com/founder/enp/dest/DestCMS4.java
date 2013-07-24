/**
 * dest 只有db方式
 */
package com.founder.enp.dest;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.founder.enp.info.ArticleInfo;
import com.founder.enp.info.ChunkInfo;
import com.founder.enp.info.ConnectionInfo;
import com.founder.enp.util.ArticleUtil;
import com.founder.enp.util.ColumnUtil;
import com.founder.enp.util.DBUtil;
import com.sun.jmx.snmp.Timestamp;

/**
 * @author Administrator
 *
 */
public class DestCMS4 implements Dest{

	private static Log log = LogFactory.getLog(DestCMS4.class);
	Connection conn = null;
	ChunkInfo chunkinfo = null;
	String type = null;
	private ConnectionInfo ci = null;
	//将取得数据存于摘要中
	String tableField = "ABSTRACT";
	protected DestCMS4(ConnectionInfo ci,ChunkInfo chunkinfo){
		this.ci = ci;
		this.chunkinfo = chunkinfo;
	}
	public String geType() {
		return type;
	}
	public void save(List<Object[]> list) {
		try {
			//目标表字段。
			if(chunkinfo.getDestfield()!= null && !chunkinfo.getDestfield().equals("")){
				tableField = chunkinfo.getDestfield();
			}
			long masterid = chunkinfo.getDestnodeid();
			boolean nodeexist = false;
			if(masterid > 0 ){
				nodeexist = ColumnUtil.nodeExists(conn,masterid, 2);
				if(!nodeexist)
					log.info("指定的destnodeid 不存在于是翔宇系统中，将使用destNode");
			}
			if(!nodeexist){
				if(chunkinfo.getDestnode() != null && !chunkinfo.getDestnode().equals("")){
					masterid = ColumnUtil.syncTypeStruct(conn, chunkinfo.getDestnode(), chunkinfo.getSiteid(), chunkinfo.getChunkmark());
				}else{
					log.error("请检查【"+chunkinfo.getChunkmark()+"】栏目配置,终止存储进翔宇");
					return ;
				}
			}
			/*
			 * 开始插入或更新数据
			 * 思路，，在栏目下，importid为1，2，3 ，即为排行，在相应的栏目id下
			 * list第一条记录1,第二条记录2
			 */
			try{
				int size = list.size();
				for(int i=0;i<size;i++){
					ArticleInfo article = new ArticleInfo();
					article.setTitle(String.valueOf(i+1));
					article.setDisplayorder(ArticleUtil.createDisplayOrder(null, 0, 0, size-i));
					setArticleInfo(article,(Object[])list.get(i));
					int tempid = ArticleUtil.isNewArticle(conn, String.valueOf(i+1), masterid);
					if(tempid>0){
						article.setArticleid(tempid);
						ArticleUtil.updateReleaseLib(masterid,tableField, article,  conn);
						log.info("更新已有稿件【"+article.getArticleid()+"】排行数:【"+(i+1)+"】所在栏目【"+masterid+"】"  );
					}else{
						article.setArticleid(ArticleUtil.generateArticleId(conn, 2));
						/*
						 * 如果是新稿件，在第一条的importid应该要最大，因为算displayorder根据importid判断
						 * 在翔宇中稿件为displayorder倒序排序
						 */					
						ArticleUtil.insertReleaseLib(masterid, tableField,article,i+1, conn);
						log.info("新取到了稿件【"+article.getArticleid()+"】排行数:【"+(i+1)+"】所在栏目【"+masterid+"】"  );
					}
				}
				if(chunkinfo.getIsDelElse()==1){
					try{

						List<Object[]> elselist = ArticleUtil.getElse(conn, masterid, size);
						for (int i=0;i<elselist.size();i++){
							Object[] elseit = elselist.get(i);
							ArticleUtil.deleteArticle(conn, elseit[0].toString());
							log.info("删除多余稿件【"+elseit[0]+"】排行数:【"+elseit[1]+"】所在栏目【"+masterid+"】"  );
						}
					}catch (Exception e) {
						log.error("删除多余稿件发生异常",e);
					}
				}
			}catch (Exception e) {
				log.error("",e);
			}
			
		} catch (Exception e) {
			log.error("",e);
		}
	}

	private void setArticleInfo(ArticleInfo info, Object[] obj){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<obj.length;i++){
			if(i == obj.length-1){
				sb.append(obj[i].toString());
			}else{
				sb.append(obj[i].toString()).append(chunkinfo.getSeparator());
			}
		}
		info.setAbstrt(sb.toString());
		info.setAttr(63);
		info.setPublishstate(1);
		info.setPubtime(new Timestamp(System.currentTimeMillis()));
	}
	public void close() {
		DBUtil.closeAll(conn);
	}
	public void open() throws Exception {
		if(conn == null || conn.isClosed())
			conn = DBUtil.getConnection(ci.getId());		
	}
}
