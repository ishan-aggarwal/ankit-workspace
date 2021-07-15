package test_prac;

import java.util.Scanner;

public class Sentence {

    public static void main(String[] args) {
        String sentence = "I want to eat a whole pizza and I will even pay for a second one for everybody else";
        String tokens[];
        String oneWord;
        int i;
        Scanner input = new Scanner(System.in);

        System.out.printf("Please enter a sentence%n");
        sentence = input.nextLine();

        System.out.printf("You entered: %s%n", sentence);

        tokens = sentence.split(" ");

        for(i=0;i<tokens.length;i++) {
            oneWord = tokens[i];
            String newWord;
            int strLen =  oneWord.length();

            if(strLen%2 == 0) {
                newWord = "*"+oneWord.substring(1);
            } else {
                if(strLen == 1) {
                    newWord = "("+oneWord+")";
                } else if (strLen == 3){
                    newWord = oneWord.toUpperCase();
                } else {
                    newWord = "$"+oneWord.substring(1,strLen-1)+"#";
                }
            }
            tokens[i] = newWord;
        }

        for(i=0;i<tokens.length;i++) {
            System.out.print(tokens[i]+" ");
        }
    }

}
