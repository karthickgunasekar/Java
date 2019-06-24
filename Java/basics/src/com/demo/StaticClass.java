package com.demo;

public class StaticClass {

	
	static int i =0;
	int j=0;
	
	static{
		
	}
	public static void main(String[] args) {
		StaticClass sc1 = new StaticClass();
		StaticClass sc2 = new StaticClass();
		sc1.i=1;
		sc2.i=2;
		sc1.j=1;
		sc2.j=2;
		System.out.println(sc1.i);
		System.out.println(sc2.i);
		System.out.println(sc1.j);
		System.out.println(sc2.j);
		
	}
}
