package olivia;

import java.util.ArrayList;

public class LetterMain {

    public static void main(String[] args) {

        ArrayList<C> list = new ArrayList<>();
        list.add(new A());
        list.add(new B());
        list.add(new C());
        list.add(new D());

        for (int i=0;i<list.size();i++) {
            System.out.print("Index "+ i +": ");
            System.out.print(list.get(i));
            list.get(i).method1();
            list.get(i).method2();
            System.out.println();
        }


        C c4 = new B();
        B b1 = new B();
        A a1 = new A();

        B b2 = new D();

        C c1 = new D();
//
//        D d1 = new C();
//        D d3 = new  A();
//        A a3 = new  B();


    }


}
