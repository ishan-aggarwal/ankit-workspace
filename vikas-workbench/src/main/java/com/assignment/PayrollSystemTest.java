package com.assignment;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class PayrollSystemTest {
	public static void main(String[] args) {
		// create subclass objects

		// Modification : Taking input from user.
		Scanner s = new Scanner(System.in);
		for (;;) {

			System.out.println(" Enter any number to input data from user or 0 to exit.");
			int choice;
			try {
				choice = s.nextInt();

				if (choice == 0) {
					System.out.println("Thank you!!");
					break;
				} else {
					// input from user
					System.out.println("Enter below details for Employee :");
					System.out.println("Enter First Name :");
					String firstName = s.next();

					System.out.print("Enter Last name: ");
					String lastName = s.next();

					System.out.print("Enter Social security number: ");
					String socialSecurityNumber = s.next();

					System.out.print("Enter Weekly Salary: ");
					double weeklySalary = s.nextDouble();

					System.out.print("Enter Wage: ");
					double wage = s.nextDouble();

					System.out.print("Enter Pieces: ");
					int pieces = s.nextInt();

					System.out.print("Enter Hours: ");
					double hours = s.nextDouble();

					System.out.print("Enter Gross Sales: ");
					double grossSales = s.nextDouble();

					System.out.print("Enter Commission rate(Commission rate must be > 0.0 and < 1.0) :");
					double commissionRate = s.nextDouble();

					System.out.print("Enter Base salary: ");
					double baseSalary = s.nextDouble();
					System.out.println();

					SalariedEmployee salariedEmployee = new SalariedEmployee(firstName, lastName, socialSecurityNumber,
							weeklySalary);
					HourlyEmployee hourlyEmployee = new HourlyEmployee(firstName, lastName, socialSecurityNumber, wage,
							hours);
					CommissionEmployee commissionEmployee = new CommissionEmployee(firstName, lastName,
							socialSecurityNumber, grossSales, commissionRate);
					BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee(firstName,
							lastName, socialSecurityNumber, grossSales, commissionRate, baseSalary);

					PieceWorkerEmployee pieceWorkerEmployee = new PieceWorkerEmployee(firstName, lastName,
							socialSecurityNumber, wage, pieces);

					System.out.println("Employees processed individually:");
					// modified all the earnings() methods to getPaymentAmount() method.
					System.out.printf("%n%s%n%s: $%,.2f%n%n", salariedEmployee, "earned",
							salariedEmployee.getPaymentAmount());
					System.out.printf("%s%n%s: $%,.2f%n%n", hourlyEmployee, "earned",
							hourlyEmployee.getPaymentAmount());
					System.out.printf("%s%n%s: $%,.2f%n%n", commissionEmployee, "earned",
							commissionEmployee.getPaymentAmount());
					System.out.printf("%s%n%s: $%,.2f%n%n", basePlusCommissionEmployee, "earned",
							basePlusCommissionEmployee.getPaymentAmount());

					System.out.printf("%s%n%s: $%,.2f%n%n", pieceWorkerEmployee, "earned",
							pieceWorkerEmployee.getPaymentAmount());

					// create four-element Employee array
					Employee[] employees = new Employee[5];

					// initialize array with Employees
					employees[0] = salariedEmployee;
					employees[1] = hourlyEmployee;
					employees[2] = commissionEmployee;
					employees[3] = basePlusCommissionEmployee;
					employees[4] = pieceWorkerEmployee;

					System.out.printf("Employees processed polymorphically:%n%n");

					// generically process each element in array employees
					for (Employee currentEmployee : employees) {
						System.out.println(currentEmployee); // invokes toString

						// determine whether element is a BasePlusCommissionEmployee
						if (currentEmployee instanceof BasePlusCommissionEmployee) {
							// downcast Employee reference to
							// BasePlusCommissionEmployee reference
							BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;

							employee.setBaseSalary(1.10 * employee.getBaseSalary());

							System.out.printf("new base salary with 10%% increase is: $%,.2f%n",
									employee.getBaseSalary());
						}

						System.out.printf("earned $%,.2f%n%n", currentEmployee.getPaymentAmount());
					}

					// get type name of each object in employees array
					for (int j = 0; j < employees.length; j++) {
						System.out.printf("Employee %d is a %s%n", j, employees[j].getClass().getName());
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input..");
				s.next(); //// clear scanner
				continue;
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid Input....");
				continue;
			}
		}
		s.close();

	}
}
