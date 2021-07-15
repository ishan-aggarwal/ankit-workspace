package shakthi;

import java.util.ArrayList;

public class DoingIt {

    public void lab1() {
        System.out.println("-------------lab1---------------");
        System.out.println("--a part");
        //display third last element of the array
        String cars[] = {"BMW", "AUDI", "MERCEDES BENZ", "PORSCHE"};
        System.out.println("Third last element of the array:" + cars[cars.length-3]);

        //adding another car manually
        cars = new String[]{"BMW", "AUDI", "MERCEDES BENZ", "PORSCHE", "JAGUAR"};
        System.out.println("Third last element of the array after adding new element:" + cars[cars.length-3]);

        //removing the element we added in the initializer list.
        cars = new String[]{"BMW", "AUDI", "MERCEDES BENZ", "PORSCHE"};


        System.out.println("--b part");

        int length1 = cars[0].length();
        int length2 = cars[1].length();
        int length3 = cars[2].length();
        int length4 = cars[3].length();
        int totalLength = length1 + length2 + length3 + length4;
        System.out.println("Total number of charaters in array car: "+ totalLength);


        System.out.println("--c part");
        String firstElement = cars[0];
        String lastElement = cars[cars.length-1];

        boolean isEqualLength = firstElement.length() == lastElement.length();

        System.out.println("First and last element have same length: "+isEqualLength);
    }

    public void lab2() {
        System.out.println("-------------lab2---------------");
        String[] myStringArray;

        //1. compile time error. variable might not have been initialized.
        //System.out.println("First element in the array" + myStringArray);

        myStringArray = new String[3];

        //2. Run-time error - Nullpointer exception
        myStringArray[0] = "green";
        System.out.println(myStringArray[0].length());

        //3. Array index out of bound
        System.out.println(myStringArray[4]);

        myStringArray[0] = "green";
        //4. display length of the first element
        System.out.println("Length of first element: "+myStringArray[0].length());

    }

    public void lab3() {
        System.out.println("-------------lab3---------------");

        //1. Declare an arraylist of float values.
        ArrayList<Float> list;

        //2. add 5 random values in range 0<=10<10
        list = new ArrayList<>();
        list.add(Double.valueOf(Math.random()*10).floatValue());
        list.add(Double.valueOf(Math.random()*10).floatValue());
        list.add(Double.valueOf(Math.random()*10).floatValue());
        list.add(Double.valueOf(Math.random()*10).floatValue());
        list.add(Double.valueOf(Math.random()*10).floatValue());

        //3. print the array list
        System.out.println("Printing the array list: "+ list);

        //4. print the sum of first three elements in the array list
        float sum = list.get(0) + list.get(1) + list.get(2);
        System.out.println("Sum of first three elements: "+ sum);

        //5. remove first element
        list.remove(0);

        //6. add random value in the end
        list.add(Double.valueOf(Math.random()*10).floatValue());

        //7. delete second value
        list.remove(1);

        //8. change the value of the last cell with a new random value
        list.set(list.size()-1, Double.valueOf(Math.random()*10).floatValue());

        //9. printing the array list
        System.out.println("Printing the array list again: "+ list);

    }

    public void lab4() {
        System.out.println("-------------lab4---------------");

        String str = "CAtaStROPhe";
        //making first character upper case and remaining characters to lower case
        String result = str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();

        System.out.println(str + " becomes "+ result);

    }

    public void lab5() {
        System.out.println("-------------lab5---------------");

        String bear = "\ud83d\udc3b";
        for (int i = 1; i <= 4; i++) {

            // loop to print the number of spaces before the star
            for (int j = 4; j >= i; j--) {
                System.out.print(" ");
            }

            // loop to print the number of stars in each row
            for (int j = 1; j <= i; j++) {
                System.out.print(String.format(bear+" "));
            }

            // for new line after printing each row
            System.out.println();
        }

    }

    public void lab6() {

    }
}
