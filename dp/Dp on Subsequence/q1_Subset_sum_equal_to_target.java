import java.util.*;

public class q1_Subset_sum_equal_to_target {

    // RECURSIVE SOLUTION

    public static boolean subsetSumToK_1(int ind, int target, int arr[]) {

        // Base case: if target is 0, we found a subset
        if (target == 0)
            return true;

        // If no elements left and target is not met
        if (ind == 0)
            return arr[ind] == target;

        // Exclude the current element
        boolean notTaken = subsetSumToK_1(ind - 1, target, arr);

        // Include the current element if it does not exceed the target
        boolean taken = false;
        if (arr[ind - 1] <= target) // Note: use arr[ind - 1] to access the current element
            taken = subsetSumToK_1(ind - 1, target - arr[ind - 1], arr); // Reduce target by arr[ind - 1]

        // Return true if either taken or not taken is true
        return notTaken || taken;
    }

    // -----------------------------------------------------------------------------------
    // MEMOIZATION

    public static boolean subsetSumUtil_2(int ind, int target, int arr[], int dp[][]) {

        if (target == 0)
            return true;

        if (ind == 0)
            return arr[0] == target;

        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;

        boolean notTaken = subsetSumUtil_2(ind - 1, target, arr, dp);

        boolean taken = false;
        if (arr[ind] <= target)
            taken = subsetSumUtil_2(ind - 1, target - arr[ind], arr, dp);

        dp[ind][target] = notTaken || taken ? 1 : 0;

        return notTaken || taken;
    }

    public static boolean subsetSumToK_2(int n, int k, int arr[]) {

        int dp[][] = new int[n][k + 1];

        for (int row[] : dp)
            Arrays.fill(row, -1);

        return subsetSumUtil_2(n - 1, k, arr, dp);

    }

    // -------------------------------------------------------------------------------------------
    // TABULATION

    public static boolean subsetSumToK_3(int n, int k, int arr[]) {
        boolean dp[][] = new boolean[n][k + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {

                boolean notTaken = dp[ind - 1][target];

                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }

                // Store the result in the Dp the
                dp[ind][target] = notTaken || taken;

            }
        }
        return dp[n - 1][k];
    }

    // -------------------------------------------------------------------------------------------
    // SPACCE OPTIMIZATION

    public static boolean subsetSumToK_4(int n, int k, int arr[]) {
        boolean prev[] = new boolean[k + 1];

        prev[0] = true;

        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            boolean curr[] = new boolean[k + 1];

            curr[0] = true;

            for (int target = 1; target <= k; target++) {
                boolean notTaken = prev[target];

                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = prev[target - arr[ind]];
                }

                curr[target] = notTaken || taken;
            }
            prev = curr;
        }
        return prev[k];
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;

        // Check if there exists a subset with the given target sum
        if (subsetSumToK_1(n, k, arr)) // RECURSIVE SOLUTION
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");

        // MEMOIZATIO SOLUTIOIN

        if (subsetSumToK_2(n, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");

        // TABULATION
        if (subsetSumToK_3(n, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");

        // SPACE OPTIMIZATION
        if (subsetSumToK_4(n, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }
}