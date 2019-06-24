package com.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Vector;

public class ThreadMainClass extends BasicThreadClass implements Cloneable{

	public static void main(String[] args) throws CloneNotSupportedException {
		BasicThreadClass tmc1 = new BasicThreadClass();
		BasicThreadClass tmc2 = new BasicThreadClass();
		Thread t1 = new Thread(tmc1,"t1");
		Thread t2 = new Thread(tmc2,"t2");
		//t1.start();		
		//t2.start();
		ThreadMainClass t =  new ThreadMainClass();
		System.out.println(t.a);
		t.clone();
		System.out.println((3*0.1f)==0.3f);
		
		
		ArrayList l = new ArrayList();
		System.out.println("initial "+l.hashCode());
		l.add(null);
		l.add(null);l.add(null);l.add(null);l.add(null);
		l.add("hi");
		System.out.println("after "+l.hashCode());
		l.add("hi");
		System.out.println("after 2 "+l.hashCode());
		ListIterator i = l.listIterator();
		for(;i.hasPrevious();) {
			
		}	
		/*
		l = new LinkedList();
		l.add(null);
		l.add(null);l.add(null);l.add(null);l.add(null);
		l.add("hi");*/
		
		Vector v = new Vector();
		v.add(null);
		v.add(null);
		v.add(null);
		v.add(null);
		v.add("hi");

	
		Set s = new LinkedHashSet();
		s.add(null);
		s.add(null);
		s.add(1);
		s.add(1);
	}
}
