/*
 * Copyright (c) 2005,北大方正电子有限公司集成系统开发部
 * All rights reserved.
 *
 * 摘要：数据库操作的工具类。
 *
 * 当前版本：1.0
 * 作者：齐明
 *
 */
package com.founder.enp.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.founder.enp.db.ConnectionManager;
import com.founder.enp.util.StringValueUtils;

public class DBUtil {
	
	private static Log log = LogFactory.getLog(DBUtil.class);
	private static QueryRunner queryrunner = new QueryRunner();;

	static Statement st = null;

	/**
	 * 获取数据库连接
	 * 
	 * @return 数据库连接
	 */
	public static Connection getConnection(String id) throws Exception {
		return ConnectionManager.getInstance().getConnection(id);
	}

	public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		DbUtils.closeQuietly(conn, stmt, rs);
	}

	public static void closeAll(Connection conn, Statement stmt) {
		closeAll(conn, stmt, null);
	}

	public static void closeAll(Statement stmt, ResultSet rs) {
		closeAll(null, stmt, rs);
	}

	public static void closeAll(Connection conn) {
		closeAll(conn, null);
	}

	public static void closeAll(Statement stmt) {
		closeAll(null, stmt);
	}

	public static List<Object[]> getQueryList(String sql, Connection conn) throws SQLException{
		return getQueryList(sql, null, conn);
	}
	@SuppressWarnings("unchecked")
	public static List<Object[]> getQueryList(String sql,Object[] param, Connection conn) throws SQLException{
		List<Object[]> result =  (ArrayList<Object[]>)queryrunner.query(conn, sql, new ArrayListHandler(),param);
		return result;
	}
	
	public static String getFirstObjStringFromList(List<Object[]> list){
		String rv = null;
		if(list == null || list.size()==0){
			return null;
		}
		try{
			Object [] obj = list.get(0);
			if(obj == null || obj.length==0){
				return null;
			}
            rv = obj[0].toString();
		}catch (Exception e) {
			log.error("",e);
		}
		return rv;
	}
	
	/**
	 * 执行一个只返回一个整型数字的SQL语句 比如：select count(*) from dual
	 * 
	 * @param sql
	 *            SQL语句
	 * @param conn
	 *            数据库连接
	 * @return SQL查询结果
	 */
	public static int getIntFromDatabase(String sql, Connection conn) {
		int ret = 0;
		try {
			ret = StringValueUtils.getInt(getFirstObjStringFromList(getQueryList(sql, conn)));
		} catch (Exception e) {
			log.error("Error SQL: " + sql);
			log.error("",e);
		}
		return ret;
	}
	
	public static double getDoubleFromDatabase(String sql,Connection conn) {
		double ret = 0;
		try {
			ret = StringValueUtils.getDouble(getFirstObjStringFromList(getQueryList(sql, conn)));
		} catch (Exception ex) {
			log.error("Error SQL: " + sql);
			log.error("",ex);
		} 
		return ret;
	}

	/**
	 * 执行一个只返回一个长整型数字的SQL语句 比如：select count(*) from dual
	 * 
	 * @param sql
	 *            SQL语句
	 * @param conn
	 *            数据库连接
	 * @return SQL查询结果
	 */
	public static long getLongFromDatabase(String sql, Connection conn) {
		long ret = 0;
		try {
			ret = StringValueUtils.getLong(getFirstObjStringFromList(getQueryList(sql, conn)));
		} catch (Exception ex) {
			log.error("Error SQL: " + sql);
			log.error("",ex);
		} 
		return ret;
	}

	/**
	 * 执行一条SQL，从数据库中查询一个String的结果
	 * 
	 * @param sql
	 *            数据库sql语句
	 * @param conn
	 *            数据库连接
	 * @return 字符串的结果
	 */
	public static String getStringFromDatabase(String sql, Connection conn) {
		String ret = null;
		try {
			ret = getFirstObjStringFromList(getQueryList(sql, conn));
		} catch (Exception ex) {
			log.error("Error SQL: " + sql.toString());
			log.error("",ex);
		}
		return ret;
	}

	public static int executeSql(Connection conn, String sql) throws SQLException  {
		return queryrunner.update(conn, sql);
	}
	
	public static int executeSql(Connection conn,String sql,Object[] param) throws SQLException{
		return queryrunner.update(conn, sql, param);
	}
	
	public static List<Object[]> query(Connection conn, String sql, Object[] param) throws SQLException{
		return getQueryList(sql, param, conn);
	}
}
