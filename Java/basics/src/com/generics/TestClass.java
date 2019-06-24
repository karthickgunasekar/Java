package com.generics;

import com.generics.TestClass.DemoInnerClass.InterfaceInner;

public class TestClass {

	public static void main(String[] args) {
		DemoGenericClass<String> dgc1 = new DemoGenericClass<String>("t1",null);
		DemoGenericClass<Integer> dgc2 = new DemoGenericClass<Integer>(1,null);
		InterfaceInner ii = (InterfaceInner) new TestClass();

		DemoInnerClass tt = new DemoInnerClass();
		
		
	}
	static class DemoInnerClass{
		public int a =0;
		interface InterfaceInner{
			void start();
		}
	}

}
