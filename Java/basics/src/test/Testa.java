package test;

class A{
	int i=11;
	void display() {
		System.out.println(i);
	}
}

class B extends A{
	int i=10;
	B(){
		super.display();
	}
	void display() {
		
		System.out.println(i);
	}
}
public class Testa {
public static void main(String[] args) {
	Testa t = new Testa();
	A b =new B();
	b.display();
	
}
}
