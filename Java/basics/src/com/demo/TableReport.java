package com.demo;

public class TableReport extends TableDetails{
	
	private static String _version = null;
	private static TableDetails tds = null;
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
	
		getInstances();
		

	}
	public static String get_version() {
		return _version;
	}
	
	public static void set_version(String _version) {
		TableReport._version = _version;
	}
	public static TableDetails getTds() {
		return tds;
	}
	public static void setTds(TableDetails tds) {
		TableReport.tds = tds;
	}

}
