package com.demo;

import java.util.ArrayList;

public class DuplicValRemoveFrmArryLst implements Cloneable {
	static ArrayList<String> als1 = null;
	static ArrayList<String> als2 = null;

	public static void main(String[] args) {
		
		als1 = new ArrayList<String>();
		als1.add("Karthick");
		als1.add("KARTHICK");
		als1.add("Volante");
		als1.add("Technologies");
		als2 = new ArrayList<String>();
		als2.addAll(als1);
		als1.clear();
		als1 = removDuplicateValues(als2);
		System.out.println("Karthick".hashCode()+"="+"".hashCode());
		System.out.println(als1.size());
		
	}

	public static ArrayList<String> removDuplicateValues(ArrayList<String> als) {
		for (int i = 0; i < als.size(); i++) {
			if (als.get(i).hashCode() == als.get(als.size()-1).hashCode()) {
				System.out.println(als.get(i));
				als.remove(i);
			}
		}
		return als;
	}
	@Override
	public void finalize() {
		als1.
	}
}
