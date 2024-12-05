import java.util.*;

public class q4_Count_Subsets_with_Sum_K {

    // RECURSIVE SOLUTION

    public static int f(int idx, int k, int arr[]) {
        // Base case: If target sum k is 0, there's 1 way (choose nothing)
        if (k == 0)
            return 1;

        // Base case: If no elements are left (idx < 0), no way to form k
        if (idx < 0)
            return 0;

        // Not taking the current element
        int notTaken = f(idx - 1, k, arr);

        // Taking the current element (only if it doesn't exceed k)
        int taken = 0;
        if (arr[idx] <= k) {
            taken = f(idx - 1, k - arr[idx], arr);
        }

        // Total ways by including or excluding the current element
        return notTaken + taken;
    }

    // Wrapper function
    public static int findWays_1(int arr[], int k) {
        int n = arr.length;
        // Start recursion from the last index (n-1)
        return f(n - 1, k, arr);
    }

    // ---------------------------------------------------------------------------------------------------------
    // MEMOIZATION
    public static int findWaysUtil_2(int ind, int target, int arr[], int dp[][]) {
        if (target == 0)
            return 1;

        if (ind == 0)
            return arr[0] == target ? 1 : 0;
        if (dp[ind][target] != -1)
            return dp[ind][target];

        int notTaken = findWaysUtil_2(ind - 1, target, arr, dp);

        int taken = 0;
        if (arr[ind] <= target) {
            taken = findWaysUtil_2(ind - 1, target - arr[ind], arr, dp);
        }

        return dp[ind][target] = notTaken + taken;

    }

    public static int findWays_2(int arr[], int k) {
        int n = arr.length;

        int dp[][] = new int[n][k + 1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return findWaysUtil_2(n - 1, k, arr, dp);
    }

    // -------------------------------------------------------------------------------------------------------
    // TABULATION
    public static int findWays_3(int arr[], int k) {
        int n = arr.length;
        int dp[][] = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        if (arr[0] <= k) {
            dp[0][arr[0]] = 1;
        }

        // Fill dp[][] in bottom up manner
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                int notTaken = dp[ind - 1][target];

                int taken = 0;

                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }

                dp[ind][target] = taken + notTaken;
            }

        }
        return dp[n - 1][k];
    }

    // -------------------------------------------------------------------------------------------------------
    // SPACE OPTIMIZATIOIN
    public static int findWays_4(int arr[], int k) {
        int n = arr.length;

        int prev[] = new int[k + 1];
        prev[0] = 1;

        if (arr[0] <= k) {
            prev[arr[0]] = 1;
        }

        for (int ind = 1; ind < n; ind++) {
            int curr[] = new int[k + 1];
            curr[0] = 1;

            for (int target = 1; target <= k; target++) {
                int notTaken = prev[target];

                int taken = 0;
                if (arr[ind] <= target) {
                    taken = prev[target - arr[ind]];
                }
                curr[target] = notTaken + taken;
            }
            prev = curr;
        }

        return prev[k];

    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 2, 3 };
        int k = 3;

        // Calculate and print the number of subsets that sum up to k
        System.out.println("The number of subsets found are " + findWays_1(arr, k));// RECURSIVE
        System.out.println("The number of subsets found are " + findWays_2(arr, k));// MEMOIZATION
        System.out.println("The number of subsets found are " + findWays_3(arr, k));// TABULATION
        System.out.println("The number of subsets found are " + findWays_4(arr, k));// SPACE OPTIMIZED
    }

}
