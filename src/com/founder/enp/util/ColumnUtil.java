/*
 * Copyright (c) 2005,北大方正电子有限公司集成系统开发部
 * All rights reserved.
 *
 * 摘要：翔宇稿源库栏目的操作类。
 *
 * 当前版本：1.0
 * 作者：齐明
 *
 */
package com.founder.enp.util;

import java.sql.Connection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class ColumnUtil {

	private static Log log = LogFactory.getLog(ColumnUtil.class);
	
	/**
	 * 判断在指定的父节点下是否存在指定名称的节点
	 * 
	 * @param parentID
	 *            父节点的ID
	 * @param nodeName
	 *            节点名称
	 * @return 存在 true 不存在 false
	 */
	/*
	 * public static boolean existNode(long parentID, String nodeName) throws
	 * Exception { boolean exist = false; Connection conn = null;
	 * PreparedStatement pstmt = null; ResultSet rs = null; try { pstmt =
	 * conn.prepareStatement("select nodeid from oritypestruct where typename=?
	 * and parentid=? "); pstmt.setString(1, nodeName); pstmt.setLong(2,
	 * parentID); rs = pstmt.executeQuery(); if(rs.next()) exist = true; }
	 * finally { DBUtil.closeAll(conn, pstmt, rs); } return exist; }
	 */

	/**
	 * 创建稿源库的栏目节点
	 * 
	 * @param parentID
	 *            父ID
	 * @param nodeName
	 *            节点名
	 * @param siteID
	 *            站点ID
	 * @param conn
	 *            数据库连接
	 * @return 节点ID
	 * @throws Exception
	 */
	public static long createNode(Connection conn,long parentID,long rootId, String nodeName, int siteID,int lib) throws Exception {
		long nodeID = 0;
		String sSQL = "";
		try {
			if (lib == 1) {
				sSQL = "select SEQ_ORITYPESTRUCT.nextVal from dual";
				nodeID = DBUtil.getLongFromDatabase(sSQL,conn);
				if(nodeID<=0){
					throw new Exception("从序列里获取栏目Id时出错，NodeId = "+nodeID);
				}
				sSQL = "insert into oritypestruct (nodeid, typename, parentid, oridate, siteid) values(?,?,?,sysdate,?)";
				Object[] param = new Object[]{nodeID,nodeName,parentID,siteID};
				DBUtil.executeSql(conn, sSQL, param);
			} else {
				sSQL = "select SEQ_TYPESTRUCT.nextVal from dual";
				nodeID = DBUtil.getLongFromDatabase(sSQL,conn);
				if(nodeID<=0){
					throw new Exception("从序列里获取栏目Id时出错，NodeId = "+nodeID);
				}
				if(parentID == 0 && rootId == -1){
					rootId = nodeID;
				}
				String sql = "SELECT max(DISPLAYORDER) AS MINDISPLAYORDER FROM TYPESTRUCT WHERE PARENTID="
						+ parentID;
				double db = DBUtil.getDoubleFromDatabase(sql, conn);
				db += 1;
				sSQL = "insert into typestruct (nodeid, nodename, parentid,rootid,displayorder, issuedate, siteid,specialnode) values(?,?,?,?,?,sysdate,?,0)";
				Object[] param = new Object[]{nodeID,nodeName,parentID,rootId,db,siteID};
				DBUtil.executeSql(conn, sSQL, param);
			}
		}catch(Exception e){
			log.error("",e);
			throw e;
		}
		return nodeID;
	}

	/**
	 * 创建稿源库的栏目节点
	 * 
	 * @param parentID
	 *            父ID
	 * @param nodeName
	 *            节点名
	 * @param siteID
	 *            站点ID
	 * @param conn
	 *            数据库连接
	 * @return 节点ID
	 * @throws Exception
	 */
	public static long createType(Connection conn,long parentID, String nodeName, int siteID,
			int lib) throws Exception {
		long nodeID = 0;
		String sSQL = "";
		try {
			nodeID = getID("cmsad.typestruct", conn);
			sSQL = "insert into typestruct (nodeid, nodename, parentid, issuedate, siteid,specialnode,deletetime,falsenode) values(?,?,?,now(),?,0,date('2000-01-01'),'1')";
			Object[] param = new Object[]{nodeID,nodeName,parentID,siteID};
			DBUtil.executeSql(conn, sSQL, param);
		} catch (Exception e) {
			log.error("",e);
		}
		return nodeID;
	}

	public static int getID(String tablename, Connection conn) {
		int iRet = -1;
		String sSQL = null;
		try {
			sSQL = "update cmspub.maxidadmin set maxid = maxid+1 where tablename = '"
					+ tablename + "'";
			DBUtil.executeSql(conn, sSQL);
			sSQL = "SELECT maxid FROM cmspub.maxidadmin where tablename = '"
					+ tablename + "'";
			iRet = DBUtil.getIntFromDatabase(sSQL, conn);
		} catch (Exception ex) {
			log.error("",ex);
		}
		return iRet;
	}

	/**
	 * 获得在指定的父节点下指定名称的节点的ID
	 * 
	 * @param parentID
	 *            父节点的ID
	 * @param nodeName
	 *            节点名称
	 * @param siteID
	 *            站点ID
	 * @param conn
	 *            数据库连接
	 * @param lib
	 *            是哪个库 1 源稿库 2 发布库
	 * @return 存在 节点ID 不存在 -1
	 */
	public static long getNodeID(Connection con,long parentID, String nodeName, int siteID,
			int lib) throws Exception {
		long nodeID = -1;
		String sSQL = "";
		String parentStr = "";
		if (parentID <= 0)
			parentStr = " and (parentid <=0 or parentid is null)";
		else
			parentStr = " and parentid =" + parentID;

		if (lib == 1) {
			sSQL = "select nodeid from oritypestruct where typename='"
					+ nodeName + "' and siteid = " + siteID + parentStr;
			sSQL += " and delflag=0";
		} else {
			sSQL = "select nodeid from typestruct where nodename='" + nodeName
					+ "' and siteid = " + siteID + parentStr;
			sSQL += " and (deletetime <= to_date('2000-1-1','yyyy-mm-dd') or deletetime is null) and specialnode = 0";
		}
		nodeID = DBUtil.getLongFromDatabase(sSQL, con);
		
		return nodeID;
	}

	/**
	 * 获得在指定的父节点下指定名称的节点的ID
	 * 
	 * @param parentID
	 *            父节点的ID
	 * @param nodeName
	 *            节点名称
	 * @param siteID
	 *            站点ID
	 * @param conn
	 *            数据库连接
	 * @param lib
	 *            是哪个库 1 源稿库 2 发布库
	 * @return 存在 节点ID 不存在 -1
	 */
	public static long getTypeID(Connection conn,long parentID, String nodeName, int siteID,
			int lib) throws Exception {
		long nodeID = 0;
		String sSQL = "";
		String parentStr = "";
		if (parentID <= 0)
			parentStr = " and (parentid <=0 or parentid is null)";
		else
			parentStr = " and parentid =" + parentID;

		if (lib == 1) {
			sSQL = "select nodeid from oritypestruct where typename='"
					+ nodeName + "' and siteid = " + siteID + parentStr;
			sSQL += " and delflag=0";
		} else {
			sSQL = "select nodeid from typestruct where nodename='" + nodeName
					+ "' and siteid = " + siteID + parentStr;
			sSQL += " and (deletetime <= date('2000-1-1') or deletetime is null)";
		}
		nodeID = DBUtil.getLongFromDatabase(sSQL, conn);
		return nodeID;
	}

	public static boolean nodeExists(Connection con,long nodeid, int libtype) throws Exception {
		boolean bResult = true;
		if (nodeid < 0)
			return false;
		String tablename = "";
		if (libtype == 1)
			tablename = "oritypestruct";
		else
			tablename = "typestruct";
		String sSQL = "select count(9) from " + tablename + " where nodeid="
				+ nodeid;

		bResult = DBUtil.getLongFromDatabase(sSQL, con)>0;
		return bResult;

	}

	public static long syncTypeStruct(Connection con,String targetNode, int siteId,
			String defaulValue) {
		long currID = -1;
		long rootId = -1;
		if (targetNode == null || targetNode.trim().length() < 1)
			targetNode = defaulValue;
		String[] nodes = targetNode.split("~");
		String currNode;
		long parentid = 0;
		for (int i = 0, j = nodes.length; i < j; i++) {
			currNode = nodes[i];
			try {
				currID = ColumnUtil.getNodeID(con,parentid, currNode, siteId, 2);
				if (currID <= 0) {
					currID = ColumnUtil.createNode(con,parentid, rootId, currNode,
							siteId, 2);
				}
				if (i == 0) {
					rootId = currID;
				}
				parentid = currID;
			} catch (Exception ex) {
				log.error("", ex);
			}
		}
		return currID;
	}
}
