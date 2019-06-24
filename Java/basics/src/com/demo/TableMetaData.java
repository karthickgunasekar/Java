package com.demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableMetaData {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String host = null;
		String port = null;
		String sid = null;
		String user = null;
		String pass = null;
		if (args.length > 4) {
			host = args[0];
			port = args[1];
			sid = args[2];
			user = args[3];
			pass = args[4];
		}
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@" + host + ":" + port + ":" + sid, user, pass);
		DatabaseMetaData dmd = con.getMetaData();
		String[] strArr = { "TABLE" };
		ResultSet tables = dmd.getTables(null, user.toUpperCase(), null, strArr);
		ResultSet columns;
		String tableNm;
		while (tables.next()) {
			System.out.println(tables.getString("TABLE_NAME"));
			tableNm = tables.getString("TABLE_NAME");
			columns = dmd.getColumns(null, user.toUpperCase(), tableNm, null);
			while (columns.next()) {
				System.out.print(columns.getString("COLUMN_NAME"));
				System.out.print("|" + columns.getString("TYPE_NAME"));
				System.out.print("|" + columns.getString("COLUMN_SIZE"));
				System.out.println();
			}
			System.out.println();

		}
	}

}
