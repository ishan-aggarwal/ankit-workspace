package com.example.gatling;

public class TEst {

    public static void show() throws TestException1 {
        throw new TestException1();
    }

    public static void main(String[] args) {
        System.out.println(1+1==2);
    }
}
