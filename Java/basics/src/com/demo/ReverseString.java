package com.demo;

public class ReverseString {
	public static void main(String[] args) {
		String str = "Hello";
		String retVal = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			retVal += str.charAt(i);
		}
		System.out.println(retVal);
		retVal = null;
		if(retVal!=null)
		System.out.println(retVal.substring(0));
	}
}
