package person;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest<E> {

    public E removeThirdElement(Queue<E> queue) {
        final int size = queue.size();
        if(size < 3) {
            return null;
        }
        E element = null;
        Queue<E> temp = new LinkedList<>();
        for(int i=0; i<size; i++) {
            E poll = queue.poll();
            if(i != 2) {
                temp.add(poll);
            } else {
                element = poll;
            }
        }
        queue = temp;
        return element;
    }

    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        q.offer("abc");
        q.offer("def");
        q.offer("ghi");
        q.offer("jkl");
        q.offer("mno");
        q.offer("pqr");
        q.offer("stu");
        q.offer("vwx");

        QueueTest<String> queue = new QueueTest<>();
        System.out.println(queue.removeThirdElement(q));
        System.out.println(q);
    }

}
