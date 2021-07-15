package assignment_10_1;

import java.util.InputMismatchException;
import java.util.Scanner;

// Fig. 10.1: TestRunner.java
// Assigning superclass and subclass references to superclass and subclass variables.
public class TestRunner {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        //running loop until user choose to exit
//        while (true) {
//            System.out.println("Please choose from the below options.");
//            System.out.println("-> Enter any number to run the example.");
//            System.out.println("-> Enter 0 to Exit.");
//            int input;
//            try {
//                input = sc.nextInt();
//
//                switch (input) {
//                    case 0:
//                        System.out.println("You pressed Exit.");
//                        break;
//                    default:
//                        System.out.println("Creating Employee object:");
//                        sc.nextLine();
//                        System.out.print("First name- ");
//                        String firstName = sc.nextLine();
//                        System.out.print("Last name- ");
//                        String lastName = sc.nextLine();
//                        System.out.print("Social security number- ");
//                        String socialSecurityNumber = sc.nextLine();
//
//                        System.out.print("Commission rate- ");
//                        double commissionRate = sc.nextDouble();
//
//                        System.out.print("Gross sales- ");
//                        double grossSales = sc.nextDouble();
//
//                        System.out.print("Base salary- ");
//                        double baseSalary = sc.nextDouble();
//
//                        // assign superclass reference to superclass variable
//                        CommissionEmployee commissionEmployee = new CommissionEmployee(firstName, lastName,
//                                socialSecurityNumber, grossSales, commissionRate);
//
//                        // invoke toString on superclass object using superclass variable
//                        System.out.printf("%s %s:%n%n%s%n%n", "Calling CommissionEmployee's toString with superclass reference ",
//                                "to superclass object", commissionEmployee.toString());
//
//                        // assign subclass reference to subclass variable
//                        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee(firstName, lastName,
//                                socialSecurityNumber, grossSales, commissionRate, baseSalary);
//
//                        // invoke toString on subclass object using subclass variable
//                        System.out.printf("%s %s:%n%n%s%n%n", "Calling BasePlusCommissionEmployee's toString with subclass",
//                                "reference to subclass object", basePlusCommissionEmployee.toString());
//
//                        System.out.println("Now, setting the base plus commission employee object in commission employee object.");
//                        // invoke toString on subclass object using superclass variable
//                        CommissionEmployee newCommissionEmployee = basePlusCommissionEmployee;
//                        System.out.printf("%s %s:%n%n%s%n", "Calling BasePlusCommissionEmployee's toString with superclass",
//                                "reference to subclass object", newCommissionEmployee.toString());
//                }
//            } catch (InputMismatchException e) {
//                sc.next();
//                System.out.println("Please enter valid input!");
//                continue;
//            }
//        }
//    }
}