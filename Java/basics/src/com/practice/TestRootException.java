package com.practice;


import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.xml.sax.SAXException;

public class TestRootException{
	public static void main(String[] args) throws SAXException, IOException {
		ObjectOutputStream objOutStr = null;
		try{
		RootException re = RootException.getOrCreateRootException();
		re.Messages="hi";
		re.Cascadable=false;
		re.Severity="INFO";
		re.FieldId="1";
		re.FieldName="1_F";		
		System.out.println(re);
		XMLEncoder xmlEncoder = null;
		objOutStr = new  ObjectOutputStream(new FileOutputStream("./temp/1.xml"));
		
		//objOutStr.writeObject(re);		
		}catch (Exception e){
			System.err.println(e);
			
		}
		objOutStr.flush();
		objOutStr.close();
		XMLEncoder xmlEncoder = new XMLEncoder(objOutStr);
		xmlEncoder.writeObject(re);
		xmlEncoder.flush();
		xmlEncoder.close();
		CustomSchemaValidator customSchemaValidator = new CustomSchemaValidator();
		customSchemaValidator.validate(objOutStr, "./xsds'/RootException.xsd");

	}
}
