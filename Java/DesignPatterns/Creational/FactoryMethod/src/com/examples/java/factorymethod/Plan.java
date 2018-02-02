package com.examples.java.factorymethod;

public abstract class Plan {
	protected double rate;
	abstract void getRate();
	public void calculateBill(int units){
		System.out.println(units*this.rate);
	}
}
