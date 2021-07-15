package com.assignment;

import java.util.Arrays;

public class Test {


    public static void main(String[] args) {
        int size = 20;
        int input[] = new int[size];

        for(int i=0; i< input.length; i++) {
            if(i%4 == 0) {
                input[i] = 1;
                if(i+1 <input.length) {
                    input[i+1] = 1;
                }
            }
        }
        Arrays.stream(input).forEach(i-> System.out.println(i));
    }
}
