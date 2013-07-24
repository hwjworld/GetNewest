/**
 * 
 */
package com.founder.enp.info;

import com.sun.jmx.snmp.Timestamp;

/**
 * @author Administrator
 *
 */
public class ArticleInfo {
	private long articleid = 0;
	private String title = null;
	private String abstrt = null;
	private int publishstate = 0;
	private int attr = 63;
	private Timestamp pubtime = null;
	private double displayorder = 0;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAbstrt() {
		return abstrt;
	}
	public void setAbstrt(String abstrt) {
		this.abstrt = abstrt;
	}
	public long getArticleid() {
		return articleid;
	}
	public void setArticleid(long articleid) {
		this.articleid = articleid;
	}
	public int getPublishstate() {
		return publishstate;
	}
	public void setPublishstate(int publishstate) {
		this.publishstate = publishstate;
	}
	public int getAttr() {
		return attr;
	}
	public Timestamp getPubtime() {
		return pubtime;
	}
	public void setPubtime(Timestamp pubtime) {
		this.pubtime = pubtime;
	}
	public double getDisplayorder() {
		return displayorder;
	}
	public void setDisplayorder(double displayorder) {
		this.displayorder = displayorder;
	}
	public void setAttr(int attr) {
		this.attr = attr;
	}
}