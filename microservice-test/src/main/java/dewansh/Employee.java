package dewansh;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {

    private int id;
    private String name;
    private double salary;
    private String designation;

    public Employee(int id, String name, double salary, String designation) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.designation = designation;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", designation='" + designation + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Dewansh", 40000, "Trainee");
        Employee e2 = new Employee(2, "Abhimanyu", 20000, "Developer");
        Employee e3 = new Employee(3, "Yash", 10000, "Trainee");
        Employee e4 = new Employee(4, "Ankit", 60000, "Manager");
        Employee e5 = new Employee(5, "Ishan", 50000, "Developer");

        //array of objects of employee objects
        Employee[] employees = new Employee[5];
        employees[0] = e1;
        employees[1] = e2;
        employees[2] = e3;
        employees[3] = e4;
        employees[4] = e5;

        //converting array of objects to array-list
        List<Employee> employeeList = Arrays.asList(employees);

        //printing list of employees
        employeeList.stream().forEach(emp -> System.out.println(emp.toString()));
        //extracting the employees whose designation is Trainee
        List<Employee> traineeEmployees = employeeList
                .stream()
                .filter(emp -> "Trainee".equals(emp.getDesignation()))
                .collect(Collectors.toList());

        //printing list of employees whose designation is trainee
        traineeEmployees.stream().forEach(emp -> System.out.println(emp.toString()));
        //sort based on salary
        List<Employee> sortedEmployees = employeeList
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())

                .collect(Collectors.toList());

        //printing list of sprted employees based on salary in descending order
        sortedEmployees.stream().forEach(emp -> System.out.println(emp.toString()));
    }

}
