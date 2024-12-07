
import java.util.*;

class q9_Unbounded_Knapsack {

    // MEMOIZATION

    // Recursive function to solve the unbounded knapsack problem
    static int knapsackUtil_1(int[] wt, int[] val, int ind, int W, int[][] dp) {
        // Base case: If there are no more items to consider
        if (ind == 0) {
            // Calculate and return the maximum value possible
            return ((int) (W / wt[0])) * val[0];
        }

        // If the result for this subproblem has already been calculated, return it
        if (dp[ind][W] != -1)
            return dp[ind][W];

        // Calculate the maximum value when the current item is not taken
        int notTaken = 0 + knapsackUtil_1(wt, val, ind - 1, W, dp);

        // Initialize the maximum value when the current item is taken as the minimum
        // integer value
        int taken = Integer.MIN_VALUE;

        // If the weight of the current item is less than or equal to the available
        // capacity (W),
        // calculate the maximum value when the current item is taken
        if (wt[ind] <= W)
            taken = val[ind] + knapsackUtil_1(wt, val, ind, W - wt[ind], dp);

        // Store the result in the dp array and return it
        return dp[ind][W] = Math.max(notTaken, taken);
    }

    // Function to find the maximum value of items that the thief can steal
    static int unboundedKnapsack_1(int n, int W, int[] val, int[] wt) {
        // Create a 2D array to store results of subproblems
        int[][] dp = new int[n][W + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved
        // yet
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // Call the knapsackUtil function to solve the problem
        return knapsackUtil_1(wt, val, n - 1, W, dp);
    }

    // ----------------------------------------------------------------------------------------------------
    // TABULATION
    static int unboundedKnapsack_2(int n, int W, int[] val, int[] wt) {
        // Create a 2D array to store results of subproblems
        int[][] dp = new int[n][W + 1];

        // Base condition: Initialize the dp array for the first item
        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = ((int) i / wt[0]) * val[0];
        }

        // Fill the dp array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = 0 + dp[ind - 1][cap];

                // Initialize the maximum value when the current item is taken as the minimum
                // integer value
                int taken = Integer.MIN_VALUE;

                // If the weight of the current item is less than or equal to the current
                // capacity (cap),
                // calculate the maximum value when the current item is taken
                if (wt[ind] <= cap)
                    taken = val[ind] + dp[ind][cap - wt[ind]];

                // Store the result in the dp array
                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }

        return dp[n - 1][W]; // Return the maximum value that can be obtained
    }

    // -------------------------------------------------------------------------------------------
    // SPACE OPTIMIZATION
    static int unboundedKnapsack_3(int n, int W, int[] val, int[] wt) {
        // Create an array to store the maximum value for each capacity from 0 to W
        int cur[] = new int[W + 1];

        // Base condition: Initialize the cur array for the first item
        for (int i = wt[0]; i <= W; i++) {
            cur[i] = ((int) i / wt[0]) * val[0];
        }

        // Fill the cur array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = cur[cap];

                // Initialize the maximum value when the current item is taken as the minimum
                // integer value
                int taken = Integer.MIN_VALUE;

                // If the weight of the current item is less than or equal to the current
                // capacity (cap),
                // calculate the maximum value when the current item is taken
                if (wt[ind] <= cap)
                    taken = val[ind] + cur[cap - wt[ind]];

                // Store the result in the cur array
                cur[cap] = Math.max(notTaken, taken);
            }
        }

        return cur[W]; // Return the maximum value that can be obtained with the given capacity W
    }

    public static void main(String args[]) {
        int wt[] = { 2, 4, 6 };
        int val[] = { 5, 11, 13 };
        int W = 10;

        int n = wt.length;

        // Call the unboundedKnapsack function and print the result
        System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsack_1(n, W, val, wt));
        System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsack_2(n, W, val, wt));
        System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsack_3(n, W, val, wt));
    }
}
