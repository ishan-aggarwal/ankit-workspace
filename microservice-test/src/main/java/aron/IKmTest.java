package aron;

public class IKmTest {

    private int data;

    public IKmTest() {
        this(10);
    }

    public IKmTest(int data) {
        this.data = data;
    }

    public void display() {
        class Decrementer {
            public void decrement() {
                data--;
            }
        }
        Decrementer d = new Decrementer();
        d.decrement();
        System.out.println("data =" + data);
    }


    public static void main(String[] args) {
        int data = 0;
        IKmTest t = new IKmTest();
        t.display();
        System.out.println("data="+data);
    }
}
