package com.demo;

public class FinalKeyword {
 String s= null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinalKeyword finalKeyword = new FinalKeyword();
		System.out.println(finalKeyword.strFunc(finalKeyword.s));

	}
	
	public String strFunc(final String s){
			//s = "Hi";
		return s;
	}

}
