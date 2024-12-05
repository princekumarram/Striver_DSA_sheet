import java.util.*;

public class q7_01_Knapsack {

    // RECURSIVE

    public static int knapsackUtil_1(int wt[], int val[], int ind, int W) {
        if (ind == 0) {
            if (wt[0] <= W)
                return val[0];

            else
                return 0;
        }

        int notTaken = 0 + knapsackUtil_1(wt, val, ind - 1, W);

        int taken = Integer.MIN_VALUE;

        if (wt[ind] <= W) {
            taken = val[ind] + knapsackUtil_1(wt, val, ind - 1, W - wt[ind]);
        }

        return Math.max(taken, notTaken);
    }

    public static int knapsack_1(int wt[], int val[], int n, int W) {

        return knapsackUtil_1(wt, val, n - 1, W);

    }

    // -------------------------------------------------------------------
    // MEMOIZATION
    public static int knapsackUtil_2(int wt[], int val[], int ind, int W, int dp[][]) {

        if (ind == 0) {
            if (wt[0] <= W) {
                return val[0];
            } else
                return 0;
        }

        if (dp[ind][W] != -1) {
            return dp[ind][W];
        }

        int notTaken = 0 + knapsackUtil_2(wt, val, ind - 1, W, dp);

        int taken = Integer.MIN_VALUE;

        if (wt[ind] <= W) {
            taken = val[ind] + knapsackUtil_2(wt, val, ind - 1, W - wt[ind], dp);

        }
        dp[ind][W] = Math.max(taken, notTaken);

        return dp[ind][W];

    }

    public static int knapsack_2(int wt[], int val[], int n, int W) {
        int[][] dp = new int[n + 1][W + 1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return knapsackUtil_2(wt, val, n - 1, W, dp);

    }

    // TABULATION
    public static int knapsack_3(int wt[], int val[], int n, int W) {
        int[][] dp = new int[n][W + 1];

        // Base Case

        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {

                int notTaken = dp[ind - 1][cap];

                int taken = Integer.MIN_VALUE;

                if (wt[ind] <= cap) {
                    taken = val[ind] + dp[ind - 1][cap - wt[ind]];
                }

                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }
        return dp[n - 1][W];
    }

    // -------------------------------------------------------------------------------
    // SPACE OPTIMIZATION
    public static int knapsack_4(int wt[], int val[], int n, int W) {

        int prev[] = new int[W + 1];

        // Base Condition: Initialize the first row of the array
        for (int i = wt[0]; i <= W; i++) {
            prev[i] = val[0];
        }

        // Iterate through each item and capacity
        for (int ind = 1; ind < n; ind++) {
            for (int cap = W; cap >= 0; cap--) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = prev[cap];

                // Calculate the maximum value when the current item is taken
                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= cap) {
                    taken = val[ind] + prev[cap - wt[ind]];
                }

                // Update the array with the maximum value for the current capacity
                prev[cap] = Math.max(notTaken, taken);
            }
        }

        // The result is stored in the last element of the array
        return prev[W];
    }

    public static void main(String args[]) {
        // ans=13
        int wt[] = { 1, 2, 4, 5 };
        int val[] = { 5, 4, 8, 6 };
        int W = 5;
        int n = wt.length;

        // Calculate and print the maximum value of items the thief can steal
        // RECURSIVE
        System.out.println("The Maximum value of items the thief can steal is " + knapsack_1(wt, val, n, W));

        // //MEMOIZATION
        System.out.println("The Maximum value of items the thief can steal is " +
                knapsack_2(wt, val, n, W));

        // //TABULATION
        System.out.println("The Maximum value of items the thief can steal is " +
                knapsack_3(wt, val, n, W));

        // //SPACE OPTIMIZATION
        System.out.println("The Maximum value of items the thief can steal is " +
                knapsack_4(wt, val, n, W));
    }

}
