package example;

public class Student extends Person {

   private double gpa;

   //Constructor
   public Student(String name, int id, Address address) {
       super(name, id, address);
   }


   public double getGpa() {
       return gpa;
   }

  
   public void setGpa(double gpa) {
       this.gpa = gpa;
   }
  

   @Override
   public String toString() {
       return super.toString() + "gpa=" + gpa + "]";
   }
}