package kota;

 class Gamma extends Beta  {
	public void b() {
		System.out.println("Gamma b");
		super.b();
	}

	 public void c() {
		 System.out.println("Gamma c");
	 }
}
 
 class Beta  extends Alpha {
	 public void b() {
		 System.out.println("Beta b");
		 a();
	 }
 }
 class Delta extends Beta {
	 public void a() {
		 System.out.println("Delta a");
	 }
	 public void c() {
		 b();
		 System.out.println("Delta c");
	 }
 }
  class Alpha {
	 public void a() {
		 System.out.println("Alha a");
	 }
	 public void b() {
		 System.out.println("Alha b");
	 }
 }
public class Test {
	public static void main(String[] args) {
		Alpha var1= new Gamma();
		Beta var2 = new Delta();
		Alpha var3 = new Beta();
		Object var4= new Beta();
		((Beta)var4).a();
	}
	
	
}