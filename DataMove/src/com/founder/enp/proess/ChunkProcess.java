/**
 * 
 */
package com.founder.enp.proess;

import java.util.List;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.founder.enp.dest.Dest;
import com.founder.enp.dest.DestManager;
import com.founder.enp.info.ChunkInfo;
import com.founder.enp.source.Source;
import com.founder.enp.source.SourceManager;

/**
 * @author Administrator
 *
 */
public class ChunkProcess extends TimerTask implements Proecess {

	private static Log log = LogFactory.getLog(ChunkProcess.class);
	private ChunkInfo ci = null;
	public ChunkProcess(ChunkInfo ci) {
		this.ci = ci;
	}
	@Override
	public void run() {
		long starttime = System.currentTimeMillis();
		log.info("开始获取【"+ci.getChunkmark()+"】的最新数据");
		proess();
		long endtime = System.currentTimeMillis();
		log.info("获取【"+ci.getChunkmark()+"】的最新数据数据，花费【"+(endtime-starttime)/1000+"】秒");
	}

	public void proess() {
		Source source = SourceManager.getSource(ci);
		source.setCode(ci.getSourcecode());
		
		List<Object[]> datas = null;
		try {
			source.open();
			datas = source.getData();
		} catch (Exception e) {
			log.error("",e);
		}finally{
			source.close();
		}
		
		
		if(datas == null){
			log.error("从源取得数据错误,数据:【"+datas+"】");
			return;
		}
		
		
		Dest dest = DestManager.getDest(ci);
		try {
			dest.open();
			dest.save(datas);
		} catch (Exception e) {
			log.error("",e);
		}finally{
			dest.close();
		}
	}

}
