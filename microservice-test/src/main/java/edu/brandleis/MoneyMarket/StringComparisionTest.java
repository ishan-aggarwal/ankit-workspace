package edu.brandleis.MoneyMarket;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringComparisionTest {

    /* scanner for user input */
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int str1StartIndex, str2StartIndex, length;
        String str1, str2;
        while (true) {
            try{
                System.out.println("Enter anything to region match and 'exit' to exit.");
                /* scanner for user input whether user wants to compare strings or exit */
                String input = scan.nextLine();

                /* when user chooses to exit */
                if(input.toLowerCase().equalsIgnoreCase("exit")) {
                    System.out.println("Exit.");
                    break;
                }

                /* user chooses to compare */
                System.out.println("String 1: ");
                str1 = scan.nextLine();
                System.out.println("String 2: ");
                str2 = scan.nextLine();

                System.out.println("Start index of string 1: ");
                str1StartIndex = scan.nextInt();

                System.out.println("Start index of string 2: ");
                str2StartIndex = scan.nextInt();

                System.out.println("region match compare length: ");
                length = scan.nextInt();

                System.out.println("Result of region match - " +
                        /* call to region match to compare strings */
                        str1.regionMatches(true, str1StartIndex, str2, str2StartIndex, length));

                scan.nextLine();
            } catch (InputMismatchException ex) {
                System.out.println("Invalid. Try again.");
                scan.next();
                continue;
            }
        }
    }

}
