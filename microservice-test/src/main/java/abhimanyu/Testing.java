package abhimanyu;

public class Testing {

    public static int xFunction(int n) {
        if(n<=1) {
            return 1;
        }
        return n+ xFunction(n-2);
    }

    public static void main(String[] args) {
        System.out.println(xFunction(6));
    }

}
