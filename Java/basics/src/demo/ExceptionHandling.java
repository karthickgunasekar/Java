package demo;
public class ExceptionHandling extends Exception{ 
	static ExceptionHandling exceptionHandling = new ExceptionHandling();
	
	public static void createExceptionLocally(int a){
		int i =5/a;
		
	}
	
	public static void main(String[] args) {
		try{
		createExceptionLocally(0);
		System.out.println("Inside try block in main");
		}catch(ArithmeticException ae){
			ae.
		}
		System.out.println(exceptionHandling.getMessage());
	}
}