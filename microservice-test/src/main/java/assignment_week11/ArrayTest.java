//package assignment_week11;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//public class ArrayTest {
//    /**
//     * Given an array, returns a new array consisting of the longest run of
//     * consecutive nondecreasing values in the given array.  If there are multiple runs
//     * of the same maximal length, the first such run is returned.
//     * <em>Example:</em> Given the array
//     * [5, 3, 3, 7, 10, 9, 11, 13, 10, 14, 16, 17], the method returns
//     * the array [3, 3, 7, 10]
//     * @param arr
//     *   given array
//     * @return
//     *   array containing longest nondecreasing run in the given array
//     */
//
//    public static int longestNonDecreasingSubsequenceLength(List<Integer> A){
//
//        int n = A.size();
//        vector<int> d(n, 1), p(n, -1);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (a[j] < a[i] && d[i] < d[j] + 1) {
//                    d[i] = d[j] + 1;
//                    p[i] = j;
//                }
//            }
//        }
//
//        int ans = d[0], pos = 0;
//        for (int i = 1; i < n; i++) {
//            if (d[i] > ans) {
//                ans = d[i];
//                pos = i;
//            }
//        }
//
//        vector<int> subseq;
//        while (pos != -1) {
//            subseq.push_back(a[pos]);
//            pos = p[pos];
//        }
//        reverse(subseq.begin(), subseq.end());
//        return subseq;
//    }
//
//    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>(Arrays.asList(5, 3, 3, 7, 10, 9, 11, 13, 10, 14, 16, 17));
//        System.out.println(longestNonDecreasingSubsequenceLength(list));
//    }
//
//}
