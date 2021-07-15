package assignment;

import java.util.InputMismatchException;
import java.util.Scanner;

//Test main class
public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //loop until user enter 0
        while (true) {
            int userInput;
            System.out.println("----Dynamic Polymorphism-------");
            System.out.print("Enter any number to input or enter 0 to exit - ");
            try {
                userInput = sc.nextInt();

                switch (userInput) {
                    case 0:
                        System.out.println("Bye!!");
                        break;
                    default:
						sc.nextLine();
                        System.out.println("Creating Employee object:");
                        System.out.print("Enter first name - ");
                        String firstName = sc.nextLine();
                        System.out.print("Enter last name- ");
                        String lastName = sc.nextLine();
                        System.out.print("Enter social security number- ");
                        String socialSecurityNumber = sc.nextLine();

                        System.out.print("Enter commission rate- ");
                        double commissionRate = sc.nextDouble();

                        System.out.print("Enter gross sales- ");
                        double grossSales = sc.nextDouble();

                        System.out.print("Enter base salary- ");
                        double baseSalary = sc.nextDouble();

                        //assigning parent object to parent variable
                        CommissionEmployee commissionEmployee = new CommissionEmployee(firstName, lastName,
                                socialSecurityNumber, grossSales, commissionRate);

                        //calling toString on superclass object using superclass variable
                        System.out.printf("%s %s:%n%n%s%n%n", "Calling CommissionEmployee's toString with superclass reference ",
                                "to superclass object", commissionEmployee.toString());

                        //assigning child object to child variable
                        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee(firstName, lastName,
                                socialSecurityNumber, grossSales, commissionRate, baseSalary);

                        //calling toString on subclass object using subclass variable
                        System.out.printf("%s %s:%n%n%s%n%n", "Calling BasePlusCommissionEmployee's toString with subclass",
                                "reference to subclass object", basePlusCommissionEmployee.toString());

                        System.out.println("Changing the reference variable of the child's object to parent's reference variable.");
                        // calling toString on subclass object using superclass variable
                        CommissionEmployee newCommissionEmployee = basePlusCommissionEmployee;
                        System.out.printf("%s %s:%n%n%s%n", "Calling BasePlusCommissionEmployee's toString with superclass",
                                "reference to subclass object", newCommissionEmployee.toString());
                }
            } catch (InputMismatchException e) {
                System.out.println("Sorry!! Enter valid input!");
				sc.next();
                continue;
            }
        }
    }
}