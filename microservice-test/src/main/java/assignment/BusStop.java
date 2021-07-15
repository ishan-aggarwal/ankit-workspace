//package assignment;
//
//public class BusStop {
//
//
//    public static void main(String[] args) {
//
//        int input1 = 3;
//        int [] input2  = {1,2,3};
//
//        int[] output = startingPoint(input1, input2);
//
//        for(int i=0; i<= output.length; i++)
//        System.out.println(output[i]);
//
//    }
//
//    public int[] startingPoint(int input1, int[] input2) {
//        int[] out = new int[input1 + 1];
//        int[] result = new int[input1];
//
//        for (int i = 1; i <= input2.length; i++)
//            out[i] = input2[i - 1];
//
//        int k;
//        for (int i = 1; i <= input1; i++) {
//            if (out[i] > 0) {
//                k = 2;
//                while (i * k <= input1) {
//                    out[(i) * k] = out[(i) * k] - out[i];
//                    ++k;
//                }
//            }
//        }
//        for (int i = 1; i < out.length; i++) {
//            result[i - 1] = out[i];
//        }
//
//        return result;
//    }
//
//}