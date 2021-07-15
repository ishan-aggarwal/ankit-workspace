package assignment_old;

import java.util.List;
import java.util.Random;

public class Exam {

    public static int rps(String input1, String input2) {
        List<String> list = List.of("rock", "paper", "scissors");
        input1 = input1.toLowerCase();
        input2 = input2.toLowerCase();
        if (!list.contains(input1) || !list.contains(input2)) return -1;
        if (input1.equals(input2)) return 1;
        else return 0;
    }

    public static int playRps(int input) {
        String player1;
        String player2;
        int result = 0;
        Random random = new Random();
        List<String> list = List.of("rock", "paper", "scissors");
        for (int i = 0; i < 24; i++) {
            int randonNumber = random.nextInt();
            if (randonNumber % 2 == 0) player1 = "rock";
            else player1 = "paper";
            int index = i % 3;
            player2 = list.get(index);
            result += rps(player1, player2);
        }
        return result;
    }


    public static String triangleWord(String input, char noPrint) {

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (char c : input.toCharArray()) {
            temp.append(c);
            if (c == noPrint) {
                int length = temp.length();
                StringBuilder starString = new StringBuilder();
                for (int i = 0; i < length; i++) {
                    starString.append("*");
                }
                sb.append(starString + "\n");
            } else {
                sb.append(temp + "\n");
            }
        }
        return sb.toString();
    }

    public static String squareWord(String input, char noPrint) {
        if (input.contains(String.valueOf(noPrint))) {
            return "Bad input";
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2= new StringBuilder();
        int length = input.length();
        for(int i = 0; i<length; i++) {
            StringBuilder temp = new StringBuilder();
            char c = input.charAt(i);
            sb2.append(c);
            temp.append(sb2);
            for(int j = i+1; j<length;j++) {
                temp.append("*");
            }
            sb.append(temp+"\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(rps("pet", "roCk"));
        System.out.println(rps("paPer", "scissors"));
        System.out.println(rps("paPer", "paper"));

        System.out.println(playRps(105));

        System.out.println(triangleWord("ankit", 'k'));

        System.out.println(squareWord("ankit",'j'));
    }

}
