package com.demo;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.HashSet;

public class DuplicateStringArray {

	public static void main(String[] args) {
		ArrayList<String> dsa = new ArrayList<String>();
		dsa.add("Arun");
		dsa.add("Arun Kumar");
		dsa.add("Arun Mohan");
		dsa.add("Karthick");
		dsa.add("Karthick Arun");
		dsa.add("Arun");

		findDuplicate(dsa);
	}

	public static void findDuplicate(ArrayList<String> al) {
		HashSet s = new HashSet();
		for (int i = 0; i < al.size(); i++) {

			if (al.get(i).hashCode() == al.get(al.size() - 1).hashCode()) {
				s.add(al.get(i));
			}
		}
		System.out.println(s.iterator().next());
	}
}
