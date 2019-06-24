package com.demo;

import java.util.List;

public class TableDetails{
	
	private static TableDetail cls = null;
	private static List<TableDetail> td = null;

	public TableDetails(){
		System.out.println("default constructor TableDetails");	
	}
	
	public static List<TableDetail> getTd() {
		return td;
	}

	public static void setTd(List<TableDetail> td) {
		TableDetails.td = td;
	}

	 public static  List<TableDetail> getInstances() throws InstantiationException, IllegalAccessException{
		 cls = new TableDetail();		
		 td.add(cls);	
		 cls = null;
		 return td;
	 }

}
