package aron;

import java.util.Scanner;

public class AlphanumericPasswordChecker {

	private static final String ALPHANUMERIC_PATTERN = "^[a-zA-Z0-9]+$";

	private static boolean isAlphanumeric(String input) {
		return input.matches(ALPHANUMERIC_PATTERN);
	}

	private static String removeNonAlphanumeric(String input) {
		String s = input.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(s);
		return s;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of elements:");
		int n = s.nextInt();

		char[] genericArray = new char[n];

		System.out.println("enter elements:");
		for (int i = 0; i < n; i++) {
			genericArray[i] = s.next().charAt(0);
		}

		// For printing array
		for (char element : genericArray) {
			System.out.print(element);
		}
		System.out.println();

		String input = new String(genericArray);
		System.out.println("Check Input Array isAlphanumeric: " + isAlphanumeric(input));

		String temp = removeNonAlphanumeric(input);
		System.out.println("Final String after removal of non alpha numeric characters: " + temp);

		System.out.println("Check Final String isAlphanumeric: " + isAlphanumeric(temp));
	}
}