package week12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Olivia {

    /**
     *
     * @param queue
     * @return
     */
    public static Stack<Integer> mysteryE(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        int size = queue.size();

        for(int i=0; i< size; i++) {
            int n=queue.remove();

            if(n%2 ==0) {
                queue.add(n);
            } else {
                stack.push(n);
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList list = new ArrayList();
        list.listIterator();
        queue.add(7);
        queue.add(8);
        queue.add(2);
        queue.add(9);
        queue.add(5);
        queue.add(0);
        queue.add(1);
        queue.add(4);

        System.out.println(mysteryE(queue));


    }
}
