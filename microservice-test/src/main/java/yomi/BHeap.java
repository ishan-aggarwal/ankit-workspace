package yomi;

import java.util.Stack;

public class BHeap {
//    static int count =0;
//    public static void foo(int i) {
//        count++;
//        if(i>1) {
//            foo(i/2);
//            foo(i/2);
//            System.out.println("*");
//        }
//    }


    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("E");
        stack.push("D");
        stack.push("C");
        stack.push("B");

        String n1= stack.pop();
        String n2 = stack.peek();

        stack.push("A");

        String n3 = stack.pop();
        n1 = stack.pop();

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(stack);

    }


}
