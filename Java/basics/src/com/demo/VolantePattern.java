package com.demo;

public class VolantePattern {

	public static void main(String[] args) {
		int n = 5;
		int i, j = 0;
		for (i = 1; i <= n; i++) {
			for (j = 0; j < i - 1; j++) {
				System.out.print(" ");

			}
			System.out.println("*");

		}
		for (i = n-1; i >= 1; i--) {
			for (j = i*2; j < (i*2)+1; j++) {
				System.out.print(" ");

			}
			System.out.println("*");

		}

	}

}
