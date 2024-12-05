import java.util.*;

public class q8_Coin_Change_2 {

    // RECURSIVE SOLUTION
    public static long countWays_1(int arr[], int n, int target) {

        if (n == 0) {
            if (target % arr[0] == 0) {
                return 1;
            } else
                return 0;
        }

        long notTak = 0 + countWays_1(arr, n - 1, target);

        long take = 0;
        if (arr[n - 1] <= target) {
            take = countWays_1(arr, n - 1, target - arr[n]);
        }

        return notTak + take;

    }

    public static long countWaysToMakeChange_1(int arr[], int n, int target) {

        return countWays_1(arr, n - 1, target);
    }

    // ---------------------------------------------------------------------------
    // MEMOIZATON
    public static long countWays_2(int arr[], int n, int target, long dp[][]) {

        if (n == 0) {

            if (target % arr[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[n][target] != -1) {
            return dp[n][target];
        }

        long notTake = 0 + countWays_2(arr, n - 1, target, dp);

        long take = 0;

        if (arr[n] <= target) {
            take = countWays_2(arr, n, target - arr[n], dp);
        }

        return dp[n][target] = notTake + take;

    }

    public static long countWaysToMakeChange_2(int arr[], int n, int target) {
        long dp[][] = new long[n][target + 1];

        for (long row[] : dp) {
            Arrays.fill(row, -1);
        }

        return countWays_2(arr, n - 1, target, dp);

    }

    // ---------------------------------------------------------------------------
    // TABULATION
    public static long countWaysToMakeChange_3(int arr[], int n, int target) {

        long dp[][] = new long[n][target + 1];

        // Initialize the first row
        for (int i = 0; i <= target; i++) {
            if (i % arr[0] == 0)
                dp[0][i] = 1;
        }

        // Fill the dp table
        for (int ind = 1; ind < n; ind++) {
            for (int tar = 0; tar <= target; tar++) {
                long notTake = dp[ind - 1][tar]; // Not taking the current coin
                long take = 0;

                // Check if we can take the current coin
                if (arr[ind] <= tar) {
                    take = dp[ind][tar - arr[ind]]; // Taking the current coin
                }

                dp[ind][tar] = take + notTake; // Total ways
            }
        }

        return dp[n - 1][target]; // Return the result for the last coin and target
    }

    // ---------------------------------------------------------------------------
    // SPACE OPTIMIZATION
    public static long countWaysToMakeChange_4(int arr[], int n, int target) {
        long prev[] = new long[target + 1];

        for (int i = 0; i <= target; i++) {
            if (i % arr[0] == 0)
                prev[i] = 1;
        }

        for (int ind = 1; ind < n; ind++) {
            long curr[] = new long[target + 1];
            for (int tar = 0; tar <= target; tar++) {

                long notTake = prev[tar];

                long take = 0;

                if (arr[ind] <= tar) {
                    take = curr[tar - arr[ind]];
                }
                curr[tar] = take + notTake;
            }
            prev = curr;
        }
        return prev[target];

    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3 };
        int target = 4;
        int n = arr.length;

        // Call the countWaysToMakeChange function and print the result

        // RECURSIVE SOLUTION
        System.out.println("The total number of ways is " + countWaysToMakeChange_1(arr, n, target));
        // MEMOIZATION
        System.out.println("The total number of ways is " + countWaysToMakeChange_2(arr, n, target));
        // TABULATION
        System.out.println("The total number of ways is " + countWaysToMakeChange_3(arr, n, target));
        // SPACE OPTIMIZATION
        System.out.println("The total number of ways is " + countWaysToMakeChange_4(arr, n, target));
    }

}
