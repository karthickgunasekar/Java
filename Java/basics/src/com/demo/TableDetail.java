package com.demo;

public class TableDetail{
	
	private static TableName tn = null;

	public static TableName getTn() {
		return tn;
	}

	public static void setTn(TableName tn) {
		TableDetail.tn = tn;
	}

}
