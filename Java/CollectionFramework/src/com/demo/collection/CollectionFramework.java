package com.demo.collection;

import java.util.Iterator;

public class CollectionFramework<Key, Value> implements Iterator<Object> {
	Value v = null;
	Key k = null;
	transient Object[] obj = null;

	public Value get(Key k) {
		this.k = k;
		Object o = null;
		while (hasNext()) {
			if (o == null)
				o = next();
			else
				break;
		}
		System.out.println((Value) o);
		return (Value) o;
	}

	public void put(Key k, Value v) {
		obj = new Object[2];
		obj[0] = k;
		obj[1] = v;
		System.out.println(obj);
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (k != null) {
			return true;
		}
		return false;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		if (k != null) {
			if (k.equals(obj[0])) {
				return obj[1];
			}
		}
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		CollectionFramework<Integer, String> cf1 = new CollectionFramework<Integer, String>();
		cf1.put(1, "Hi");
		CollectionFramework<String, String> cf2 = new CollectionFramework<String, String>();
		cf2.put("1", "Hello");
		cf1.get(1);
		cf2.get("1");
		cf2.put("1","Bye");
		cf2.get("1");
	}

}
