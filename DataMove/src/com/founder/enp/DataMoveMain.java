/**
 * 
 */
package com.founder.enp;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.founder.enp.config.ConfigManager;
import com.founder.enp.config.Globals;
import com.founder.enp.config.Init;
import com.founder.enp.db.ConnectionPoolManager;
import com.founder.enp.info.ChunkInfo;
import com.founder.enp.proess.ChunkProcess;

/**
 * @author Administrator
 *
 */
public class DataMoveMain {

	private static Log log = LogFactory.getLog(DataMoveMain.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(!checkArgs(args).equals("stop")){
			if(!checkMessage()){
				Init.init();
				new DataMoveMain().startMove();
				checkMessage(0);
			}
		}
	}
	
	/**
	 * 
	 * @param num 检查的次数
	 */
	private static void checkMessage(int num){
		if(num<=0){
			while(true){
				if(checkMessage()){
					break;
				}
			}
		}else{
			for(int i=0;i<num;i++){
				checkMessage();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private static boolean checkMessage(){
		boolean rv = false;
		try {
			Collection c = FileUtils.listFiles(new File(ConfigManager.getHome()), FileFilterUtils.nameFileFilter("stop") , null);
			if(c.size()>0	){
				shutdown();
				FileUtils.deleteQuietly((File)c.iterator().next());
				rv = true;
			}else{
				Thread.sleep(5000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return rv;
	}
	
	private static String checkArgs(String[] args){
		String rv = "other";
		if(args.length>0){
			if(args[0].equalsIgnoreCase("stop")){
				try {
					FileUtils.writeStringToFile(new File(ConfigManager.getHome()+"/stop"), "1");
					log.info("已发送结束程序消息");
				} catch (IOException e) {
					log.error("发送停止消息异常",e);
				}
				rv = "stop";
			}
		}
		return rv;
	}
	private void startMove(){
		for(int i=0;i<Globals.chunkInfoList.size();i++){
			ChunkInfo ci = Globals.chunkInfoList.get(i);
			if(ci.getInterval()>0){
				Globals.timer.schedule(new ChunkProcess(ci), 0, ci.getInterval()*1000);
			}
		}
	}
	
	public static void shutdown(){
		log.info("检测到停止程序消息");
		Globals.timer.cancel();
		Globals.timer.purge();
		try{
    		while(true){
        		ThreadGroup tg = Thread.currentThread().getThreadGroup();
        		tg.checkAccess();
        		Thread[] tlist = new Thread[tg.activeCount()];
        		tg.enumerate(tlist);
        		boolean hasActive = false;
        		for(int i=0;i<tlist.length;i++){
        			Thread t = tlist[i];
					try {
						/*
						 * 因为可能这个线程上面去取时还在跑，到这就跑完了
						 */
						if(t != null){
							if(t.getName().startsWith("Timer")){
	    						hasActive = true;
								Thread.sleep(2000);
							}else if(t.getName().equalsIgnoreCase("main")){
								continue;
							}
						}
					} catch (InterruptedException e) {}
					break;
        		}
        		if(!hasActive){
        			break;
        		}
    		}
    		ConnectionPoolManager.closeAllConnectionPool();
		}catch (SecurityException e) {
			log.error(e.getMessage(),e);
		}
		log.info("程序安全关闭");
	}
}
