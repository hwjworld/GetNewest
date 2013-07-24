/**
 * 
 */
package com.founder.enp.dest;

import com.founder.enp.config.Globals;
import com.founder.enp.info.ChunkInfo;
import com.founder.enp.info.ConnectionInfo;
import com.founder.enp.info.SourceInfo;

/**
 * @author Administrator
 *
 */
public class DestManager {
	private DestManager(){
		
	}
	public static Dest getDest(ChunkInfo chunkinfo){
		Dest dest = null;
		String id = chunkinfo.getDest();
		if(Globals.connInfoMap.containsKey(id)){
			SourceInfo info = Globals.connInfoMap.get(id);
			if(info.getType().equalsIgnoreCase(Globals.PACKAGE_DB)){
				ConnectionInfo ci = (ConnectionInfo)info;
				dest = new DestCMS4(ci,chunkinfo);
			}
		}
		return dest;
	}
}
