package com.examples.java.factorymethod;

import java.util.Scanner;

public class GenerateBill {
	public static void main(String[] args) {
		GetPlanFactory getPlanFactory = new GetPlanFactory();
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter the plan name as [DOMESTIC, COMMERCIAL, INSTITUTIONAL]");
		Plan p = getPlanFactory.getPlan(s.next());
		p.getRate();
		System.out.println("Enter the number of units consumed till as on ");
		p.calculateBill(s.nextInt());
	}

}
