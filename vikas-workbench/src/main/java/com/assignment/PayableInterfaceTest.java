package com.assignment;

import java.util.*;

//Fig. 10.14: PayableInterfaceTest.java
// Payable interface test program processing Invoices and
// Employees polymorphically.
public class PayableInterfaceTest {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		for (;;) {

			System.out.println("Enter any integer to input data from user or 0 to exit.");
			int choice;
			try {
				choice = s.nextInt();
				if (choice == 0) {
					System.out.println("Thank you!!");
					break;
				} else {
					// input from user
					System.out.println("Enter below details for Invoice :");
					System.out.println("Enter Part Number :");
					String partNo = s.next();
					System.out.println("Enter Part Description :");
					String partDesc = s.next();
					System.out.println("Enter Quantity :");
					int quantity = s.nextInt();
					System.out.println("Enter Price per Item :");
					double pricePerItem = s.nextDouble();

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
					System.out.println("Enter pieces: ");
					int pieces = s.nextInt();
					System.out.print("Enter Hours: ");
					double hours = s.nextDouble();
					System.out.print("Enter Gross Sales: ");
					double grossSales = s.nextDouble();
					System.out.print("Enter Commission rate and it must be > 0.0 and < 1.0 :");
					double commissionRate = s.nextDouble();
					System.out.print("Enter Base salary: ");
					double baseSalary = s.nextDouble();
					System.out.println();

					// create six-element Payable array
					// MODIFIED CODE : added new object of HourlyEmployee, CommissionEmployee and
					// BasePlusCommissionEmployee
					Payable[] payableObjects = new Payable[] { new Invoice(partNo, partDesc, quantity, pricePerItem),
							new Invoice(partNo, partDesc, quantity, pricePerItem),
							new SalariedEmployee(firstName, lastName, socialSecurityNumber, weeklySalary),
							new HourlyEmployee(firstName, lastName, socialSecurityNumber, wage, hours),
							new CommissionEmployee(firstName, lastName, socialSecurityNumber, grossSales,
									commissionRate),
							new BasePlusCommissionEmployee(firstName, lastName, socialSecurityNumber, grossSales,
									commissionRate, baseSalary),
							new PieceWorkerEmployee(firstName, lastName, socialSecurityNumber, wage, pieces) };

					System.out.println("Invoices and Employees processed polymorphically:");

					// generically process each element in array payableObjects
					for (Payable currentPayable : payableObjects) {

						// output currentPayable and its appropriate payment amount
						// Final Output printing the PaymentAmount for all the Employee types
						System.out.printf("%n%s %npayment due: $%,.2f%n", currentPayable.toString(), // could invoke
																										// implicitly
								currentPayable.getPaymentAmount());

						if (currentPayable instanceof BasePlusCommissionEmployee) {
							BasePlusCommissionEmployee basePlusCommissionEmployee = (BasePlusCommissionEmployee) currentPayable;
							basePlusCommissionEmployee.setBaseSalary(1.10 * basePlusCommissionEmployee.getBaseSalary());

							System.out.printf("new base salary with 10%% increase is: $%,.2f%n",
									basePlusCommissionEmployee.getBaseSalary());
						}
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input..");
				s.next(); // clear scanner
				continue;
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid Input....");
				continue;
			}

		}
		s.close();
	}
}
