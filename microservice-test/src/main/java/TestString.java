import java.util.ArrayList;

public class TestString {

    public static void printStringTillVowel(String input) {
        String vowels = "aeiou";

        for(int i = 0; i<input.length(); i++) {
            char charAt = input.charAt(i);
            if(vowels.contains(String.valueOf(charAt))) {
                break;
            } else {
                System.out.print(charAt);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("input:"+"bcfredsertt");
        printStringTillVowel("bcfredsertt");
        new ArrayList<>(2);
    }

}
