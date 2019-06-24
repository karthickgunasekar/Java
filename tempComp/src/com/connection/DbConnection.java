package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	static Connection conn = null;

	private DbConnection() {
		if (conn == null) {
			try {
				Class.forName("org.hsqldb.jdbcDriver");
				conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9002/", "sa", "");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	public static Connection getInstance() {
		new DbConnection();
		return conn;
	}

	public static void closeInstance() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}
}
