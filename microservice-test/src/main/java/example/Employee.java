package example;

public class Employee extends Person {

   private String ssn;
   private double salary;
  
  
   public Employee(String name, int id, Address address) {
       super(name, id, address);
   }

   public String getSsn() {
       String retVal=null;
       if (ssn.length() > 4)
       {
           retVal = ssn.substring(ssn.length() - 4);
       }
       else
       {
            retVal = ssn;
       }
       return "###-##-" + retVal;
   }

   public void setSsn(String ssn) {
       this.ssn = ssn;
   }

   public double getSalary() {
       return salary;
   }



   public void setSalary(double salary) {
       this.salary = salary;
   }
  

   @Override
   public String toString() {
       return super.toString() + "ssn=" + ssn + ", salary=" + salary ;
   }

}

