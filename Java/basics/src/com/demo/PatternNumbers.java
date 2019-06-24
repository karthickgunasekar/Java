package com.demo;

public class PatternNumbers {

	public static void main(String[] args) {
		for(int i=8;i>0;i=i-2){
			for(int j=i;j>0;j=j-2){
				System.out.print(j);
			}
			System.out.println();
		}
	}
}
