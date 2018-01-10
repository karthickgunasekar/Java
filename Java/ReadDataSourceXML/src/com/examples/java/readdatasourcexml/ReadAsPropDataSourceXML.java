package com.examples.java.readdatasourcexml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadAsPropDataSourceXML {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		prop.load(new FileInputStream(args[0]));		
		System.out.println(prop.getProperty("connection-driver"));
		/*for(Object obj : prop.values()){
		//System.out.println(prop.getProperty("connection-driver"));
			System.out.println(obj.toString());
		}*/
	}

}
