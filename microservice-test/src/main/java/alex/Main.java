package alex;

public class Main {
    public static void main(String[] args) {

        String a = "abc";
        String b = "abcdef";
        System.out.println(Idx(a, b));
        String c = "abc,,def";
        String d = "abc";
        System.out.println(Idx(c,d));
        String e=null;
        String f="ccc";
        System.out.println(Idx(e,f));

    }

    public static int Idx(String s1, String s2) {
        if (s1 == null || s1.length() < 1 || s2 == null || s2.length() < 1) {
            return -1;
        }
        if (s1.length() < s2.length()) {
            return -1;
        }
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        for (int i = 0; i < s1Array.length; i++) {
            boolean isMatched = false;
            if (s1Array[i] == s2Array[0] && i + s2Array.length <= s1Array.length) {
                int equalcount = 1;
                for (int j = 1; j < s2Array.length; j++) {
                    if (s1Array[i + j] == s2Array[j]) {
                        equalcount++;
                    }
                }
                if (equalcount == s2Array.length) {
                    isMatched = true;
                }
            }
            if (isMatched) {
                return i;
            }

        }
        return -1;
    }

}