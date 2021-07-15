package aron;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TakeInput {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try{
                System.out.println("\n"+"Select option to continue, to quit use Ctrl+C or Ctrl+D" + "\n" +
                        "1. Add a new book." + "\n" +
                        "2. Search for a book");
                System.out.print("Input:: ");
                String input = scanner.nextLine();

                switch (input) {
                    case "1":
                        System.out.println("You have selected the option to add a book:");
                        System.out.println("Enter the details of the book - ");
                        System.out.print("ISBN: ");
                        String isbn = scanner.nextLine();

                        System.out.print("Title: ");
                        String title = scanner.nextLine();

                        System.out.print("Author: ");
                        String author = scanner.nextLine();

                        System.out.print("Publisher: ");
                        String publisher = scanner.nextLine();

                        System.out.print("Language: ");
                        String language = scanner.nextLine();

                        System.out.print("Price: ");
                        float price = scanner.nextFloat();
                        Book book = new Book(isbn, title, author, publisher, language, price, "add");
                        break;
                    case "2":
                        System.out.println("You have selected the option to search a book:");
                        System.out.print("Enter the title of the book - ");
                        String searchInput = scanner.nextLine();
                        Book book1 = new Book(null, searchInput, null, null, null, null, "search");

                        break;
                    default:
                        System.out.println("Enter a valid choice.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Try again..");
                continue;
            }

        }

    }

}
