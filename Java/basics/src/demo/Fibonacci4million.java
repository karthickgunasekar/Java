package demo;

import java.util.ArrayList;

public class Fibonacci4million {
	public static void main(String[] args) {
		int value = 4000000;
		ArrayList<Integer> arrL = new ArrayList<Integer>();	
		// 1 1 2 3 5 8 13 21 34 55 89
		int temp = 1;
		int val = 0;
		for (int i = 0; i < 10; i++) {			
			val +=temp;
			temp = val;
			System.out.println(val);
		}
		
	}

}
