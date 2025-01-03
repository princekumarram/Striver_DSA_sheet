import java.util.*;

public class q2_Longest_Increasing_Subsequence_Binary_Search {

    public static int longestIncreasingSubsequence(int arr[], int n) {

        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);

        int len = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] > temp.get(temp.size() - 1)) {

                temp.add(arr[i]);
                len++;
            } else {
                int ind = Collections.binarySearch(temp, arr[i]);

                if (ind < 0) {
                    ind = -ind - 1;
                }
                temp.set(ind, arr[i]);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
        int n = arr.length;

        System.out.println("The length of the longest increasing subsequence is " +
                longestIncreasingSubsequence(arr, n));
    }

}
