package sakthi;

public class Program2 {

    public static void main(String[] args) {
        int x = 20;
        boolean flag = true;

        // 1st way is to store the result in variable and then print the variable
        //String result = x>15 && flag ? "Done":"Error";
        //System.out.println(result);

        // 2nd way is to directly print the result of the statement
        System.out.println(x>15 && flag ? "Done":"Error");
    }
}
