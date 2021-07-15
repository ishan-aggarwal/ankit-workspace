package aron;

public class testprog {

    public static int next(int i, String[] a){
        if (isPalindrome(a[i]))
            return i+a[i].length();
        else
            return i+1;
    }

    public static void main(String[] args) {

        String[] a = {"aba", "eb", "ob", "obo", "ebe", "beb", "bo"};
        int i = 0;
        while (i < a.length) {
            System.out.print(i);
            i = next(i, a);
        }
    }
    static boolean isPalindrome(String str)
    {

        // Pointers pointing to the beginning
        // and the end of the string
        int i = 0, j = str.length() - 1;

        // While there are characters to compare
        while (i < j) {

            // If there is a mismatch
            if (str.charAt(i) != str.charAt(j))
                return false;

            // Increment first pointer and
            // decrement the other
            i++;
            j--;
        }

        // Given string is a palindrome
        return true;
    }

}
