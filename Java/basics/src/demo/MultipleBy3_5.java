package demo;

import java.util.ArrayList;
import java.util.Arrays;

public class MultipleBy3_5 {

	public static void main(String[] args) {

		String a = "1000";
		int inpValue = 0;
		try {
			inpValue = Integer.parseInt(a);
			int i = 3;
			int retVa = 0;
			for (; i < inpValue; i++) {
				if (i % 3 == 0 || i % 5 == 0) {
					retVa += i;
				}
			}
			System.out.println(retVa);
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
		}

	}

}
