package raul;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Quiz {

    //list for storing questions
    private static LinkedList<String> questions = new LinkedList<String>();

    //List for storing answers
    private static LinkedList<String> answers = new LinkedList<String>();

    //for taking user input
    private static Scanner in = new Scanner(System.in);

    static {

        questions.add("Is Java Object oriented language? yes/no");
        answers.add("yes");

        questions.add("Can you write enterprise applications in java? yes/no");
        answers.add("yes");

        questions.add("is java scripting language? yes/no");
        answers.add("no");
    }

    //main method
    public static void main(String[] args) {
        try{
            //loop until list of questions is not empty
            while(questions.size()>0){
                String question = questions.get(0);
                String answer = answers.get(0);
                System.out.println(question);
                System.out.print("Enter your answer in lower case: ");
                //user input
                String input = in.nextLine();

                //check is user input is correct
                if(input.equals(answer)){
                    //is answer is right. remove it from the question and answer from the list.
                    System.out.println("Your answer is correct. Your next question:");
                    questions.remove(0);
                    answers.remove(0);
                    continue;
                } else {
                    //if the answer is wrong. add in the list. (last index)
                    System.out.println("Your answer is wrong.");
                    questions.remove(0);
                    answers.remove(0);
                    questions.add(question);
                    answers.add(answer);
                }
            }
        }  finally {
            System.out.println("No more questions. The Quiz has Ended.");
            in.close();
        }


    }
}

