package com.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;

public class FieldValue {

	static File file = null;
	static FileInputStream fis = null;
	static FileOutputStream fos = null;

	public File readFile(String filePath) {
		file = new File(filePath);
		return file;
	}

	public void subDir(File[] files) {
		for (File f1 : files) {
			if (f1.isDirectory()) {
				File temp = new File(file.getAbsolutePath() + File.separator + f1.getName());
				subDir(temp.listFiles());
			} else {
				process(f1);
			}

		}

	}

	public void process(File f1) {
		try {
			fis = new FileInputStream(new File(f1.getAbsolutePath()));
			try {
				int i = fis.available();

				byte[] b = new byte[i];
				fis.read(b, 0, b.length);
				String str = new String(b);
				String finalVal = str.substring(0, str.length());
				fis.close();
				changeValue(finalVal, f1.getAbsolutePath());

			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	public void changeValue(String values, String filePath) {
		int i1 = values.indexOf("<Amt Ccy=\"", 0);
		int i2 = values.indexOf("</Amt>", i1);
		while (i1 > 0 && i2 > 0) {
			values = values.replace(values.substring(i1 + 15, i2), "10.00");
			i1 = values.indexOf("<Amt Ccy=\"", i2);
			i2 = values.indexOf("</Amt>", i1);
		}
		try {
			fos = new FileOutputStream(new File(filePath));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			fos.write(values.getBytes());
			fos.flush();
			fos.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Date date = new Date();
		long timeLong = date.getTime();
		Time t = new Time(timeLong);
		System.out.println(t.toString());
		FieldValue fv = new FieldValue();
		fv.readFile("G:/Volante/Projects/CBJ/RTGS_CBJ_V2.6/RTGS_CBJ/samples/MXMT/");
		File[] files = file.listFiles();

		fv.subDir(files);
		System.out.println(t.toString());
	}

}
