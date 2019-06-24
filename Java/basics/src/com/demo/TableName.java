package com.demo;

public class TableName {
	
	private static String _name = null;
	private static int _create = 0;
	private static int _alter = 0;
	private static int _update = 0;
	private static int _insert = 0;
	private static int _truncate = 0;
	private static int _delete = 0;
	private static int _drop = 0;
	
	public static String get_name() {
		return _name;
	}
	public static void set_name(String _name) {
		TableName._name = _name;
	}
	public static int get_create() {
		return _create;
	}
	public static void set_create(int _create) {
		TableName._create = _create;
	}
	public static int get_alter() {
		return _alter;
	}
	public static void set_alter(int _alter) {
		TableName._alter = _alter;
	}
	public static int get_update() {
		return _update;
	}
	public static void set_update(int _update) {
		TableName._update = _update;
	}
	public static int get_insert() {
		return _insert;
	}
	public static void set_insert(int _insert) {
		TableName._insert = _insert;
	}
	public static int get_truncate() {
		return _truncate;
	}
	public static void set_truncate(int _truncate) {
		TableName._truncate = _truncate;
	}
	public static int get_delete() {
		return _delete;
	}
	public static void set_delete(int _delete) {
		TableName._delete = _delete;
	}
	public static int get_drop() {
		return _drop;
	}
	public static void set_drop(int _drop) {
		TableName._drop = _drop;
	}

}
