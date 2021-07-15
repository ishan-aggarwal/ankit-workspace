package week12;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StoryBookModificationTest {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = "story.txt";
        String newFileName = "storyMod.txt";
        BufferedWriter writer = null;

        System.out.println("----Story Book Modification App----");
        System.out.println("Write a story in a file. Enter 1.");
        System.out.println("Use the default story and store in file. Enter 2.");
        System.out.println("Exit. Enter anything else.");

        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1":
                System.out.println("Enter story:");
                String story = scanner.nextLine();
                writer = new BufferedWriter(new FileWriter(fileName));
                writer.write(story);
                writer.close();
                System.out.println("File saved: " + fileName);
                System.out.println("Story- "+ story);
                break;
            case "2":
                String storyDefault = "Harry is a series of seven fantasy novels. " +
                        "The novels chronicle the lives of a young wizard, " +
                        "Harry, and his friends Hermione and Ron from London";
                writer = new BufferedWriter(new FileWriter(fileName));
                writer.write(storyDefault);
                writer.close();
                System.out.println("File saved: " + fileName);
                System.out.println("Story- "+ storyDefault);
                break;
            default:
                System.exit(0);
        }

        System.out.println("Enter current name 1: ");
        String currentName1 = scanner.nextLine();
        System.out.println("Enter the new name 1: ");
        String newName1 = scanner.nextLine();
        System.out.println("Enter current name 2: ");
        String currentName2 = scanner.nextLine();
        System.out.println("Enter the new name 2: ");
        String newName2 = scanner.nextLine();
        System.out.println("Enter the current location: ");
        String currentLocation = scanner.nextLine();
        System.out.println("Enter the new location: ");
        String newLocation = scanner.nextLine();

        //read file
        File file = new File(fileName);

        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String st;
        while ((st = br.readLine()) != null) {
            sb.append(st).append("\n");
        }
        String savedStory =  sb.toString();

        savedStory = savedStory.replace(currentName1, newName1);
        savedStory = savedStory.replace(currentName2, newName2);
        savedStory = savedStory.replace(currentLocation, newLocation);
        //write the modified file
        writer = new BufferedWriter(new FileWriter(newFileName));
        writer.write(savedStory);
        writer.close();
        ArrayList list = new ArrayList();
        //list.re
        System.out.println("Content changed and saved in the file: " + newFileName);
        System.out.println("Story- "+ savedStory);
    }

}
