/****************
 创建数据库连接
****************/

package com.huawen.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {
	/**
	 * Get the connection to the MySQL db.
	 * @author wang hongwei
	 * @return Conncetion obj to the DataBase
	 * @exception Exception if open connection error
	 */
	public static Connection getMysqlConnection() throws Exception {
		String hostIP = "localhost";
		int port = 3306;
		String dbName = "biz_base";
		String userName = "appone";
		String userPwd = "gCcfDXW5";
		//String userName = "hongwei.wang";
		//String userPwd = "scSY4KFd";
		Class.forName("com.mysql.jdbc.Driver");
		StringBuffer dburl = new StringBuffer("jdbc:mysql://");
		dburl.append(hostIP);
		dburl.append(":");
		dburl.append(port);
		dburl.append("/");
		dburl.append(dbName);
		dburl.append("?connectTimeout=60000&autoReconnect=true&useUnicode=true&characterEncoding=gbk&user=");
		dburl.append(userName);
		dburl.append("&password=");
		dburl.append(userPwd);
		DriverManager.setLoginTimeout(10);//设置超时时间
		return DriverManager.getConnection(dburl.toString());
	}
	
	/**
	 * Get the connection to the MySQL db.
	 * @author wang hongwei
	 * @return Conncetion obj to the DataBase
	 * @exception Exception if open connection error
	 */
	public static Connection getArticleMysqlConnection() throws Exception {
		String hostIP = "10.39.10.65";
		int port = 3306;
		String dbName = "biz_data_center";
		String userName = "appone";
		String userPwd = "gCcfDXW5";
		Class.forName("com.mysql.jdbc.Driver");
		StringBuffer dburl = new StringBuffer("jdbc:mysql://");
		dburl.append(hostIP);
		dburl.append(":");
		dburl.append(port);
		dburl.append("/");
		dburl.append(dbName);
		dburl.append("?connectTimeout=60000&autoReconnect=true&useUnicode=true&characterEncoding=gbk&user=");
		dburl.append(userName);
		dburl.append("&password=");
		dburl.append(userPwd);
		DriverManager.setLoginTimeout(10);//设置超时时间
		return DriverManager.getConnection(dburl.toString());
	}
	
	/**
	 * 取得财经网站的数据库连接
	 * @author qi haifeng
	 * @return Conncetion obj to the DataBase
	 * @exception Exception if open connection error
	 */
	public static Connection getFinanceConnection() throws Exception {
		//String hostIP = "10.39.10.145";
		String hostIP = "172.22.222.3";
		int port = 3306;
		String userName = "web";
		String userPwd = "123456";
		String dbName = "fin_web_site";
		
		Class.forName("com.mysql.jdbc.Driver");
		StringBuffer dburl = new StringBuffer("jdbc:mysql://");
		dburl.append(hostIP);
		dburl.append(":");
		dburl.append(port);
		dburl.append("/");
		dburl.append(dbName);
		dburl.append("?connectTimeout=60000&autoReconnect=true&useUnicode=true&characterEncoding=gbk&user=");
		dburl.append(userName);
		dburl.append("&password=");
		dburl.append(userPwd);
		DriverManager.setLoginTimeout(10);//设置超时时间
		return DriverManager.getConnection(dburl.toString());
	}
	/**
	 * @author liyanna
	 * 北京mysql数据库连接
	 * @return Connection
	 * @throws Exception
	 */
	public static Connection getConnection_bj()throws Exception{
		String hostIP = "localhost";
		int port = 3306; 
		String userName = "appone";
		String userPwd = "gCcfDXW5";
		String dbName = "fin_web_data";
		
		Class.forName("com.mysql.jdbc.Driver");
		StringBuffer dburl = new StringBuffer("jdbc:mysql://");
		dburl.append(hostIP);
		dburl.append(":");
		dburl.append(port);
		dburl.append("/");
		dburl.append(dbName);
		dburl.append("?autoReconnect=true&useUnicode=true&characterEncoding=gbk&user=");
		dburl.append(userName);
		dburl.append("&password=");
		dburl.append(userPwd);
		DriverManager.setLoginTimeout(10);//设置超时时间
		return DriverManager.getConnection(dburl.toString());
	}
	/**
	 * @author liyanna
	 * 深圳mysql数据库连接
	 * @return Connection
	 * @throws Exception
	 */
	public static Connection getConnection_sz()throws Exception{
		String hostIP = "210.21.218.195";
		int port = 3306; 
		String userName = "hwzx_bj";
		String userPwd = "SZ090616huawen";
		String dbName = "fund";
		
		Class.forName("com.mysql.jdbc.Driver");
		StringBuffer dburl = new StringBuffer("jdbc:mysql://");
		dburl.append(hostIP);
		dburl.append(":");
		dburl.append(port);
		dburl.append("/");
		dburl.append(dbName);
		dburl.append("?autoReconnect=true&useUnicode=true&characterEncoding=gbk&user=");
		dburl.append(userName);
		dburl.append("&password=");
		dburl.append(userPwd);
		DriverManager.setLoginTimeout(10);//设置超时时间
		return DriverManager.getConnection(dburl.toString());
	}
	/**
	 * 本地数据库地址
	 * 本地测试用
	 * @return Connection
	 * @throws Exception
	 */
	public static Connection getConnection_native() throws Exception {
		String hostIP = "172.22.222.3";
		int port = 3306;
		String userName = "yanna.li";
		String userPwd = "123456";
		String dbName = "fin_web_data";
		
		Class.forName("com.mysql.jdbc.Driver");
		StringBuffer dburl = new StringBuffer("jdbc:mysql://");
		dburl.append(hostIP);
		dburl.append(":");
		dburl.append(port);
		dburl.append("/");
		dburl.append(dbName);
		dburl.append("?autoReconnect=true&useUnicode=true&characterEncoding=gbk&user=");
		dburl.append(userName);
		dburl.append("&password=");
		dburl.append(userPwd);
		DriverManager.setLoginTimeout(10);//设置超时时间
		return DriverManager.getConnection(dburl.toString());
	}
	/**
	 * 北京那边数据库地址
	 * 本地测试用
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection_field() throws Exception {
		String URL="jdbc:jtds:sqlserver://129.0.10.140:1433/DB40_NEW;USER=bj;PASSWORD=beijing;characterEncoding=GBK";
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Connection conn=DriverManager.getConnection(URL);
		return conn;	
	}
	public static Connection getFinanceConnection_native() throws Exception {
		String hostIP = "172.22.222.3";
		int port = 3306;
		String userName = "yanna.li";
		String userPwd = "123456";
		String dbName = "fin_web_site";

		Class.forName("com.mysql.jdbc.Driver");
		StringBuffer dburl = new StringBuffer("jdbc:mysql://");
		dburl.append(hostIP);
		dburl.append(":");
		dburl.append(port);
		dburl.append("/");
		dburl.append(dbName);
		dburl.append("?connectTimeout=60000&autoReconnect=true&useUnicode=true&characterEncoding=gbk&user=");
		dburl.append(userName);
		dburl.append("&password=");
		dburl.append(userPwd);
		DriverManager.setLoginTimeout(10);//设置超时时间
		return DriverManager.getConnection(dburl.toString());
	}
	/**
	 * 取得财经网站的数据库连接
	 * @author qi haifeng
	 * @return Conncetion obj to the DataBase
	 * @exception Exception if open connection error
	 */
	public static Connection getFinanceConnection_test() throws Exception {
		String hostIP = "202.108.218.59";
		int port = 3306;
		String userName = "haifeng.qi";
		String userPwd = "ZwjT7maT";
		String dbName = "fin_web_site";

		Class.forName("com.mysql.jdbc.Driver");
		StringBuffer dburl = new StringBuffer("jdbc:mysql://");
		dburl.append(hostIP);
		dburl.append(":");
		dburl.append(port);
		dburl.append("/");
		dburl.append(dbName);
		dburl.append("?autoReconnect=true&useUnicode=true&characterEncoding=gbk&user=");
		dburl.append(userName);
		dburl.append("&password=");
		dburl.append(userPwd);
		return DriverManager.getConnection(dburl.toString());
	}
	public static Connection getFinanceConnection_test2() throws Exception {
		String hostIP = "10.39.10.144";
		int port = 3306;
		String userName = "ning.qi";
		String userPwd = "iIBj8zRe6Efy";
		String dbName = "fin_web_site";

		Class.forName("com.mysql.jdbc.Driver");
		StringBuffer dburl = new StringBuffer("jdbc:mysql://");
		dburl.append(hostIP);
		dburl.append(":");
		dburl.append(port);
		dburl.append("/");
		dburl.append(dbName);
		dburl.append("?autoReconnect=true&useUnicode=true&characterEncoding=gbk&user=");
		dburl.append(userName);
		dburl.append("&password=");
		dburl.append(userPwd);
		return DriverManager.getConnection(dburl.toString());
	}
	/**
	 * 取得财经网站的查询数据库连接(只查询，不更新)
	 * @author qi haifeng
	 * @return Conncetion obj to the DataBase
	 * @exception Exception if open connection error
	 */
	public static Connection getQueryConnection() throws Exception {
		String hostIP = "10.39.10.20";
		int port = 3306;
		String userName = "appthree";
		String userPwd = "gCcfDXW5";
		String dbName = "fin_web_site";

		Class.forName("com.mysql.jdbc.Driver");
		StringBuffer dburl = new StringBuffer("jdbc:mysql://");
		dburl.append(hostIP);
		dburl.append(":");
		dburl.append(port);
		dburl.append("/");
		dburl.append(dbName);
		dburl.append("?autoReconnect=true&useUnicode=true&characterEncoding=gbk&user=");
		dburl.append(userName);
		dburl.append("&password=");
		dburl.append(userPwd);
		return DriverManager.getConnection(dburl.toString());
	}

	/**
	 * 取得聚源的数据库连接
	 * @author qi haifeng
	 * @return Conncetion obj to the DataBase
	 * @exception Exception if open connection error
	 */
	public static Connection getJunyuanConnection() throws Exception {
		String URL="jdbc:jtds:sqlserver://210.21.218.200:1863/ZqsbWebDb;USER=bjuser;PASSWORD=bjuser123";
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Connection conn=DriverManager.getConnection(URL);
		return conn;	
	}
	
	/**
	 * 取得聚源的数据库连接
	 * @author zhangzhouhua
	 * @return Conncetion obj to the DataBase
	 * @exception Exception if open connection error
	 */
	public static Connection getJunyuanConnection2() throws Exception {
		String URL="jdbc:jtds:sqlserver://129.0.10.137:1433/JYDB;USER=test;PASSWORD=test123";
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		Connection conn=DriverManager.getConnection(URL);
		return conn;	
	}
	
	/**
	 * Get the connection to the SQL Server db.
	 * @author wang hongwei
	 * @return Conncetion obj to the DataBase
	 * @exception Exception if open connection error
	 */
	public static Connection getMSSQLConnection() throws Exception {
		//String mssqlUser = "sa";
		//String mssqlPassword = "X8I4cpQL";
		String mssqlUser = "sa";
		String mssqlPassword = "8350166683501666";
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		//StringBuffer mssqlDburl = new StringBuffer("jdbc:jtds:sqlserver://202.108.59.132:28080/info_source;characterEncoding=GBK");
		//StringBuffer mssqlDburl = new StringBuffer("jdbc:jtds:sqlserver://210.21.218.199:1863/info_source;characterEncoding=GBK");
		StringBuffer mssqlDburl = new StringBuffer("jdbc:jtds:sqlserver://10.39.10.172:7001/info_source;characterEncoding=GBK");
		return DriverManager.getConnection(mssqlDburl.toString(), mssqlUser, mssqlPassword);
	}
	
	/**
	 * Get the connection to the remote SQL Server db.
	 * @author wang hongwei
	 * @return Conncetion obj to the DataBase
	 * @exception Exception if open connection error
	 */
	public static Connection getRemoteMSSQLConnection() throws Exception {
		String mssqlUser = "sa";
		String mssqlPassword = "5tgb^YHN";
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		StringBuffer mssqlDburl = new StringBuffer("jdbc:jtds:sqlserver://10.39.10.172:7001/ComDataCenter;characterEncoding=GBK");
		return DriverManager.getConnection(mssqlDburl.toString(), mssqlUser, mssqlPassword);
	}
	
	/**
	 * Get the connection to the remote Oracle db.
	 * @author wang hongwei
	 * @return Conncetion obj to the DataBase
	 * @exception Exception if open connection error
	 */
	public static Connection getRemoteOracleConnection() throws Exception {
		String oracleUser = "mpuser";
		String oraclePassword = "mp";
		String oracleUrl = "jdbc:oracle:thin:@210.21.218.194:1521:mp";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(
				oracleUrl,oracleUser,oraclePassword);
	}
	
	/**
	 * 获取图像数据库
	 * @return
	 * @throws Exception
	 */
	public static Connection getPicConnection() throws Exception {
		String URL="jdbc:jtds:sqlserver://121.15.5.179:1433/Noah;USER=cxj;PASSWORD=cxjtpk123";
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		DriverManager.setLoginTimeout(10);//设置超时时间
		Connection conn=DriverManager.getConnection(URL);
		return conn;	
	}
  
	/**
	 * SqlServer数据库连接
	 * @author wanghm
	 * */
	public static Connection getSqlServerConn() {

		try{			
			String mssqlUser = "business";
			String mssqlPassword = "lou34&90k";
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			StringBuffer mssqlDburl = new StringBuffer("jdbc:jtds:sqlserver://58.68.134.7:1433/BusinessData;characterEncoding=GBK");
			return DriverManager.getConnection(mssqlDburl.toString(), mssqlUser, mssqlPassword);			
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Mysql数据库连接
	 * @author	wanghm
	 * */
	public static Connection getMysqlConn(){
		try{
			Connection con = null;
			String mySqlcon = "com.mysql.jdbc.Driver";
			String username = "haiming.wang";
			String password = "sN8B5cjd";
			String url = "jdbc:mysql://58.68.134.69:3306/biz_base?useUnicode=true&characterEncoding=gbk";
			Class.forName(mySqlcon);
			con = DriverManager.getConnection(url, username, password);
			return con;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
	}
	
	
	/**
	 * Mysql数据库连接
	 * @author	wanghm
	 * */
	public static Connection getMysqlConn2(){
		try{
			Connection con = null;
			String mySqlcon = "com.mysql.jdbc.Driver";
			String username = "haiming.wang";
			String password = "sN8B5cjd";
			String url = "jdbc:mysql://10.39.10.144:3306/blog_data_center?userUnicode=true&characterEncoding=gbk";
			Class.forName(mySqlcon);
			con = DriverManager.getConnection(url, username, password);
			return con;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Mysql数据库连接
	 * @author	zhangzhouhua
	 * */
	public static Connection getMysqlConn3(){
		try{
			Connection con = null;
			String mySqlcon = "com.mysql.jdbc.Driver";
			String username = "root";
			String password = "123456";
			String url = "jdbc:mysql://127.0.0.1:3306/organ_media?useUnicode=true&characterEncoding=gbk";
			Class.forName(mySqlcon);
			con = DriverManager.getConnection(url, username, password);
			return con;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * SqlServer数据库连接
	 * @author wanghm
	 * */
	public static Connection getSqlServerConn2() {

		try{			
			String mssqlUser = "sa";
			String mssqlPassword = "5tgb^YHN";
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			StringBuffer mssqlDburl = new StringBuffer("jdbc:jtds:sqlserver://202.108.218.53:7001/blog_data_center;characterEncoding=GBK");
			return DriverManager.getConnection(mssqlDburl.toString(), mssqlUser, mssqlPassword);			
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Lucene索引Mysql数据库连接
	 * @author	wang hongwei
	 * */
	public static Connection getLuceneMySQLConn(){
		try{
			Connection con = null;
			String mySqlcon = "com.mysql.jdbc.Driver";
			String username = "lucene";
			String password = "qqqcfDXW5";
			String url = "jdbc:mysql://10.39.10.145:3306/news?userUnicode=true&characterEncoding=gbk";
			Class.forName(mySqlcon);
			con = DriverManager.getConnection(url, username, password);
			return con;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Get the connection to the MySQL db.
	 * @author wanghm
	 * @return Conncetion obj to the DataBase
	 * @exception Exception if open connection error
	 */
	public static Connection getMysqlConnection2() throws Exception {
		String hostIP = "10.39.10.65";
		int port = 3306;
		String dbName = "blog_data_center";
		String userName = "appone";
		String userPwd = "gCcfDXW5";
		//String userName = "hongwei.wang";
		//String userPwd = "scSY4KFd";
		Class.forName("com.mysql.jdbc.Driver");
		StringBuffer dburl = new StringBuffer("jdbc:mysql://");
		dburl.append(hostIP);
		dburl.append(":");
		dburl.append(port);
		dburl.append("/");
		dburl.append(dbName);
		dburl.append("?connectTimeout=60000&autoReconnect=true&useUnicode=true&characterEncoding=gbk&user=");
		dburl.append(userName);
		dburl.append("&password=");
		dburl.append(userPwd);
		DriverManager.setLoginTimeout(10);//设置超时时间
		return DriverManager.getConnection(dburl.toString());
	}
	/**
	 * SqlServer数据库连接
	 * @author wanghm
	 * */
	public static Connection getGovSqlServerConn() {

		try{			
			String mssqlUser = "business";
			String mssqlPassword = "lou34&90k";
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			StringBuffer mssqlDburl = new StringBuffer("jdbc:jtds:sqlserver://58.68.134.15:1433/PartOrgan;characterEncoding=GBK");
			return DriverManager.getConnection(mssqlDburl.toString(), mssqlUser, mssqlPassword);			
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * SqlServer数据库连接，连接政务的人物库和机构库
	 * @author wanghm
	 * */
	public static Connection getGovPeopleSqlServerConn() {

		try{			
			String mssqlUser = "wanghaiming";
			String mssqlPassword = "sw%whm~9";
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			StringBuffer mssqlDburl = new StringBuffer("jdbc:jtds:sqlserver://58.68.134.6:1433/GovClass;characterEncoding=GBK");
			return DriverManager.getConnection(mssqlDburl.toString(), mssqlUser, mssqlPassword);			
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 取得聚源的数据库连接 正式数据库
	 * @author qi haifeng
	 * @return Conncetion obj to the DataBase
	 * @exception Exception if open connection error
	 */
	public static Connection getSZJunyuanConnection(){
		try{
			String user = "szuser";
			String ps = "szuser";
			String URL = "jdbc:jtds:sqlserver://58.68.134.85/JYDB;characterEncoding=GBK";
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL,user,ps);
			System.out.println("连接成功");
			return conn;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}

