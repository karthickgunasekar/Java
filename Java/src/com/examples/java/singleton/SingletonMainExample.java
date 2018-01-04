package com.examples.java.singleton;

public class SingletonMainExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingletonExample singletonExample1 = SingletonExample.getInstance();
		singletonExample1.str = (singletonExample1.str).toLowerCase();
		System.out.println(singletonExample1.str);
		
		SingletonExample singletonExample2 = SingletonExample.getInstance();
		singletonExample2.str = (singletonExample2.str).toUpperCase();
		System.out.println(singletonExample2.str);
		
		//SingletonExample singletonExample3 = new SingletonExample();
	}

}
