/**
 * 处理源得管理
 * 提供各个源的连接池，与chunk的对应
 */
package com.founder.enp.source;

import com.founder.enp.config.Globals;
import com.founder.enp.info.ChunkInfo;
import com.founder.enp.info.SourceInfo;

/**
 * @author Administrator
 *
 */
public class SourceManager {
	private SourceManager() {
	}
	
	public static Source getSource(ChunkInfo ci){
		String id = ci.getSource();
		Source source = null;
		if(Globals.connInfoMap.containsKey(id)){
			SourceInfo si = Globals.connInfoMap.get(id);
			if(si.getType().equalsIgnoreCase(Globals.PACKAGE_DB)){
				source = new SourceDB(si);
			}else if(si.getType().equalsIgnoreCase(Globals.PACKAGE_WEBSERVICE)){
				source = new SourceWebService(si,ci);
			}
		}
		return source;
	}
}
