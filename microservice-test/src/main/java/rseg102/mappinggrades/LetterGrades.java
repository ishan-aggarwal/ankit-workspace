package rseg102.mappinggrades;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LetterGrades {

    private static List<Integer> marksList = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    //method to take user input
    public static int getUserInput() {
        return scanner.nextInt();
    }

    public static void printGrades() {
        List<String> grades = marksList.stream()
                .map(marks -> {
                    String grade;
                    if (marks >= 90) {
                        grade = "A";
                    } else if (marks >= 80 && marks < 90) {
                        grade = "B";
                    } else if (marks >= 70 && marks < 80) {
                        grade = "C";
                    } else if (marks >= 60 && marks < 70) {
                        grade = "D";
                    } else {
                        grade = "F";
                    }
                    return grade;
                }).collect(Collectors.toList());
        System.out.println("Letter grades are: "+grades);

    }

    public static void addMarks(int marks) {
        marksList.add(marks);
    }

    public static void main(String[] args) {
        try {
            do {
                System.out.println("Enter grade or -1 to quit:");
                int marks;
                try {
                    marks = getUserInput();
                } catch (InputMismatchException e) {
                    scanner.next();
                    System.out.println("Please enter valid marks next time.");
                    continue;
                }
                if(marks == -1) {
                    printGrades();
                    System.exit(1);
                } else{
                    addMarks(marks);
                }
            } while (true);

        } catch (Exception ex) {
            System.out.println("Error!!");
        } finally {
            scanner.close();
        }
    }

}
