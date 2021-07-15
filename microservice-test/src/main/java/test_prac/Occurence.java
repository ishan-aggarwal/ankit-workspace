package test_prac;

public class Occurence {

    private static int occurrence(String sentence, int position, char ch) {
        if (position >= sentence.length()) {
            return 0;
        }
        int count = sentence.charAt(position) == ch ? 1 : 0;
        return count + occurrence(sentence, position + 1, ch);
    }

    public static void main(String[] args) {
        System.out.println(occurrence("I really want to eat an apple today",  0,'a'));
    }

}
