package com.founder.enp.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConnectionManager {
	private static Log log = LogFactory.getLog(ConnectionManager.class);

	private static ConnectionManager _connectionManager = null;

	private ConnectionManager() throws SQLException {
	}

	public static ConnectionManager getInstance() throws SQLException {
		if (_connectionManager == null) {
			_connectionManager = new ConnectionManager();
		}
		return _connectionManager;
	}

	public Connection getConnection(String id) throws Exception {
		Connection conn = null;
		try {
			conn = ConnectionPoolManager.getConnectionPool(id).getConnection();
		} catch (Exception e) {
			log.error("取得数据库连接异常", e);
		}
		return conn;
	}
}
