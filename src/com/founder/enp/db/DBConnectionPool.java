package com.founder.enp.db;

import java.sql.Connection;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.founder.enp.info.ConnectionInfo;


/**
 * 定义一个连接池
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: 北大方正电子有限公司数字媒体事业部 翔宇组</p>
 *
 * @author hwj
 * @version 1.0
 */
public class DBConnectionPool {
	
	private static Log log = LogFactory.getLog(DBConnectionPool.class);
	
	private String id = null;
	private String driver = null;
	private String url = null;
	private String userName = null;
	private String passWord = null;
	private String initialSize = null;			//初始化连接数
	private String minIdle = null;				//最小空闲连接
	private String maxIdle = null;				//最大空闲连接
	private String maxWait = null;				//超时回收时间(以毫秒为单位)
	private String maxActive = null;				//最大连接数
	private boolean logAbandoned = true;		//是否在自动回收超时连接的时候打印连接的超时错误
	private boolean removeAbandoned = true;		//是否自动回收超时连接
	private int removeAbandonedTimeout = 300;		//超时时间(以秒数为单位)

	private BasicDataSource dataSource = null;
	private ConnectionInfo ci = null;
    
    protected DBConnectionPool(ConnectionInfo ci){
    	this.ci = ci;
    	loadProperties();
    	log.info("创建新数据库池,id="+id);
    }
    
    public ConnectionInfo getConnectionInfo() {
    	return ci;
	}
	/**
	 * 启动连接池
	 * 
	 * */
	protected void startPool(){
		initDataSource();
	}

	/**
	 * 释放连接池
	 * 
	 * */
	protected void ShutdownPool(){
		try{
			if(dataSource!=null){
				dataSource.close();
				dataSource = null;
				log.info("关闭连接池："+ci.getId());
			}
		}catch(Exception e){
			log.error("",e);
		} 
	}
	
	@SuppressWarnings("deprecation")
	private  void initDataSource(){
		if(dataSource==null){
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driver);
	        dataSource.setUrl(url);
	        dataSource.setUsername(userName);
	        dataSource.setPassword(passWord);
	        dataSource.setInitialSize(Integer.parseInt(initialSize));
	        dataSource.setMinIdle(Integer.parseInt(minIdle));
	        dataSource.setMaxIdle(Integer.parseInt(maxIdle));
	        dataSource.setMaxWait(Long.parseLong(maxWait));
	        dataSource.setMaxActive(Integer.parseInt(maxActive));
	        dataSource.setLogAbandoned(logAbandoned);
	        dataSource.setRemoveAbandoned(removeAbandoned);
	        dataSource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
			log.info("启动连接池："+ci.getId());
		}
	}

	private void loadProperties(){
		id = ci.getId();
		driver = ci.getDriver();
		url = ci.getUrl();
		userName = ci.getUserName();
		passWord = ci.getPassWord();
		initialSize = ci.getInitialSize();
		minIdle = ci.getMinIdle();
		maxIdle = ci.getMaxIdle();
		maxWait = ci.getMaxWait();
		maxActive = ci.getMaxActive();
		logAbandoned = ci.isLogAbandoned();
		removeAbandoned = ci.isRemoveAbandoned();
		removeAbandonedTimeout = ci.getRemoveAbandonedTimeout();
	}
	
	/**
	 * 取得一个连接
	 * 
	 * */
	public Connection getConnection() throws Exception{
		if(dataSource==null){
			startPool();
		}
		return dataSource.getConnection();
	}
	
	/**
	 * 释放一个连接
	 * 
	 * */
	public void freeConnection(Connection conn) throws Exception{
		if(conn != null)
			conn.close();
	}
	
	/**
	 * 取得连接池中活跃的连接数
	 * 
	 * */
	public int getNumActive() throws Exception{
		return dataSource.getNumActive();
	}
	
	/**
	 * 取得连接池中等待的连接数
	 * 
	 * */
	public int getNumIdle() throws Exception{
		return dataSource.getNumIdle();
	}
	
	/**
	 * 取得连接池中最大连接数
	 * 
	 * */
	public int getMaxActive() throws Exception{
		return dataSource.getMaxActive();
	}
	
	/**
	 * 取得连接池中最大等待连接数
	 * 
	 * */
	public int getMaxIdle() throws Exception{
		return dataSource.getMaxIdle();
	}
	
	public String getId() {
		return id;
	}
}
