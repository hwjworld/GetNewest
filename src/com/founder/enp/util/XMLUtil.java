package com.founder.enp.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class XMLUtil {
	
	//日志
	public static Logger logger = Logger.getLogger(XMLUtil.class.getName());
	
	/**
	 * 解析xmlPath路径下的XML文件，得到这个xml文件的Document对象
	 * 
	 * */
	public static Document loadXML(String xmlPath){
		FileInputStream fi = null;
		Document doc = null;
		try{
			fi = new FileInputStream(xmlPath);
			SAXBuilder sb = new SAXBuilder();
			doc = sb.build(fi);
		}catch(Exception e){
			logger.error("",e);
		}finally{
			try {fi.close();} catch (IOException e) {}
		}
		return doc;
	}
	
	
	/**
	 * 将用集合类封装的Element对象写入到xmlPath路径下的xml文件中
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public static void saveXML(String xmlPath,List<Element> newList){
		FileInputStream fi = null;
		FileOutputStream fo = null;
		try {
			fi = new FileInputStream(xmlPath);
			SAXBuilder sb = new SAXBuilder();
			Document doc = sb.build(fi);
			Element root = doc.getRootElement(); 				// 得到根元素
			List<Element> nodeList = root.getChildren(); 		// 得到根元素所有子元素的集合
			nodeList.addAll(newList);
			doc = sb.build(fi);
			XMLOutputter outp = new XMLOutputter();
			fo = new FileOutputStream(xmlPath);
			outp.output(doc, fo);
		} catch (Exception e) {
			logger.error("",e);
		}finally{
			try {fi.close();} catch (IOException e) {}
			try {fo.close();} catch (IOException e) {}
		}	
	}

	
	/**
	 * 提取系统配置参数
	 * 
	 * @param 	name
	 *            	String类型，参数值的名称
	 * @param	xmlFilePath
	 * 				String类型，配置文件路径
	 * @param	xmlFilePath
	 * 				XML配置文件的路径 
	 * 
	 * @return 	String 系统参数值
	 */
	public static String getConfigProperty(String name,String xmlFilePath) {
		XMLProperties properties = new XMLProperties(xmlFilePath);
		return properties.getProperty(name);
	}
	
	
	/**
	 * 设置系统配置参数
	 * 
	 * @param 	name
	 *            	参数名称
	 * @param 	value
	 *           	参数值
	 * @param	xmlFilePath
	 * 				XML配置文件的路径
	 * 
	 * @return	
	 */
	public static void setConfigProperty(String name, String value, String xmlFilePath) {
		XMLProperties properties = new XMLProperties(xmlFilePath);
		properties.setProperty(name, value);
	}
	
	
}
