package assignment;

public class UserMainCode_bak2 {

    public int[] startingPoint(int input1, int[] input2) {
        int k;
        for (int i = 1; i <= input1 ; i++) {
            if(input2[i] > 0) { //If any bus is originating from this Bus stop
                k = 2;
                while(i * k <= input1) {
                    input2[i * k] = input2[i * k] - input2[i];
                    ++k;
                }
            }
        }
        return input2;
    }

    public static void main(String[] args) {
        UserMainCode_bak2 userMainCode = new UserMainCode_bak2();

        int input1[] = {};

        System.out.println();
    }

}
