/**
 * 
 */
package com.founder.enp.db;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.founder.enp.config.Globals;
import com.founder.enp.info.ConnectionInfo;

/**
 * @author Administrator
 *
 */
public class ConnectionPoolManager {

	private static HashMap<String, DBConnectionPool> activePools = new HashMap<String, DBConnectionPool>();
	private static Log log = LogFactory.getLog(ConnectionPoolManager.class);
	
	private ConnectionPoolManager() {
	}
	
	/**
	 * 返回指定的id的数据库连接池
	 * @param id 配置文件中指定
	 * @return
	 */
	public static DBConnectionPool getConnectionPool(String id) {
		DBConnectionPool pool = null;
		if(activePools.containsKey(id)){
			pool = (DBConnectionPool)activePools.get(id);
		}else{
			if(Globals.connInfoMap.containsKey(id)){
				ConnectionInfo ci = (ConnectionInfo)Globals.connInfoMap.get(id);
				pool = new DBConnectionPool(ci);
				activePools.put(id, pool);
			}else{
				log.error("未注册的数据库 : "+id);
			}
		}
		return pool;
	}
	public static void closeConnectionPool(DBConnectionPool pool) {
		if(pool != null){
			pool.ShutdownPool();
			activePools.remove(pool.getId());
			log.info("移除连接池:"+pool.getId());
		}
	}
	
	public static void closeAllConnectionPool() {
		Collection<DBConnectionPool>  c = activePools.values();
		Iterator<DBConnectionPool> it = c.iterator();
		while(it.hasNext()){
			DBConnectionPool pool = it.next();
			closeConnectionPool(pool);
		}
	}
	
}
