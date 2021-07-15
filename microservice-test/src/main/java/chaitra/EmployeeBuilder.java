package chaitra;

import example.Address;

public class EmployeeBuilder {
    static EmployeeBuilder builder = new EmployeeBuilder();
    private  int id;
    private  String name;
    private  double salary;

    protected  String street;
    protected  String city;
    protected  int zipCode;
    protected  String country;

     String  dob;
    
    public  EmployeeBuilder setPersonalDetails(String dob) {
        this.dob = dob;
        return builder;
    }

    public EmployeeBuilder setAddressDetails(String street, String city, int zcode, String country) {
        this.street = street;
        this.city = city;
        this.zipCode = zcode;
        this.country = country;
        return builder;
    }

    public EmployeeBuilder setOtherDetails(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        return builder;
    }
    public Employee build() {
        return new Employee(id, name, salary,
                new Address(street, city, zipCode),
                new PersonalDetails());
    }


}
