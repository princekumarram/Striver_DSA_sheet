
import java.util.*;

public class q8_Minimum_Coins {

    // RECURSIVE
    public static int f1(int ind, int T, int arr[]) {
        // Base case: If the target is 0, no coins are needed
        if (T == 0) {
            return 0;
        }
        // If no coins are left or target becomes negative
        if (ind == 0) {
            return (T % arr[0] == 0) ? T / arr[0] : Integer.MAX_VALUE;
        }

        // Not taking the coin
        int notTake = f1(ind - 1, T, arr);

        // Taking the coin
        int take = Integer.MAX_VALUE;
        if (arr[ind] <= T) {
            take = 1 + f1(ind, T - arr[ind], arr);
        }
        return Math.min(notTake, take);
    }

    public static int minimumElements_1(int arr[], int T) {
        int n = arr.length;
        int result = f1(n - 1, T, arr); // Pass n-1 for the last index
        return (result == Integer.MAX_VALUE) ? -1 : result; // Return -1 if no solution
    }

    // ------------------------------------------------------------------------------------------------------
    // MEMOIZATION

    public static int f2(int ind, int T, int arr[], int dp[][]) {
        // Base case: If the target is 0, no coins are needed
        if (ind == 0) {
            if (T % arr[0] == 0)
                return T / arr[0];
            else
                return (int) Math.pow(10, 9);
        }

        if (dp[ind][T] != -1) {
            return dp[ind][T];
        }

        int notTake = 0 + f2(ind - 1, T, arr, dp);

        int take = (int) Math.pow(10, 9);
        if (arr[ind] <= T) {
            take = 1 + f2(ind, T - arr[ind], arr, dp);
        }
        dp[ind][T] = Math.min(notTake, take);

        return dp[ind][T];

    }

    public static int minimumElements_2(int arr[], int T) {
        int n = arr.length;
        int[][] dp = new int[n][T + 1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return f2(n - 1, T, arr, dp);
    }

    // -----------------------------------------------------------------------------------------
    // Tabulation
    public static int minimumElements_3(int arr[], int T) {
        int n = arr.length;
        int[][] dp = new int[n][T + 1];
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0)
                dp[0][i] = i / arr[0];
            else
                dp[0][i] = (int) Math.pow(10, 9);

        }

        for (int ind = 1; ind < n; ind++) {
            for (int tar = 0; tar <= T; tar++) {
                int notTake = 0 + dp[ind - 1][tar];
                int take = (int) Math.pow(10, 9);
                if (arr[ind] <= tar) {
                    take = 1 + dp[ind][tar - arr[ind]];
                }
                dp[ind][tar] = Math.min(notTake, take);

            }
        }
        int ans = dp[n - 1][T];

        if (ans >= (int) Math.pow(10, 9))

            return -1;

        return ans;

    }

    // ---------------------------------------------------------------------------------------------
    // SPACE OPTIMIZATION
    public static int minimumElements_4(int arr[], int T) {
        int n = arr.length;
        int prev[] = new int[T + 1];
        int curr[] = new int[T + 1];

        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0) {
                prev[i] = i / arr[0];

            } else
                return (int) Math.pow(10, 9);
        }

        for (int ind = 1; ind < n; ind++) {
            for (int tar = 0; tar <= T; tar++) {
                int notTake = 0 + prev[tar];
                int take = (int) Math.pow(10, 9);
                if (arr[ind] <= tar) {
                    take = 1 + curr[tar - arr[ind]];
                }
                curr[tar] = Math.min(notTake, take);

            }
            prev = curr.clone();
        }

        int ans = prev[T];

        if (ans >= (int) Math.pow(10, 9))

            return -1;

        return ans;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3 };
        int T = 7;

        // Call the minimumElements function and print the result
        // RECURSIVE
        System.out
                .println("The minimum number of coins required to form the target sum is " + minimumElements_1(arr, T));

        // MEMOIZATION
        System.out
                .println("The minimum number of coins required to form the target sum is " + minimumElements_2(arr, T));

        // TABULATION
        System.out
                .println("The minimum number of coins required to form the target sum is " + minimumElements_3(arr, T));

        // SPACE OPTIMIZATION
        System.out
                .println("The minimum number of coins required to form the target sum is " + minimumElements_4(arr, T));
    }
}