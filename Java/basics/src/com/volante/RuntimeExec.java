package com.volante;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class RuntimeExec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "/profile /user:karthick notepad++";
		try {
			Process r = Runtime.getRuntime().exec(new String[] {"runas",s});
			BufferedReader fos = new BufferedReader( new InputStreamReader( r.getInputStream()));
			//fos.flush();
			System.out.println(fos.readLine());
		
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
