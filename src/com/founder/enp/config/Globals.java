/**
 * 
 */
package com.founder.enp.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

import com.founder.enp.info.ChunkInfo;
import com.founder.enp.info.SourceInfo;

/**
 * @author Administrator
 *
 */
public class Globals {
	public static final String PACKAGE_DB = "db";
	public static final String PACKAGE_WEBSERVICE = "webservice";
	
	public static HashMap<String, SourceInfo> connInfoMap= new HashMap<String, SourceInfo>();
	public static ArrayList<ChunkInfo> chunkInfoList = new ArrayList<ChunkInfo>();
	
	public static Timer timer = new Timer();
	
	/**
	 * null和""被判为空字符
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str){
		boolean rv = false;
		if(str == null || str.equals("")){
			rv = true;
		}
		return rv;
	}
}
