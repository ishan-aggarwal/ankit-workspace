package example;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        Address add1 = new Address("Twin Lane", "Indianapolis", 46237);

        Employee employee1 = new Employee("Tina", 1, add1);
        Employee employee2 = new Employee("Robert", 1, add1);
        Employee employee3 = new Employee("Tucker", 1, add1);
        Employee employee4 = new Employee("Sim", 1, add1);
        Employee employee5 = new Employee("Josh", 1, add1);

        //adding the employees in the list of employees
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        List<Student> students = new ArrayList<>();

        Address address1 = new Address("Main Street", "Anderson", 46239);
        Address address2 = new Address("Sample Street", "Indianapolis", 46237);
        Address address3 = new Address("Emerson Street", "Indinapolis", 46236);
        Address address4 = new Address("Fish Street", "Carmel", 46541);
        Address address5 = new Address("Tucker Street", "Fishers", 46123);

        Student student1 = new Student("Terri", 4, address1);
        student1.setGpa(3.12);
        Student student2 = new Student("Paul", 3, address2);
        student2.setGpa(3.25);
        Student student3 = new Student("Sam", 2, address3);
        student3.setGpa(3.54);
        Student student4 = new Student("Sreena", 7, address4);
        student4.setGpa(3.67);
        Student student5 = new Student("Roman", 9, address5);
        student5.setGpa(3.75);

        //adding the students in the list of students
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);


        //print employee name and salary
        System.out.println("Printing employees:");
        employees.stream()
                .forEach(employee -> System.out.println(employee.getName() + " " + employee.getSalary()));

        System.out.println("-----------------");
        //print student name and gpa
        System.out.println("Printing students:");
        students.stream()
                .forEach(student -> System.out.println(student.getName() + " " + student.getGpa()));

    }

}
