/**
 * 
 */
package com.founder.enp.info;

/**
 * @author Administrator
 *
 */
public abstract class SourceInfo {
	private String id = null;
	private String type = null;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
