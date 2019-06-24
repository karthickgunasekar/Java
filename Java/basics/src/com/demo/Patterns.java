package com.demo;

public class Patterns {
	public static void main(String[] args) {
		int lines = 3;
		for (int i = 0; i < lines; i++) {
			if (i != 0) {
				System.out.print(1);
				for (int j = 0; j < i; j++) {

					System.out.print(2);

				}
			}

			System.out.println(1);

		}

	}
}
