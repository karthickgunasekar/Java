package demo.interfaces;

public class ClassForInterfaces implements Interface1, Interface2{
	static ClassForInterfaces cfi = null;
	public static void main(String[] args) {
		if(null == cfi){
			cfi = new ClassForInterfaces();
			cfi.log("HI");
		}

	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void log(String str) {
		// TODO Auto-generated method stub
		Interface2.super.log(str);
	}
}
