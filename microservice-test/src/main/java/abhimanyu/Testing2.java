package abhimanyu;

public class Testing2 {

    public static int xFunction(int n) {
        if(n==0) {
            return 0;
        } else{
            return n+ xFunction(n-1);
        }

    }

    public static void main(String[] args) {
        System.out.println(xFunction(5));
    }

}
