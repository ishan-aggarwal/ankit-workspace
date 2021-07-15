package com.assignment;

// Fig. 10.8: BasePlusCommissionEmployee.java
// BasePlusCommissionEmployee class extends CommissionEmployee.

public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalary; // base salary per week

	// constructor
	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary) {
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);

		if (baseSalary < 0.0) { // validate baseSalary
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = baseSalary;
	}

	// set base salary
	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0.0) { // validate baseSalary
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		}

		this.baseSalary = baseSalary;
	}

	// return base salary
	public double getBaseSalary() {
		return baseSalary;
	}
	
	//removing earnings method and providing implementation of getPaymentAmount() method.
	//Copyning the implementation of earnings() method  here.
	@Override
	public double getPaymentAmount() {
		return getBaseSalary() + super.getPaymentAmount();
	}

	// return String representation of BasePlusCommissionEmployee object
	@Override
	public String toString() {
		return String.format("%s %s; %s: $%,.2f", "base-salaried", super.toString(), "base salary", getBaseSalary());
	}
}
