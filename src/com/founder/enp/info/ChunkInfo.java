/**
 * 
 */
package com.founder.enp.info;

/**
 * @author Administrator
 *
 */
public class ChunkInfo {
	private String chunkmark = null;
	private String source = null;
	private String dest = null;
	private String sourcecode = null;
	private int siteid = 1;
	private String destnode = null;
	private int destnodeid = 0;
	private String destfield = null;
	private int interval = 0;
	private String separator = ";";
	private int isDelElse = 0; 
	
	/*  下为webservice需要	 */
	private String action = null;
	private String xmlfile = null;
	private String param = null;
	private String returnNodename = null;
	
	public String getChunkmark() {
		return chunkmark;
	}
	public void setChunkmark(String chunkmark) {
		this.chunkmark = chunkmark;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public String getSourcecode() {
		return sourcecode;
	}
	public void setSourcecode(String sourcecode) {
		this.sourcecode = sourcecode;
	}
	public String getDestnode() {
		return destnode;
	}
	public void setDestnode(String destnode) {
		this.destnode = destnode;
	}
	public int getDestnodeid() {
		return destnodeid;
	}
	public void setDestnodeid(int destnodeid) {
		this.destnodeid = destnodeid;
	}
	public String getDestfield() {
		return destfield;
	}
	public void setDestfield(String destfield) {
		this.destfield = destfield;
	}
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}
	public int getSiteid() {
		return siteid;
	}
	public void setSiteid(int siteid) {
		this.siteid = siteid;
	}
	public String getSeparator() {
		return separator;
	}
	public void setSeparator(String separator) {
		this.separator = separator;
	}
	public int getIsDelElse() {
		return isDelElse;
	}
	public void setIsDelElse(int isDelElse) {
		this.isDelElse = isDelElse;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getXmlfile() {
		return xmlfile;
	}
	public void setXmlfile(String xmlfile) {
		this.xmlfile = xmlfile;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getReturnNodename() {
		return returnNodename;
	}
	public void setReturnNodename(String returnNodename) {
		this.returnNodename = returnNodename;
	}
}
