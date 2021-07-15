package sakthi;

import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};

        Scanner input = new Scanner(System.in);

        int loc = input.nextInt();
        int temp = arr[loc];
        arr[loc] = arr[loc+1];
        arr[loc+1] = temp;

        for (int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}
