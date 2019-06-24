package com.demo;

public class BasicThreadClass implements Runnable{
	 //volatile 
	int i=0;
	boolean a;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (BasicThreadClass.class){
		for(;i<1000;i++){
			if(i % 5 == 0)
            {
                continue;
            }
			System.out.println(Thread.currentThread().getName() + ": Value of i = "+i);
		}
		}
	}

}
