/**
 * 
 */
package com.founder.enp.source;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.founder.enp.info.SourceInfo;



/**
 * @author Administrator
 *
 */
public abstract class Source {
	static HashMap<String, Source> sourceMap = new HashMap<String, Source>();
	String type = null;
	SourceInfo ci = null;
	String code = null;
	protected Source(SourceInfo ci) {
		this.ci = ci;
		this.type = ci.getType();
	}
	/**
	 * 得到Source类型,db / webservice
	 * @return
	 */
	public abstract String getType();
	/** 供执行的代码,db则为sql或，webservice则为参数 */
	public void setCode(String code){
		this.code = code;
	}
	/** 获取数据 */
	public abstract List<Object[]> getData();
	/**
	 * 打开连接或流
	 * @throws SQLException
	 * @throws Exception
	 */
	public abstract void open() throws Exception;
	/**
	 * 关闭连接或流
	 */
	public abstract void close();
}
