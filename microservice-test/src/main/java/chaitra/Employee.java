package chaitra;

import example.Address;

public class Employee {

    private int id;
    private String name;
    private double salary;

    private Address address;
    private PersonalDetails personalDetails;

    public Employee(int id, String name, double salary, Address address, PersonalDetails personalDetails) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
        this.personalDetails = personalDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
