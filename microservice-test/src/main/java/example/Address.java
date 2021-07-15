package example;

public class Address {
  
   protected String street;
   protected String city;
   protected int zipCode;
   protected String country;
   
   
  
   public Address(String street, String city, int zipCode) {
	super();
	this.street = street;
	this.city = city;
	this.zipCode = zipCode;
	this.country = "USA";
}


   public String getStreet() {
       return street;
   }
   
   public void setStreet(String street) {
       this.street = street;
   }
   
  
   public String getCity() {
       return city;
   }
   
   public void setCity(String city) {
       this.city = city;
   }
   
   public int getZipCode() {
       return zipCode;
   }
   
   public void setZipCode(int zipCode) {
       this.zipCode = zipCode;
   }
  
   public String getCountry() {
       return country;
   }
   
   public void setCountry(String country) {
       this.country = country;
   }
  
   @Override
   public String toString() {
       return "street=" + street + ", city=" + city + ", zipCode=" + zipCode + ", country=" + country ;
   }

}
