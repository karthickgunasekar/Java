package com.examples.java.singleton;

public class SingletonExample {
	private static SingletonExample singletonExample = null;
	public String str;
	private SingletonExample (){
		str = "Singleton Class Created";
	}
	public static SingletonExample getInstance(){
		if(singletonExample==null)
			singletonExample = new SingletonExample();
		return singletonExample;
	}
}
