package sakthi;

import java.util.Deque;
import java.util.Queue;
public class Test {
    public static void main(String[] args) {
        int arr[] = {15,17,6,8};
        int i,temp;
        i=0;
        while(i<4-1) {
            temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
            i=i+2;
        }
        System.out.println("after swap");
        for(i=0;i<4;i++){
            System.out.println(arr[i]);
        }
     }


}
