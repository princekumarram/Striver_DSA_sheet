
import java.util.*;

class q5_Longest_Bitonic_Sequence {

    public static int LongestBitonicSequence(int n, int[] arr) {

        if (n < 3)
            return 0; // A bitonic sequence requires at least 3 elements

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        // Initialize both arrays with 1, as each element itself is a subsequence of
        // length 1
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        // Calculate the lengths of increasing subsequences
        for (int i = 0; i < n; i++) {
            for (int prevIndex = 0; prevIndex < i; prevIndex++) {
                if (arr[prevIndex] < arr[i]) {
                    dp1[i] = Math.max(dp1[i], 1 + dp1[prevIndex]);
                }
            }
        }

        // Calculate the lengths of decreasing subsequences
        for (int i = n - 1; i >= 0; i--) {
            for (int prevIndex = n - 1; prevIndex > i; prevIndex--) {
                if (arr[prevIndex] < arr[i]) {
                    dp2[i] = Math.max(dp2[i], 1 + dp2[prevIndex]);
                }
            }
        }

        int maxi = 0;

        // Calculate the length of the longest bitonic subsequence
        for (int i = 0; i < n; i++) {
            if (dp1[i] > 1 && dp2[i] > 1) { // Ensure both increasing and decreasing parts exist
                maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
            }
        }

        return maxi;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(LongestBitonicSequence(5, new int[] { 1, 2, 5, 3, 2 })); // Output: 5
        System.out.println(LongestBitonicSequence(8, new int[] { 1, 11, 2, 10, 4, 5, 2, 1 })); // Output: 6
        System.out.println(LongestBitonicSequence(3, new int[] { 10, 20, 30 })); // Output: 0
        System.out.println(LongestBitonicSequence(3, new int[] { 10, 10, 10 })); // Output: 0
    }
}
