import java.util.*;

public class q1_Longest_Increasing_Subsequence {

    // RECURSIVE SOLUTION

    static int getAns_1(int ind, int prev_index, int arr[], int n) {
        if (ind == n)
            return 0;

        int notTake = 0 + getAns_1(ind + 1, prev_index, arr, n);

        int take = 0;

        if (prev_index == -1 || arr[ind] > arr[prev_index]) {
            take = 1 + getAns_1(ind + 1, ind, arr, n);
        }

        return Math.max(take, notTake);
    }

    public static int longestIncreasingSubsequence_1(int arr[], int n) {

        return getAns_1(0, -1, arr, n);
    }

    // MEMOIZATION SOLUTION

    static int getAns_2(int ind, int prev_index, int arr[], int n, int dp[][]) {
        if (ind == n)
            return 0;

        if (dp[ind][prev_index + 1] != -1)
            return dp[ind][prev_index + 1];

        int notTake = 0 + getAns_2(ind + 1, prev_index, arr, n, dp);

        int take = 0;

        if (prev_index == -1 || arr[ind] > arr[prev_index]) {
            take = 1 + getAns_2(ind + 1, ind, arr, n, dp);
        }

        return dp[ind][prev_index + 1] = Math.max(take, notTake);
    }

    public static int longestIncreasingSubsequence_2(int arr[], int n) {

        int dp[][] = new int[n][n + 1];

        for (int row[] : dp)
            Arrays.fill(row, -1);

        return getAns_2(0, -1, arr, n, dp);
    }

    // TABLATION

    public static int longestIncreasingSubsequence_3(int arr[], int n) {
        int dp[][] = new int[n + 1][n + 1];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prev_index = ind - 1; prev_index >= -1; prev_index--) {

                int notTake = 0 + dp[ind + 1][prev_index + 1];

                int take = 0;

                if (prev_index == -1 || arr[ind] > arr[prev_index]) {
                    take = 1 + dp[ind + 1][ind + 1];
                }
                dp[ind][prev_index + 1] = Math.max(notTake, take);
            }

        }
        return dp[0][0];
    }

    // SPACE OTPIMIZATIOIN
    public static int longestIncreasingSubsequence_4(int arr[], int n) {
        int next[] = new int[n + 1];
        int cur[] = new int[n + 1];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prev_index = ind - 1; prev_index >= -1; prev_index--) {

                int notTake = 0 + next[prev_index + 1];

                int take = 0;

                if (prev_index == -1 || arr[ind] > arr[prev_index]) {
                    take = 1 + next[ind + 1];
                }
                cur[prev_index + 1] = Math.max(notTake, take);
            }
            next = cur.clone();
        }
        return cur[0];

    }

    // TABULATION OTPIMIZATIOIN
    public static int longestIncreasingSubsequence_5(int arr[], int n) {

        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i <= n - 1; i++) {
            for (int prev_index = 0; prev_index <= i - 1; prev_index++) {

                if (arr[prev_index] < arr[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[prev_index]);
                }
            }
        }

        int ans = -1;

        for (int i = 0; i <= n - 1; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    // PRINTING THE LIS
    public static int longestIncreasingSubsequence_6(int arr[], int n) {

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        Arrays.fill(hash, 1);

        for (int i = 0; i <= n - 1; i++) {

            hash[i] = i; // initializing with current index
            for (int prev_index = 0; prev_index <= i - 1; prev_index++) {

                if (arr[prev_index] < arr[i] && 1 + dp[prev_index] > dp[i]) {
                    dp[i] = 1 + dp[prev_index];
                    hash[i] = prev_index;
                }
            }
        }

        int ans = -1;
        int lastIndex = -1;

        for (int i = 0; i <= n - 1; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[lastIndex]);

        while (hash[lastIndex] != lastIndex) { // till not reach the initialization value
            lastIndex = hash[lastIndex];
            temp.add(arr[lastIndex]);
        }

        // reverse the array

        System.out.print("The subsequence elements are ");

        for (int i = temp.size() - 1; i >= 0; i--) {
            System.out.print(temp.get(i) + " ");
        }
        System.out.println();

        return ans;
    }

    public static void main(String args[]) {
        int arr[] = { 10, 9, 2, 5, 3, 7, 101, 18 };

        int n = arr.length;

        // RECURSIVE SOLUTION
        System.out.println(
                "The length of the longest increasing subsequence is " + longestIncreasingSubsequence_1(arr, n));

        // MEMOIZATION
        System.out.println(
                "The length of the longest increasing subsequence is " + longestIncreasingSubsequence_2(arr, n));

        // TABULATION
        System.out.println(
                "The length of the longest increasing subsequence is " + longestIncreasingSubsequence_3(arr, n));

        // SPACE OPTIMIZATION
        System.out.println(
                "The length of the longest increasing subsequence is " + longestIncreasingSubsequence_4(arr, n));

        // SPACE OPTIMIZATION
        System.out.println(
                "The length of the longest increasing subsequence is " + longestIncreasingSubsequence_5(arr, n));

        // SPACE OPTIMIZATION
        System.out.println(
                "The length of the longest increasing subsequence is " + longestIncreasingSubsequence_6(arr, n));
    }
}