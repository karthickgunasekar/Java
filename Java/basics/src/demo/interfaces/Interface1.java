package demo.interfaces;

public abstract interface Interface1 {
	
	public int LEN_GTH = 0;
	
	public void method1();
	public default void log(String str){
		System.out.println("Interface 1 log value is "+str);
	}
}
