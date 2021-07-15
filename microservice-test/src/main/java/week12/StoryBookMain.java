package week12;

import java.io.*;
import java.util.Scanner;

public class StoryBookMain {
    public static final String STORY_TXT = "story.txt";
    public static final String STORY_MOD_TXT = "storyMod.txt";
    private static Scanner scanner = new Scanner(System.in);

    private static void saveToFile(String fileName, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(content);
        writer.close();
        System.out.println("Saved story in file: " + fileName);
        System.out.println("Content: "+ content);
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Enter '1' to manually write story or anything else to exit.");

        String input = scanner.nextLine();
        if ("1".equals(input)) {
            System.out.println("Write the story : ");
            String story = scanner.nextLine();
            saveToFile(STORY_TXT, story);
        } else {
            System.exit(0);
        }

        System.out.println("Change Name - 1 : ");
        String oldName1 = scanner.nextLine();

        System.out.println("Enter new name - 1: ");
        String newName1 = scanner.nextLine();

        System.out.println("Change Name - 2 : ");
        String oldName2 = scanner.nextLine();

        System.out.println("Enter new name - 2: ");
        String newName2 = scanner.nextLine();

        System.out.println("Change location: ");
        String location = scanner.nextLine();

        System.out.println("New location: ");
        String newLocation = scanner.nextLine();

        //read file
        File file = new File(STORY_TXT);

        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String st;
        while ((st = br.readLine()) != null) {
            sb.append(st).append("\n");
        }
        String fileContent =  sb.toString();

        fileContent = fileContent.replace(oldName1, newName1);
        fileContent = fileContent.replace(oldName2, newName2);
        fileContent = fileContent.replace(location, newLocation);

        String newFileName = STORY_MOD_TXT;

        saveToFile(newFileName, fileContent);
        System.out.println("Content changed and saved in the file: " + newFileName);
        System.out.println("Program ended.");
    }
}
