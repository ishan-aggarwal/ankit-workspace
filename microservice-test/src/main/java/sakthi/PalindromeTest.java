package sakthi;

public class PalindromeTest {

    public static boolean isPalindrome(int arr[])
    {
        int length = arr.length;

        boolean isPalindrome = true;

        // running the loop till the half length of the array
        for (int i = 0; i <= length / 2 && length != 0; i++) {

            //if first and last element are not same.
            //set the isPalindrome to false
            if (arr[i] != arr[length - i - 1]) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        int[] input1 = {1,3,1};
        int[] input2 = {1,3,3,1};
        int[] input3 = {2,1,3,1};
        int[] input4 = {2,1,3,1,2};
        int[] input5 = {2};
        int[] input6 = {2,1};

        System.out.println(isPalindrome(input1));
        System.out.println(isPalindrome(input2));
        System.out.println(isPalindrome(input3));
        System.out.println(isPalindrome(input4));
        System.out.println(isPalindrome(input5));
        System.out.println(isPalindrome(input6));
    }

}
