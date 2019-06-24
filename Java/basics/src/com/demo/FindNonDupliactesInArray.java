package com.demo;

public class FindNonDupliactesInArray {
	public static void main(String[] args) {
		int[] a = { 1, 5, 1 };
		boolean flag = false;
		int len=a.length-1;
		int ones =0, twos =0;
		int common_bit_mask;
		for (int i = 0; i < a.length; i++) {
			
			twos = twos | (ones & a[i]); 
			//System.out.println((ones & a[i]));
			//System.out.println(twos | (ones & a[i]));
			ones = ones ^ a[i];
			//System.out.println(ones ^ a[i]);
			common_bit_mask = ~(ones & twos);
			System.out.println(ones+"="+twos);
			
		}
	}
}
