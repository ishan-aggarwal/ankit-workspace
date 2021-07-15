package edu.brandleis.jdbc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookDBManipulationApp {

    private  Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BookDBManipulationApp app =  new BookDBManipulationApp();
        app.start();
    }

    private void start() {
        do {
            int input;
            System.out.println("Please choose one action:");
            System.out.println("1 -- Add a new author");
            System.out.println("2 -- Edit the existing information for an author");
            System.out.println("3 -- Add a new title for an author");
            System.out.println("4 -- Associate new title with an author");
            System.out.println("5 -- Exit");

            try{
                input = getNextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Invalid Input. Try again.");
                continue;
            }

            switch (input) {
                case 1:
                    addAuthor();
                    break;
                case 2:
                    editAuthor();
                    break;
                case 3:
                    addTitle();
                    break;
                case 4:
                    linkTitleWithAuthor();
                    break;
                case 5:
                    System.out.println("You chose to exit. Bye!!");
                    System.exit(0);
            }
        } while (true);

    }

    private void addAuthor() {
        String firstName, lastName;
        System.out.println("Please enter author's first name");
        firstName = scanner.nextLine();
        System.out.println("Please enter author's last name");
        lastName = scanner.nextLine();

    }

    private void editAuthor() {

        System.out.println("Please enter author id");
        System.out.println("Please enter new first name");
        System.out.println("Please enter new last name");
    }

    private void addTitle() {
        System.out.println("Please enter ISBN");
        System.out.println("Please enter title");
        System.out.println("Please enter edition number");
        System.out.println("Please enter copyright year");
    }


    private void linkTitleWithAuthor() {
        System.out.println("Please choose an author ID from the list below");

        System.out.println("Please choose a book isbn from the list below");
    }

    private String getNextLine() {
        return scanner.nextLine();
    }

    private int getNextInt() {
        return scanner.nextInt();
    }

}
