package com.collections;

import java.util.ArrayList;
import java.util.Collection;

public class GenericCollections {

	public static void main(String[] args) {
		Collection<Object> c = new ArrayList<Object>();
		c.add("1");
		c.add(1);
		c.add(1.02);
		c.add(1.202f);
		c.add(1202l);
		
		
	}

}
