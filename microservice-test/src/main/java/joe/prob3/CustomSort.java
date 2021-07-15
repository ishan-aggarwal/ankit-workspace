package joe.prob3;

import java.util.*;

public class CustomSort {

    static List<Integer> customSortId(List<Integer> ids) {
        Collections.sort(ids, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int o1Digits = countDigit(o1);
                int o2Digits = countDigit(o2);
                if(o1Digits > o2Digits) {
                    return 1;
                } else if (o1Digits < o2Digits) {
                    return -1;
                } else {
                    if(o1 > o2) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });
        return ids;
    }

    static int countDigit(long n)
    {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(123,1234,234,1,2,3,123456));
        System.out.println(customSortId(list));
    }

}
