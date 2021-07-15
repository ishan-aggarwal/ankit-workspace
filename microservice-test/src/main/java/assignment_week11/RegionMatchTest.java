package assignment_week11;

import java.util.InputMismatchException;
import java.util.Scanner;

/* class to perform the region match of two strings */
public class RegionMatchTest {

    //scanner object to take user input
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        do{
            try{
                System.out.println("Enter any random number to perform the string regionMatch check or -1 to exit the program.");

                int input = scanner.nextInt();

                switch (input) {
                    case -1:
                        System.exit(0);
                    default:
                        //method which takes user input and so the region match check
                        performMatch();
                        break;
                }
            }
            //catch the exception if user enters invalid input.
            catch (InputMismatchException ex) {
                scanner.next();
                System.out.println("Incorrect input. Lets try again.");
                continue;
            }
        } while (true);
    }

    private static void performMatch() {
        String string1;
        String string2;
        int string1Index;
        int string2Index;
        int compareLength;

        scanner.nextLine();
        System.out.println("Enter input 1: ");
        string1 = scanner.nextLine();
        System.out.println("Enter input 2: ");
        string2 = scanner.nextLine();
        System.out.println("Enter starting index input string 1: ");
        string1Index = scanner.nextInt();
        System.out.println("Enter starting index input string 2: ");
        string2Index = scanner.nextInt();
        System.out.println("Enter the length to be compared: ");
        compareLength = scanner.nextInt();

        System.out.println("Compared the two input strings. Output is : " +
                string1.regionMatches(true, string1Index, string2, string2Index, compareLength));
    }

}
