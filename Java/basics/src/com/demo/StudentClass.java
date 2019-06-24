package com.demo;

public class StudentClass {
	@Override
	public String toString() {
		return "StudentClass [stuId=" + stuId + ", stuName=" + stuName + "]";
	}

	int stuId;
	String stuName;

	StudentClass(int id, String nm) {
		stuId = id;
		stuName = nm;
	}

	public static void main(String[] args) {

		StudentClass stuCls = new StudentClass(1, "hi");
		methodStudent_grt_10(stuCls);
		stuCls = new StudentClass(11, "hello");
		methodStudent_grt_10(stuCls);
	}

	public static StudentClass methodStudent_grt_10(StudentClass stc) {
		if (stc.stuId > 10) {
			System.out.println("if " + stc);

			return stc;
		}
		return null;
	}

}
