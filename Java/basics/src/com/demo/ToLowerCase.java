package com.demo;

import java.util.Scanner;

public class ToLowerCase {

	public static Scanner scanner = null;
	public int T = 0;

	public String[] scan() throws AssertionError {
		if (scanner == null)
			scanner = new Scanner(System.in);
		T = scanner.nextInt();
		String strVal[] = new String[T];
		boolean Tflag = T <= 100;
		if (Tflag) {
			for (int i = 0; i < T; i++) {
				String temp = scanner.next();
				if (exponential(temp.length(), 10, 3)) {
					strVal[i] = temp;
				} else {
					try {
						throw new Exception("The length of the provided String is greater than the Constraints");
					} catch (Exception e) {
						e.printStackTrace();

					}
				}

			}

		} else {
			throw new AssertionError("Input is greater than 100 as test case values which isn't permissible");

		}
		return strVal;
	}

	public void display(String[] strVal) {

		for (String retStrVal : strVal) {
			if (retStrVal != null)
				System.out.println(retStrVal.toLowerCase());
		}

	}

	public boolean exponential(int value, int base, int exp) {
		long valueExp = (long) Math.pow(base, exp);
		return value <= valueExp;
	}

	public static void main(String[] args) throws AssertionError {
		ToLowerCase toLowerCase = new ToLowerCase();
		String strVal[] = toLowerCase.scan();

		if (strVal.length > 0)
			toLowerCase.display(strVal);

	}
}
