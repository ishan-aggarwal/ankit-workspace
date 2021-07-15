import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateWords {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(hasUniqueWords(input));

    }

    public static String hasUniqueWords(String input) {

        String[] words = input.split(" ");

        Set<String> appeared = new HashSet<>();
        for (String word : words) {
            if (!appeared.add(word)) {
                return "no";
            }
        }
        return "yes";
    }

}
