package com.generics;

public class DemoGenericClass<T> {
	T t1;
	DemoGenericClass<T> t2;
	
	
	public DemoGenericClass(T t1,DemoGenericClass<T> t2) {
		this.t1=t1;		
		if(null==this.t2)
			t2 = new DemoGenericClass<T>();
			this.t2=t2;
	}
	
	public DemoGenericClass() {
		// TODO Auto-generated constructor stub
	}

	class DemoClass2<S>{
				
	}

}
