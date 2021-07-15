package isaiah.project3;

import javax.swing.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner (System.in);
        String userInput = "";
        int valid = 0;

        while (valid == 0)
        {
            System.out.println ("Press 1 to run WordTest, Press 2 to run Pattern: ");
            userInput = input.nextLine ();
            userInput = userInput.trim ();
            if (userInput.equals ("1"))
            {
                valid = 1;
                runWordTest ();
            }
            else if (userInput.equals ("2"))
            {
                valid = 1;
                runPattern ();
            }
            else
            {
                System.out.println ("**Invalid Input**");
                valid = 0;
            }
        }
    }

    public static void runWordTest ()
    {
        Word word = new Word();
        String vowels = "aeiouyAEIOUY";
        for (int i=0; i < vowels.length(); i++)
        {
            String letter = vowels.substring (i, i+1);
            System.out.println (letter + " is a vowel: " + word.isVowel (letter));
            System.out.println ("Expected: true");
        }
        String nonVowels = "bBxX.!";
        for (int i=0; i < nonVowels.length(); i++)
        {
            String letter = nonVowels.substring (i, i+1);
            System.out.println (letter + " is a vowel: " + word.isVowel (letter));
            System.out.println ("Expected: false");
        }
    }

    public static void runPattern ()
    {
        JFrame frame = new JFrame();
        frame.add(new Pattern());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
