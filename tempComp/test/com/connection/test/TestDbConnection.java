package com.connection.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.connection.DbConnection;

public class TestDbConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection dbc = DbConnection.getInstance();
		System.out.println(dbc);
		Connection dbc1 = DbConnection.getInstance();
		System.out.println(dbc1);
		try {
			System.out.println(dbc.isClosed());
			Connection dbc2 = DbConnection.getInstance();
			System.out.println(dbc2);
			DbConnection.closeInstance();
			System.out.println(dbc.isClosed());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
