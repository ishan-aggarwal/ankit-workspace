package com.assignment;

public class PieceWorkerEmployee extends Employee {

	private double wage;
	private int pieces;

	public PieceWorkerEmployee(String firstName, String lastName, String socialSecurityNumber, double wage,
			int pieces) {
		super(firstName, lastName, socialSecurityNumber);

		if (wage < 0.0) {// validate wage
			throw new IllegalArgumentException("Wage must be >= 0.0");
		}

		this.wage = wage;

		if (pieces < 0) {// validate pieces
			throw new IllegalArgumentException("pieces must be >= 0");
		}

		this.pieces = pieces;
	}

	// concrete implementation of earnings method as getPaymentAmount
	@Override
	public double getPaymentAmount() {
		return wage * pieces;
	}

	// return String representation of PieceWorkerEmployee object
	@Override
	public String toString() {
		return String.format("PieceWorker employee: %s%n%s: %d; %s: %,.2f", super.toString(),
				"Number of pieces produced ", this.pieces, "Wage per piece ", this.wage, "Total earnings ",
				getPaymentAmount());
	}

}
