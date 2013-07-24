/**
 * 
 */
package com.founder.enp.config;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.founder.enp.info.ChunkInfo;
import com.founder.enp.info.ConnectionInfo;
import com.founder.enp.info.SourceInfo;
import com.founder.enp.info.WSInfo;
import com.founder.enp.util.StringValueUtils;

/**
 * @author Administrator
 * 
 */
public class Init {

	private static Log log = LogFactory.getLog(Init.class);

	private static boolean loaded = false;

	/**
	 * 初始化配置,程序(连接池等等)
	 */
	public static void init() {
		/*
		 * 1.读取db到connInfoMap
		 * 2.读取chunk到chunMap
		 */
		if (!loaded) {
			try {
				readParams();
				log.info("已载入配置，初始化程序成功");
			} catch (Exception e) {
				log.error("载入配置有误，将退出程序。完善配置后再启动。",e);
				System.exit(0);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static void readParams() throws Exception {

		SAXReader reader = new SAXReader();
		Document doc = reader.read(ConfigManager.getConfigFilePath());
		log.info("configFile : " + ConfigManager.getConfigFilePath());
		Element root = doc.getRootElement();
		Element pkEle = root.element("packages");
		for (Iterator it = pkEle.elementIterator("package"); it.hasNext();) {
			Element task = (Element) it.next();
			SourceInfo info = null;
			String type = getTextTrim(task, "type");
			if(type.equalsIgnoreCase(Globals.PACKAGE_DB)){
				ConnectionInfo ci = new ConnectionInfo();
				ci.setId(getTextTrim(task, "id"));
				ci.setType(type);
				ci.setDriver(getTextTrim(task, "driver"));
				ci.setUrl(getTextTrim(task, "url"));
				ci.setUserName(getTextTrim(task, "username"));
				ci.setPassWord(getTextTrim(task, "password"));
				addPoolInfo(ci);
				info = ci;
			}else if(type.equalsIgnoreCase(Globals.PACKAGE_WEBSERVICE)){
				WSInfo wsi = new WSInfo();
				wsi.setId(getTextTrim(task, "id"));
				wsi.setType(type);
				wsi.setUrl(getTextTrim(task, "url"));
				info = wsi;
			}
			Globals.connInfoMap.put(info.getId(), info);
		}
		for (Iterator it = root.elementIterator("chunk"); it.hasNext();) {
			Element task = (Element) it.next();
			ChunkInfo ci = new ChunkInfo();
			ci.setChunkmark(getTextTrim(task, "chunkmark"));
			ci.setSource(getTextTrim(task, "source"));
			ci.setDest(getTextTrim(task, "dest"));
			ci.setSourcecode(getTextTrim(task, "sourcecode"));
			ci.setSiteid(StringValueUtils.getInt(getTextTrim(task,
					"site")));
			ci.setDestnode(getTextTrim(task, "destnode"));
			ci.setDestnodeid(StringValueUtils.getInt(getTextTrim(task,
					"destnodeid")));
			ci.setDestfield(getTextTrim(task, "destfield"));
			ci.setSeparator(getTextTrim(task, "separator"));
			ci.setInterval(StringValueUtils
					.getInt(getTextTrim(task, "interval")));
			ci.setIsDelElse(StringValueUtils
					.getInt(getTextTrim(task, "isDelElse")));

			//webservice
			ci.setAction(getTextTrim(task, "action"));
			ci.setXmlfile(getTextTrim(task, "xmlfile"));
			ci.setParam(getTextTrim(task, "param"));;
			ci.setReturnNodename(getTextTrim(task, "returnNodename"));
			
			Globals.chunkInfoList.add(ci);
		}
	}

	private static String getTextTrim(Element task, String name) {
		String rv = null;
		try{
			rv = task.element(name).getTextTrim();
		}catch (Exception e) {
			if(!name.equals("action")
					&& !name.equals("xmlfile")
					&& !name.equals("param")
					&& !name.equals("returnNodename"))
				log.error("取【"+name+"】 参数出错");
		}
		return rv;
	}

	private static void addPoolInfo(ConnectionInfo ci){
		ci.setInitialSize("1");
		ci.setMinIdle("1");
		ci.setMaxIdle("3");
		ci.setMaxActive("20");
		ci.setMaxWait("10000");
		ci.setLogAbandoned(true);
		ci.setRemoveAbandoned(true);
		ci.setRemoveAbandonedTimeout(200);
	}
}
