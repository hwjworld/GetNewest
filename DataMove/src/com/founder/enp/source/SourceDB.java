/**
 * 
 */
package com.founder.enp.source;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.founder.enp.info.SourceInfo;
import com.founder.enp.util.DBUtil;

/**
 * @author Administrator
 *
 */
public class SourceDB extends Source{
	private static Log log = LogFactory.getLog(SourceDB.class);
	Connection conn = null;
	QueryRunner qrunner = null;
	protected SourceDB(SourceInfo ci ){
		super(ci);
	}
	
	/**
	 * ArrayList记录数，
	 * Object[]字段
	 */
	public List<Object[]> getData() {
		List<Object[]> list = null;
		try {
			list = DBUtil.getQueryList(code, conn); 
		}catch (Exception e) {
			log.error("",e);
		}
		return list;
	}

	public String getType() {
		return type;
	}

	@Override
	public void close() {
		DBUtil.closeAll(conn);
	}

	@Override
	public void open() throws Exception {
		if(conn == null || conn.isClosed())
			conn = DBUtil.getConnection(ci.getId());
	}
}
