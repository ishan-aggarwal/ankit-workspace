package assignment;
// Java program to find compound interest for
// given values.

import java.util.Scanner;
//import static java.lang.Math.pow;

/*
public class Testing
{
    public static void main(String [] args)
    {
        Scanner input=new Scanner(System.in);


                while (true) {
            System.out.println("Please choose from the below options.");
            System.out.println("-> Enter any number to run the example.");
            System.out.println("-> Enter 0 to Exit.");
            int input;
            try {
                input = sc.nextInt();

                switch (input) {
                    case 0:
                        System.out.println("You pressed Exit.");
                        break;
                    default:

        do
        {

            double damount,anamount,mamount, dtotal=0, mtotal=0, atotal=0,principle,years,dci=0,aci=0,mci=0;
            double rate;

            System.out.println("enter principle ");

            principle=input.nextDouble();

            System.out.println("enter rate");

            rate=input.nextDouble();

            System.out.println("enter years");

            years=input.nextDouble();

            aci=(rate/100);
            dci=(aci/365);
            mci=(aci/12);
            System.out.println( aci );
            System.out.println( dci );
            System.out.println( mci );
            damount=principle;
            mamount=principle;
            anamount=principle;

            for(int i=1;i<=years;i++)
            {
                //aci*=i;
                //dci*=i;
                //mci*=i;


                damount+= damount*dci;//wait..the annual is too high...and monthy too low
                mamount+= mamount * mci;
                anamount+= anamount*aci;



            }

            dtotal= damount-principle;
            mtotal= mamount-principle;
            atotal= anamount-principle;

            System.out.println("Daily Interest amount in 10 years is = "+ dtotal);

            System.out.println("Monthly Interest amount in 10 years is = "+ mtotal);

            System.out.println("Annual Interest amount in 10 years is = "+ atotal);
            //yes
            System.out.println("Daily Account amount in 10 years is = "+ damount);
            System.out.println("Monthly Account amount in 10 years is = "+ mamount);
            System.out.println("Annual Account amount in 10 years is = "+ anamount);

            System.out.println("Would you like to check again? Enter Yes or No");
            answer = input.next();
        }
        while(answer.equalsIgnoreCase("Yes"));
    }
}
*/
