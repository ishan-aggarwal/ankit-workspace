package assignment;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CompoundInterest {

    /*public static void calculate(int p, int t, double r, int n) {
        double amount = p * Math.pow(1 + (r / n), n * t);
        double cinterest = amount - p;
        System.out.println("Compound Interest after " + t + " years: "+cinterest);
        System.out.println("Amount after " + t + " years: "+amount);
    }*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        while (true) {
            System.out.print("Enter any number to continue and 0 to exit: ");
            int input;
            try {
                input = scanner.nextInt();

                switch (input) {
                    case 0:
                        System.out.println("You pressed Exit.");
                        System.exit(1);
                    default:
                        System.out.println("Enter below details:");
                        System.out.print("Principal: ");
                        double principal = scanner.nextDouble();

                        System.out.print("Rate: ");
                        double rate = scanner.nextDouble();

                        System.out.print("Time:");
                        int time = scanner.nextInt();


                        System.out.println("Principal: $" + principal);
                        System.out.println("Rate: " + rate);
                        System.out.println("time: " + time);
                        System.out.println();
                        double amount = principal;
                        for (int i = 0; i < time; i++) {
                            amount = amount + (amount * (rate / 100));
                        }
                        System.out.println("Total compounded Amount: $" + amount);
                        double totalInterest = amount - principal;
                        System.out.println("Total Interest in " + time + "years:" + totalInterest);

                        int totalDays = time * 365;
                        int totalMonths = time * 12;

                        double dailyInterest = totalInterest / totalDays;
                        System.out.println("Daily Interest: $" + decimalFormat.format(dailyInterest));

                        double monthlyInterest = totalInterest / totalMonths;

                        System.out.println("Monthly Interest: $" + decimalFormat.format(monthlyInterest));

                        double annualInterest = totalInterest / time;

                        System.out.println("Annual Interest: $" + decimalFormat.format(annualInterest));

                        double dailyAmount = principal + dailyInterest;
                        double monthlyAmount = principal + monthlyInterest;
                        double annualAmount = principal + annualInterest;
                        System.out.println();

                        System.out.println("Daily Amount: $" + decimalFormat.format(dailyAmount));
                        System.out.println("Monthly Amount: $" + decimalFormat.format(monthlyAmount));
                        System.out.println("Annual Amount: $" + decimalFormat.format(annualAmount));

                        double annualRate = (annualInterest / principal) * 100;
                        System.out.println("Annual Rate: " + decimalFormat.format(annualRate));

                }
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("Please enter valid input!");
                continue;
            }
        }


    }
}
