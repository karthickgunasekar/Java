package com.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;


public abstract class ConsolePrint implements Consolable {
	private static PrintStream out = System.out;
	private static InputStream in = System.in;
	static byte[] b = new byte[2];

	public void stop() {
	}

	public  static void process() throws IOException {
		in.read(b);		
		int count = in.available();
		in.close();
		// b[0] = (byte) 'A';
		System.out.println("count = " + count);
		int length = new String(b).getBytes().length;
		System.out.println("length = " + new String(b).getBytes().length);
		out.write(new String(b).getBytes(), 0, length);
		out.flush();
		out.close();
		
	}



}
