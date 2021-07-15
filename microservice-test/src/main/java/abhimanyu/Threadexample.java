package abhimanyu;

import com.LinkedList;

import java.util.Scanner;

public class Threadexample {
    public static void main(String[] args)
        throws InterruptedException
    {
        // Object of a class that has both produce()
        // and consume() methods
        final PC pc = new PC();
  
        // Create producer thread
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.produce();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
  
        // Create consumer thread
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.consume();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
  
        // Start both threads
        producer.start();
        consumer.start();
  
        // t1 finishes before t2
        producer.join();
        consumer.join();
    }
  
    // This class has a list, producer (adds items to list
    // and consumber (removes items).
    public static class PC {
  
        // Create a list shared by producer and consumer
        // Size of list is 2.
        LinkedList<String> Buff = new LinkedList<>();
        int capacity = 2;
  
        // Function called by producer thread
        public void produce() throws InterruptedException
        {
            Scanner scanner = new Scanner(System.in);
            int value = 0;
            while (true) {
                synchronized (this)
                {
                    System.out.println("User input::");
                    String input = scanner.nextLine();
                    // producer thread waits while list
                    // is full
                    if(input.equalsIgnoreCase("Stop")) {
                        break;
                    }

                    while (Buff.size() == capacity)
                        wait();
  
                    System.out.println("Producer produced-"
                                       + input);
  
                    // to insert the jobs in the list
                    Buff.add(input);
  
                    // notifies the consumer thread that
                    // now it can start consuming
                    notify();
  
                    // makes the working of program easier
                    // to  understand
                    Thread.sleep(1000);
                }
            }
        }
  
        // Function called by consumer thread
        public void consume() throws InterruptedException
        {
            while (true) {
                synchronized (this)
                {
                    // consumer thread waits while list
                    // is empty
                    while (Buff.size() == 0)
                        wait();
  
                    // to retrive the ifrst job in the list
                    String val = Buff.get(0);
                    Buff.remove(0);
  
                    System.out.println("Consumer consumed-"
                                       + val);
  
                    // Wake up producer thread
                    notify();
  
                    // and sleep
                    Thread.sleep(1000);
                }
            }
        }
    }
}