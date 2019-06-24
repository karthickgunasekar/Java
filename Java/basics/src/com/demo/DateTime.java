package com.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.Date;


public class DateTime {
	public static void main(String[] args) throws ParseException {
		// Date, DateFormat, DateTimeFormatter, DateTimeFormatterBuilder, Calendar, DateFormatSymbols
		Date date = new Date();
		String dateStr = date.toString();
		SimpleDateFormat sdf = new SimpleDateFormat();
		// sdf.applyLocalizedPattern("dd MM yyyy");
		
		sdf.applyPattern("dd/MM/yyyy hh:mm:ss.SSSZ");

		date = sdf.parse("10/11/2018 10:11:12.123+0530");
		sdf.applyPattern("dd MM yyyy'T'hh mm ss SSS X");
		System.out.println(sdf.format(date));
		sdf.applyPattern("dd MM yyyy hh mm ss SSS XX");
		System.out.println(sdf.format(date));
		sdf.applyPattern("dd MM yyyy hh mm ss SSS XXX");
		System.out.println(sdf.format(date));
		String str1 = "Hello World";
		System.out.println(Arrays.deepToString(str1.split("\\S")));
		System.out.println(Arrays.deepToString(str1.split("\\s")));
		
		
		
		
	}

}
