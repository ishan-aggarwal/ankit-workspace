package week12;

public class OverloadTest {


    static void add(int s) {
        System.out.println("s");
    }

    static void add(Integer s) {
        System.out.println("i");
    }

    public static void main(String[] args) {
        add(null);
    }
}
