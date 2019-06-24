package com.demo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Countingscript {

	protected static File inFile = null;
	protected static File[] inFiles = null;
	protected static Map<String, String> map = null;
	private static BufferedReader br = null;

	private static File file = null;
	private static List<String> keywords = null;
	
	private static byte[] b = null;
	
	public void execute(File inFile, String version, String dbNm, File outFile)
			throws IOException, ClassNotFoundException {
		String[] fileNms = inFile.list();
		for (String str : fileNms) {
			if (str.endsWith(version)) {
				version = str;
			}
		}

		Countingscript.inFile = new File(inFile + File.separator + version + File.separator + dbNm);
		inFiles = Countingscript.inFile.listFiles();
		for (File file : inFiles) {
			Countingscript.file = file;
			br = new BufferedReader(new FileReader(file));

			countOpt(br);
		}

	}

	public void countOpt(BufferedReader br) throws IOException, ClassNotFoundException {
		String str = "";
		DataInputStream dis = new DataInputStream(new FileInputStream(Countingscript.file));
		b = new byte[dis.available()];
		dis.read(b, 0, b.length);
		dis.close();
		String tabNm = "";
		String[] splitStr;

		List<String> table = new ArrayList<String>();

		keywords = new ArrayList<String>();
		keywords.add("INSERT");
		keywords.add("UPDATE");
		keywords.add("DELETE");
		keywords.add("TRUNCA");
		keywords.add("ALTER ");
		keywords.add("CREATE");
		keywords.add("DROP T");

		while ((str = br.readLine()) != null) {
			if (!(str.startsWith("--") && str.startsWith("\t"))) {
				splitStr = str.split("(\\W)*");
				if (str.length() > 6 && keywords.contains(str.substring(0, 6))) {
					if (str.startsWith("UPDATE ") && splitStr.length > 1) {
						tabNm = splitStr[1];
					} else if (splitStr.length > 2) {
						if (splitStr[1].equals("TABLE") || splitStr[1].equals("INDEX") || splitStr[1].equals("INTO"))
							tabNm = splitStr[2];
						else if (splitStr.length > 3)
							tabNm = splitStr[3];
					}

					if (table.contains(tabNm)) {
						continue;
					} else {
						table.add(tabNm);
						process(b, tabNm);
					}
				}
			}
		}
		System.out.println(table.toString());
		br.close();
	}
	
	public void process(byte[] b,String tabNm){
		String str = new String(b);
		int startIdx = 0;
		int CRLF = 0;
		
		/*while((startIdx = str.indexOf(tabNm)) != -1){
			CRLF = str.lastIndexOf("\r\n", startIdx);
			//CRLF+2;
		}*/
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner s = new Scanner(System.in);
		inFile = new File(s.nextLine());
		s.close();
		Countingscript cs = new Countingscript();
		cs.execute(inFile, "2.6.0", "hsql", null);

	}

}
