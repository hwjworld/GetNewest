/*
 * Copyright (c) 2005,北大方正电子有限公司集成系统开发部
 * All rights reserved.
 *
 * 摘要：稿件操作的工具类。
 *
 * 当前版本：1.0
 * 作者：齐明
 *
 */
package com.founder.enp.util;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.founder.enp.info.ArticleInfo;

public class ArticleUtil {

	private static Log log = LogFactory.getLog(ArticleUtil.class);
		
	public static long insertReleaseLib(long nodeID,String field, ArticleInfo article,int importid,
			Connection conn) throws Exception {
		try {
			Object[] param = new Object[]{article.getArticleid(),article.getTitle(),article.getAbstrt(),nodeID,article.getAttr(),importid,article.getPublishstate()};

			String Insert_ReleaseLib = "insert into releaselib  (articleid, title, "+field+", createtime,  masterid, attr, importid,publishstate ,pubtime)  values(?,?,?,sysdate,?,?,?,?,sysdate)";
			DBUtil.executeSql(conn, Insert_ReleaseLib, param);
			
			param = new Object[]{nodeID,article.getArticleid(),article.getDisplayorder(),article.getAttr(),article.getPublishstate(),article.getTitle(),nodeID};
			String sSQL = "insert into pagelayout(nodeid,articleid,displayorder,attr,publishstate,title,masterid)"
					+ "values(?,?,?,?,?,?,?)";
			DBUtil.executeSql(conn, sSQL ,param);
		} catch (Exception ex) {
			log.error("", ex);
		}
		return article.getArticleid();
	}

	/**
	 * 
	 * @param nodeID
	 * @param article 应包括title,abstrace,articleid
	 * @param articleType
	 * @param conn
	 * @throws Exception
	 */
	public static void updateReleaseLib(long nodeID, String field,ArticleInfo article, Connection conn) throws Exception {
		try {
			Object [] param  = new Object[]{article.getTitle(),article.getAbstrt(),article.getArticleid()};
			String Update_ReleaseLib = "update releaselib set title=?, "+field+"=? where articleid=? ";
			DBUtil.executeSql(conn, Update_ReleaseLib, param);
			/*
			 * 更新排序,否则后来新增的会大于他
			 */
			param = new Object[]{article.getDisplayorder(),article.getArticleid(),nodeID};
			Update_ReleaseLib = "update pagelayout set displayorder = ? where articleid = ? and nodeid=?";
			DBUtil.executeSql(conn, Update_ReleaseLib, param);
		} catch (Exception e) {
			log.error("",e);
		}
	}

	/**
	 * 删除稿件
	 * 
	 * @param article
	 *            稿件对象
	 * @param sourceSys
	 *            稿件来源，1 资料上载，2 整合系统，从配置文件中得到
	 * @param conn
	 *            数据库连接
	 * @return 稿件ID
	 * @throws Exception
	 */
	public static void deleteArticle(Connection conn,String articleid) {
		try {
			String Delete_ReleaseLib = "delete from releaselib where articleid=?";//importid = ? and masterid=? ";
			Object[] param = new Object[]{articleid};
			DBUtil.executeSql(conn, Delete_ReleaseLib, param);
		} catch (Exception e) {
			log.error("",e);
		}
	}
	
	public static void delElse(Connection conn,long nodeid,int importid){
		try {
			String Delete_ReleaseLib = "delete from releaselib where masterid=? and importid>?";
			Object[] param = new Object[]{nodeid,importid};
			DBUtil.executeSql(conn, Delete_ReleaseLib, param);
		} catch (Exception e) {
			log.error("",e);
		}
	}
	public static List<Object[]>  getElse(Connection conn,long nodeid,int importsize){
		List<Object[]> rv = null;
		try {
			String getElesSql = "select articleid,importid from releaselib where masterid=? and importid>?";
			Object[] param = new Object[]{nodeid,importsize};
			rv = DBUtil.query(conn, getElesSql, param);
		} catch (Exception e) {
			log.error("",e);
		}
		return rv;
	}
	
	/**
	 * 写管理日志
	 * 
	 * @param article
	 *            稿件对象
	 * @param sourceSys
	 *            稿件来源，1 资料上载，2 整合系统，从配置文件中得到
	 * @param conn
	 *            数据库连接
	 * @return 稿件ID
	 * @throws Exception
	 */
	public static void writeLog(String opera, String operName,
			String operLoginName, int siteID, String siteName, int type,
			int subtype, String objTitle, long objUID, long objID, int result,
			String memo,Connection conn) throws Exception {
		try {
			long logID = DBUtil
					.getLongFromDatabase("select SEQ_ENPLOG.nextVal from dual",conn);
			String sql = "insert into enplog (logid,operation,username,loginname,operatedate,location,siteid,sitename,type,subtype,objtitle,objuid,objid,result,memo) values(?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?)";
			Object[] param = new Object[]{
					logID,
					opera,
					operName,
					operLoginName,
					InetAddress.getLocalHost().getHostAddress(),
					siteID,
					siteName,
					type,
					subtype,
					objTitle,
					objUID,
					objID,
					result,
					memo
			};
			DBUtil.executeSql(conn, sql,param);
		} catch (Exception e) {
			log.error("writeLog", e);
		} 
	}

	public static long generateArticleId(Connection conn,int libtype) throws Exception {
		PreparedStatement pstmt = null;
		String seqName = "";
		long artID = -1;
		if (libtype == 1)
			seqName = "SEQ_SOURCELIB";
		else
			seqName = "SEQ_RELEASELIB";
		try {
			artID = DBUtil.getLongFromDatabase("select " + seqName
					+ ".nextVal from dual",conn);

		} finally {
			DBUtil.closeAll( pstmt);
		}
		return artID;
	}

	/**
	 * 本方法旨在保证原有稿件顺序数据可用的情况下减少初始稿件顺序的有效数字个数 从EnpSystem.createDisplayOrder修改
	 * 2005-4-20 13:23:11 wuxing
	 * 
	 * @param cd
	 *            指定稿件顺序时指定的日期
	 * @param daycnt
	 *            变更的天数
	 * @param ord
	 *            指定稿件顺序时指定的顺序(0 ~ 9)
	 * @param id
	 *            稿件id
	 * @return 计算出的稿件顺序 计算方法: 距离2000-10-12的天数*10000 + 指定稿件顺序时指定的顺序*1000 +
	 *         稿件id后五位/100 这里为了减少初始稿件顺序时的有效数字个数,只取了稿件id后五位作为标识 考虑到每10万条数据才可能出现重复
	 *         本算法忽略这种可能 不过这是一个潜在问题 有待更好的算法
	 */
	public static double createDisplayOrder(Calendar cd, int daycnt, int ord,
			long id) {
		if (cd == null)
			cd = Calendar.getInstance();

		int nHour = cd.get(Calendar.HOUR_OF_DAY);
		int nMinute = cd.get(Calendar.MINUTE);

		cd.set(Calendar.HOUR_OF_DAY, 0);
		cd.set(Calendar.MINUTE, 0);
		cd.set(Calendar.SECOND, 0);
		cd.set(Calendar.MILLISECOND, 0);

		Calendar dd = Calendar.getInstance();
		dd.set(2000, 9, 12, 0, 0, 0);
		dd.set(java.util.Calendar.HOUR_OF_DAY, 0);
		dd.set(java.util.Calendar.MINUTE, 0);
		dd.set(java.util.Calendar.SECOND, 0);
		dd.set(java.util.Calendar.MILLISECOND, 0);

		long tt = cd.getTimeInMillis() - dd.getTimeInMillis();
		// System.out.println(tt/86400);
		double ret = 0;

		ret = (long) ((double) (tt) / 8640.0) + daycnt * 10000 + (double) ord
				* 1000 + (double) nHour * 10.0 + (double) nMinute * 0.1
				+ (double) (id % 100000) * 0.000001;

		return ret;
	}

	public static int isNewArticle(Connection conn ,String docid, long nodeid) {
		int bResult = 0;
		if (docid == null || "".equals(docid))
			return bResult;
		try {
			String sql = "select articleid from releaselib where importid="
				+ StringValueUtils.getLong(docid, 0)
				+ " and importid<>'0' and masterid="
				+ nodeid
				+ " order by importid asc";
			bResult = DBUtil.getIntFromDatabase(sql, conn);
		} catch (Exception ex) {
			log.error("", ex);
		} 
		return bResult;
	}

	public static boolean isNumberic(String str) {

		if (str == null) {
			return false;
		}
		int sz = str.length();
		for (int i = 0; i < sz; i++) {
			if (Character.isDigit(str.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}

}
