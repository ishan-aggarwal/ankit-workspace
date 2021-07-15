package joe.prob3;

import java.util.*;

public class StringCustomSort {

    static List<String> customSortId(List<String> strings) {
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(countDigits(o1) > countDigits(o2)) {
                    return -1;
                } else if(countDigits(o1) < countDigits(o2)) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        return strings;
    }

    static int countDigits(String str) {
        int digits = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 48 && str.charAt(i) <= 57)
                digits++;
        }
        return digits;
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("221B Baker Street", "hgfye 5674sk f","Flat 203 at 56B Whitehaven Mansions",
                "2171 Aaron drive"));
        System.out.println(customSortId(list));

    }

}
