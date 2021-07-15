package hw2assignment1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ListTest {

    //set to store names
    private static Set<String> names = new HashSet<>();
    //scanner for user input
    private static Scanner scanner = new Scanner(System.in);
    //constant
    public static final String END = "end";

    //default operation is ADD - to add a name.
    private static String currentOperation = "ADD";

    //method to add name in the set
    public static String addName(String name) {
        String message;
        if(names.add(name)) {
            message = name +" inserted";
        } else {
            message = name+" exists in set";
        }
        return message;
    }

    //method to search name in the set
    public static String searchName(String name) {
        String message;
        if(names.contains(name)){
            message = name+" found in set";
        } else {
            message =name+" not found in set";;
        }
        return message;
    }

    //method to take user input
    public static String getUserInput() {
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        try {
            do {
                String name;
                if (currentOperation.equalsIgnoreCase("ADD")) {
                    System.out.println("Add a name to set, use end to terminate input:");
                } else {
                    System.out.println("Search a name, use end to terminate searching:");
                }

                //take input from user
                name = getUserInput();

                if (END.equalsIgnoreCase(name)) {
                    if (currentOperation.equalsIgnoreCase("ADD")) {
                        currentOperation = "SUB";
                        continue;
                    } else {
                        System.exit(1);
                    }
                } else {
                    String message;
                    if (currentOperation.equalsIgnoreCase("ADD")) {
                        message = addName(name);
                    } else {
                        message = searchName(name);
                    }
                    System.out.println(message);
                }
            } while (true);
        } catch (Exception ex) {
            scanner.next();
            System.out.println(ex.getMessage());
        } finally {
            scanner.close();
        }
    }
}
