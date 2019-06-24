package demo.interfaces;

public interface Interface2 {
	public void method2();
	public default void log(String str){
		System.out.println("Interface 2 log value is "+str);
	}

}
