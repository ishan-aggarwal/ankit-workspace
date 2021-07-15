package abhimanyu;

public class Child extends Parent {

    @Override
    public void add(int a) {
        super.add(a);
    }

    public void add(int a, int b) {

    }

    public static void main(String[] args) {
        Child c = new Child();
        c.add(1);
        c.add(1,2);
    }

}
