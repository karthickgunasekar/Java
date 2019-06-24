package com.demo;

import java.io.IOException;

public class ConsolePrintClass extends ConsolePrint{
	static ConsolePrintClass cpc;
	
	public static void main(String[] args) throws IOException {
		cpc = new ConsolePrintClass();
		process();
		
		cpc.close1();
		cpc.stop();	
	}
	
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		try {
			cpc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close1() {
		// TODO Auto-generated method stub
		System.out.println("Closed");
	}

}
