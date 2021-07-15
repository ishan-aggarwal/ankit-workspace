package assignment_old;

import java.util.Arrays;
import java.util.List;

public class Parallel {
    static int index = 0;
    public static void main(String[] args) {
        List<MathOPeration> list = Arrays.asList(null,null);
        list.forEach(m-> System.out.println(m.calculate(args[index++],1,2)+" "));
    }
}
class MathOPeration {

    public static int calculate(String choice, int a, int b) {
        int c =3;
        switch (choice) {
            case "ADD": c+=a+b;
            case "SUBTRACT": c+=a-b;
            default: c+=a*b;
        }
        return c;
    }

}