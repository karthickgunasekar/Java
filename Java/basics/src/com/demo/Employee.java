package com.demo;

import java.io.Serializable;

public class Employee implements Serializable{

	private String _Name;
	private int _Age;
	public final String get_Name() {
		return _Name;
	}
	public final void set_Name(String _Name) {
		this._Name = _Name;
	}
	public final int get_Age() {
		return _Age;
	}
	public final void set_Age(int _Age) {
		this._Age = _Age;
	}
	
}
