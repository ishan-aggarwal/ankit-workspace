package subodh_assignment;

public class C extends B{

    public C() {
        System.out.println("c");
    }

    public static void main(String[] args) {
        C c = new C();

    }
}


class A {
    public A() {
        System.out.println("a");
    }
}

class B extends A {
    public B() {
        System.out.println("b");
    }
}