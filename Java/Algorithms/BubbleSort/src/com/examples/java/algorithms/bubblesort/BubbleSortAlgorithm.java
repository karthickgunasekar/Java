package com.examples.java.algorithms.bubblesort;

import java.util.Comparator;

public class BubbleSortAlgorithm {
	public static void BS(Integer[] array, int len) {
		boolean swap;
		do {
			swap = false;
			// 569237184
			for (int count = 0; count < len - 1; count++) {
				int comp = array[count].compareTo(array[count + 1]);
				if (comp > 0) {
					int temp = array[count];
					array[count] = array[count + 1];
					array[count + 1] = temp;
					swap = true;
				}
			}
			len--;
		} while (swap);
		for (int curArray : array)
			System.out.println(curArray);
	}

	public static void main(String[] args) {
		// 569237184
		int[] numbers = { 5, 6, 9, 2, 3, 7, 1, 8, 4 };
		int valLen = numbers.length;
		Integer[] intClassNum = new Integer[valLen];
		for (int i = 0; i < valLen; i++) {
			intClassNum[i] = numbers[i];
		}
		BS(intClassNum, valLen);
	}
}
