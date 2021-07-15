package assignment;

import java.util.Arrays;
import java.util.List;

public class UserMainCode {

    public int smartDict(int input1, String[] input2) {
        int size = input1;
        if (size == 0)
            return 0;

        if (size == 1)
            return input2[0].length();
        Arrays.sort(input2);
        int end = Math.min(input2[0].length(), input2[size - 1].length());
        int i = 0;
        while (i < end && input2[0].charAt(i) == input2[size - 1].charAt(i))
            i++;
        String pre = input2[0].substring(0, i);
        return pre.length();
    }

    /* Driver Function to test other function */
    public static void main(String[] args) {
        UserMainCode userMainCode = new UserMainCode();
        String[] input2 = { "This", "That", "There", "Their", "Therefore" };
        System.out.println("The longest Common Prefix is : " + userMainCode.smartDict(5, input2));

        String[] input3 = { "Data", "Database", "Datapower", "Space" };
        System.out.println("The longest Common Prefix is : " + userMainCode.smartDict(4, input3));

    }



}
