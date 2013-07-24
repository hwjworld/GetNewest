/**
 * 
 */
package com.founder.enp.source;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.founder.enp.info.ChunkInfo;
import com.founder.enp.info.SourceInfo;
import com.founder.enp.info.WSInfo;
import com.huawen.common.CommonDataForWS;

/**
 * @author Administrator
 *
 */
public class SourceWebService  extends Source {
	
	private static Log log = LogFactory.getLog(SourceWebService.class);
	private static 	Pattern p = Pattern.compile("\\$\\{.*?\\}\\$", Pattern.DOTALL);
	
	 URLConnection conn = null;
	 WSInfo wi = null;
	 String action = null;
	 String xmlfile = null;
	 String params = null;
	 String string4write = "";
	 String nodename4parse = null;
	 
	 boolean error = false;
	 ChunkInfo ci = null;
	 
	protected SourceWebService(SourceInfo si,ChunkInfo ci){
		super(si);
		wi = (WSInfo)si;
		this.ci = ci;
	}

	@Override
	public void close() {
		
	}

	@Override
	public List<Object[]> getData() {
		List<Object[]> list = null;
		if(!error){
			InputStream is = null;
			try {
				is = writeStream();
				String [] result = getArrayListResult(nodename4parse,is);
				if(result != null && result.length>0){
					list = new ArrayList<Object[]>();
					for(int i=0;i<result.length;i++){
						if(!ci.getSeparator().equals("|")){
							result[i] = StringUtils.replace(result[i], "|", ci.getSeparator());
						}
						list.add(new Object[]{result[i]});
					}
				}
				log.info("通过webservice【"+ci.getChunkmark()+"】获取数据成功,获取到【"+result.length+"】条数据");
			} catch (IOException e) {
				log.error("",e);
			} catch (Exception e) {
				log.error("",e);
			}finally{
				IOUtils.closeQuietly(is);
			}
		}
		return list;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setCode(String code) {
		
//		super.setCode(code);
//		String []codes = split(code, "\\|");
//		if(!Globals.isNull(codes[0])){
//			action = codes[0];
//		}
//		if(!Globals.isNull(codes[1])){
//			xmlfile = codes[1];
//		}
//		if(!Globals.isNull(codes[2])){
//			params = codes[2];
//		}
//		if(!Globals.isNull(codes[3])){
//			nodename4parse = codes[3];
//		}
		action = ci.getAction();
		xmlfile = ci.getXmlfile();
		params = ci.getParam();
		nodename4parse = ci.getReturnNodename();
		/*
		 * 处理xml,fill进参数
		 */
		fillParams();
	}
	@Override
	public void open() throws Exception {
		URL url = null;
		if(wi.getUrl()== null || wi.getUrl().equals("")){
			url = new URL(CommonDataForWS.getQLPath());
		}else{
			url = new URL(wi.getUrl());
		}
        conn = url.openConnection();
        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        
        conn.setRequestProperty("Content-Length", Integer.toString(string4write.length()));
        conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        conn.setRequestProperty("SOAPAction","\"http://tempuri.org/"+action+"\"");
	}
	private InputStream writeStream() throws IOException{
		OutputStreamWriter osw = null;
		OutputStream os = null;
		try{
	        os = conn.getOutputStream();
			osw = new OutputStreamWriter(os,"utf-8");
	        osw.write(string4write);
	        osw.flush();
	        osw.close();
		}finally{
			IOUtils.closeQuietly(osw);
			IOUtils.closeQuietly(os);
		}
        return conn.getInputStream();
	}
	
	/**
	 * 取自   InnerCall.getArrayListResult(String nodeName,InputStream is) 
	 * @param nodeName
	 * @param is
	 * @return
	 * @throws Exception
	 */
	public String[] getArrayListResult(String nodeName,InputStream is) throws Exception {
		String[] result = null;
		Document doc;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		doc = db.parse(is);
		NodeList nl = doc.getElementsByTagName(nodeName);
		if(nl!=null&&nl.getLength()>0){
			Node n = nl.item(0);
			NodeList nl1 = n.getChildNodes();
			if(nl1!=null&&nl1.getLength()>0){
				int count = nl1.getLength();
				result = new String[count];
				for(int i=0;i<count;i++){
					Node n1 = nl1.item(i);
					result[i] = n1.getTextContent();
				}
			}
		}
		return result;
	}
	
	/**
	 * 抽取自InnerCall.getMGREOPSoapRequest
	 */
	private void fillParams(){
		InputStreamReader isr = null;
		BufferedReader reader = null;
		InputStream temp = null;
		try{
			temp = getClass().getResourceAsStream("/com/huawen/publishapp/data/webservice/xml/"+xmlfile);
			isr = new InputStreamReader(temp);
			reader = new BufferedReader(isr);
	        String tmp = "";
	        while((tmp = reader.readLine()) != null){
	        	string4write += tmp;
	        }
	        Matcher m = p.matcher(string4write);
			ArrayList<String> list = new ArrayList<String>();
			while(m.find()){
				list.add(m.group());
			}
			String [] param = split(params,",");
			if(param.length != list.size()){
				log.error("检测到【"+ci.getChunkmark()+"】提供的参数与xml中的字段不符合，请检查双方数目");
				error = true;
				return;
			}
			for(int i=0;i<list.size();i++){
				if(param[i].startsWith("\"")&&param[i].endsWith("\""))
					param[i] = param[i].substring(1,param[i].length()-1);
				string4write = StringUtils.replace(string4write, list.get(i), param[i]);
			}
		} catch (IOException e) {
			log.error("",e);
		}finally{
			IOUtils.closeQuietly(reader);
			IOUtils.closeQuietly(isr);
			IOUtils.closeQuietly(temp);
		}
	}
	
	/**
	 * 改自Pattern.split ,以,为分隔，但双引号内的都算不计算在内
	 * @param input
	 * @return
	 */
	public static String[] split(CharSequence input,String regex) {
		Pattern pparam = Pattern.compile(regex);
        int index = 0;
        ArrayList<String> matchList = new ArrayList<String>();
        Matcher m = pparam.matcher(input);
        boolean startQuote = false;
        // Add segments before each match found
        String match = "";
        StringBuilder storestr = new StringBuilder();
        while(m.find()) {
                match = input.subSequence(index, m.start()).toString().trim();
                if((match.startsWith("\"")&&!match.endsWith("\""))||
                		(!match.startsWith("\"")&&match.endsWith("\""))){
                	if(startQuote){
                        storestr.append(regex).append(match);
                        startQuote = false;
                    	matchList.add(storestr.toString());
                    	storestr.delete(0, storestr.length());
                	}else{
                		storestr.append(match);
                		startQuote = true;
                	}
                }else{
                	if(startQuote){
                        storestr.append(regex).append(match);
                	}else{
                    	matchList.add(match.toString());
                	}
            	}
            	index = m.end();
        }
        // If no match was found, return this
        if (index == 0)
            return new String[] {input.toString()};
        
        matchList.add(input.subSequence(index, input.length()).toString());

        // Construct result
        int resultSize = matchList.size();
        String[] result = new String[resultSize];
        return matchList.subList(0, resultSize).toArray(result);
	}
}
