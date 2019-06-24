package demo.interfaces;

import java.util.Vector;

public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<String> x = new Vector<String>();
		Vector<Integer> y = new Vector<Integer>();
		boolean b = x.getClass() == y.getClass();
		System.out.println(x.getClass().getTypeParameters().toString());
		Test tt = new Test();
		System.out.println(tt.test().getClass());
	}
	
	<T extends ClassForInterfaces & Interface1 & Interface2> T test(){
		T t = null;
		
		t.method2();
		
		return t;
	}

}
