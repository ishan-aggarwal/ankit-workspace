package assignment_old;

import java.util.List;
import java.util.Random;

public class Exam1 {

    public static int rps(String player1, String player2)
    {

        List<String> list = List.of("rock", "paper", "scissors");
        player1 = player1.toLowerCase();
        player2 = player2.toLowerCase();
        if (!list.contains(player1) || !list.contains(player2)) return -1;
        if (player1.equals(player2)) return 1;
        else return 0;

    }

    public static int playRps(long seed)
    {
        String player1;
        String player2;
        int result = 0;
        Random random = new Random(seed);
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

    public static String triangleWord(String input, char noPrint)
    {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int j=0;j<input.length();j++) {
            char c = input.charAt(j);
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

    public static String squareWord(String input, char noPrint)
    {
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
}