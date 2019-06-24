package com.demo;

import java.util.Arrays;


public class ReverseArray {
	public static void main(String[] args) {
		String[] str = { "JAVA", "C++", "C" };
		String[] retStr = new String[5];
		for (int i = str.length - 1; i >= 0; i--) {
			retStr[(str.length) - i - 1] = str[i];
		}
		retStr[3] = "[Str1,Str2]";
		System.out.println(Arrays.deepToString(retStr));
	}

}
