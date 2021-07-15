package test;

import java.util.*;

public class RockPaperScissorApp {
    static String moves[] = {"rock", "paper", "scissors"};
    static Random randomGenerator = new Random();

        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean again = true;

        int usermove;
        int computermove;
        while (again) {
            usermove = user(in);
            computermove = computer();
            score(usermove, computermove);
            again = conclusion(in);
        }

    }

    public static int user(Scanner in) {
        char a;
        int move = 0;
        System.out.print("Choose your weapon (r,p,s): ");
        a = in.nextLine().charAt(0);
        a = Character.toLowerCase(a);
        while (a != 'r' && a != 'p' && a != 's') {
            System.out.print("Choose your weapon (r,p,s): ");
            a = in.nextLine().charAt(0);
            a = Character.toLowerCase(a);
        }
        switch (a) {
            case 'r':
                move = 0;
                break;
            case 'p':
                move = 1;
                break;
            case 's':
                move = 2;
                break;
        }
        return move;
    }

    public static int computer() {
        int move = randomGenerator.nextInt(3);

        System.out.println("I chose " + moves[move]);
        return move;
    }

    public static void score(int user, int computer) {
        if (user == computer)
            System.out.println("Tie!");
        else if (user == 0 && computer == 2)
            System.out.println("You break my sissors. you win!");
        else if (user == 0 && computer == 1)
            System.out.println("I cover your rock. you lose!");
        else if (user == 1 && computer == 2)
            System.out.println("I cut your paper. you lose!");
        else if (user == 1 && computer == 0)
            System.out.println("You cover my rock. you win!");
        else if (user == 2 && computer == 0)
            System.out.println("I break your sissors, you lose!");
        else
            System.out.println("You cut my paper. you win!");
        return;
    }

    public static boolean conclusion(Scanner in) {
        char a;
        System.out.println("\nGood game. Play again!(Y/N) ");
        a = in.nextLine().charAt(0);
        a = Character.toLowerCase(a);
        while (a != 'y' && a != 'n') {
            System.out.print("invalid entry\nPlay again(Y/N)? ");
            a = in.nextLine().charAt(0);
            a = Character.toLowerCase(a);
        }
        if (a == 'y')
            return true;
        else
            return false;
    }
}