package diksha;

import java.util.Scanner;

public class CarBuilder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            do{
                System.out.println("Press 1 to Add a Car by entering a car Id, car Price, car model and car Color.");
                System.out.println("Press 2 to View the details of a Car by entering a car Id");
                System.out.println("Press 3 to View detail of all the cars including car Id, car Price, car model and car Color.");
                System.out.println("Press 4 to Delete a car by entering a car Id");
                System.out.println("Press 5 to Exit");

                int input = scanner.nextInt();

                switch (input){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        System.out.println("Thank you. Bye..");
                        break;
                    default:
                        System.out.println("Invalid input. Try again");
                        break;
                }


            } while (true);

        } finally {
            scanner.close();
        }
    }

}
