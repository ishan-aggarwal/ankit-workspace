package example;

public abstract class Person {
   protected String name;
   protected int id;
   protected Address address;

 
   public Person(String name, int id, Address address) {
       this.name = name;
       this.id = id;
       this.address = address;
   }

  
   public String getName() {
       return name;
   }
  
   public void setName(String name) {
       this.name = name;
   }
  
   public int getId() {
       return id;
   }
   
   public void setId(int id) {
       this.id = id;
   }
   
   public Address getAddress() {
       return address;
   }
   
   public void setAddress(Address address) {
       this.address = address;
   }

   @Override
   public String toString() {
       return "name=" + name + ", id=" + id + ", address=" + address ;
   }
}

