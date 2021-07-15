package week12;

import java.io.*;
import java.util.Scanner;

public class StringApp {

    private static final String DEFAULT_STORY = "Edouina and Anna are best friends. " +
            "Edouina is studying computer science in US. and Anna is working in Canada.";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to do:");
            System.out.println("- Enter 1 to write a story in a file.");
            System.out.println("- Enter 2 to use default story and store in file.");
            System.out.println("- Enter anything else to exit.");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("Enter the story.");
                    String story = scanner.nextLine();
                    saveStringToFile("story.txt", story);
                    break;
                case "2":
                    saveStringToFile("story.txt", DEFAULT_STORY);
                    break;
                default:
                    System.exit(0);
            }

        System.out.println("Enter the first name which you want to change: ");
        String old1 = scanner.nextLine();
        System.out.println("Enter the first new name: ");
        String new1 = scanner.nextLine();
        System.out.println("Enter the second name which you want to change: ");
        String old2 = scanner.nextLine();
        System.out.println("Enter the second new name: ");
        String new2 = scanner.nextLine();
        System.out.println("Enter the location which you want to change: ");
        String oldLocation = scanner.nextLine();
        System.out.println("Enter the new location: ");
        String newLocation = scanner.nextLine();

        String fileContent = readFromFile("story.txt");

        fileContent = fileContent.replace(old1, new1);
        fileContent = fileContent.replace(old2, new2);
        fileContent = fileContent.replace(oldLocation, newLocation);
        String newFileName = "storyMod.txt";
        saveStringToFile(newFileName, fileContent);
        System.out.println("Content changed and saved in the file: "+ newFileName);
        System.out.println("Program ended.");
    }

    private static void saveStringToFile(String fileName, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(content);

        writer.close();

        System.out.println("Below Story saved in file with name: "+fileName);
        System.out.println(content);
    }

    private static String readFromFile(String fileName) throws IOException {
        File file = new File(fileName);

        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String st;
        while ((st = br.readLine()) != null){
            sb.append(st).append("\n");
        }
         return sb.toString();
    }
}
