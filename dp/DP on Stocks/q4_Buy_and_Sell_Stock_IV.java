import java.util.*;
//RECURSIVE SOLUTION

class q4_Buy_and_Sell_Stock_IV {

    static int f_1(int ind, int tranNo, int[] prices, int n, int k) {
        // Base case: no more transactions or end of the price array
        if (ind == n || tranNo == 2 * k)
            return 0;

        if (tranNo % 2 == 0) { // Buy phase
            return Math.max(
                    -prices[ind] + f_1(ind + 1, tranNo + 1, prices, n, k), // Buy at current index
                    0 + f_1(ind + 1, tranNo, prices, n, k) // Skip buying
            );
        } else { // Sell phase
            return Math.max(
                    prices[ind] + f_1(ind + 1, tranNo + 1, prices, n, k), // Sell at current index
                    0 + f_1(ind + 1, tranNo, prices, n, k) // Skip selling
            );
        }
    }

    public static int maxProfit_1(int k, int[] prices) {
        return f_1(0, 0, prices, prices.length, k);
    }

    // MEMOIZATION

    static int f_2(int ind, int tranNo, int[] prices, int n, int k, int[][] dp) {
        // Base case: no more transactions or end of the price array
        if (ind == n || tranNo == 2 * k)
            return 0;

        // Return precomputed result if it exists
        if (dp[ind][tranNo] != -1)
            return dp[ind][tranNo];

        if (tranNo % 2 == 0) { // Buy phase
            dp[ind][tranNo] = Math.max(
                    -prices[ind] + f_2(ind + 1, tranNo + 1, prices, n, k, dp), // Buy at current index
                    0 + f_2(ind + 1, tranNo, prices, n, k, dp) // Skip buying
            );
        } else { // Sell phase
            dp[ind][tranNo] = Math.max(
                    prices[ind] + f_2(ind + 1, tranNo + 1, prices, n, k, dp), // Sell at current index
                    0 + f_2(ind + 1, tranNo, prices, n, k, dp) // Skip selling
            );
        }

        return dp[ind][tranNo];
    }

    public static int maxProfit_2(int k, int[] prices) {
        int n = prices.length;

        // We need a larger array to store transaction states (2*k transactions)
        int[][] dp = new int[n][2 * k + 1];

        // Initialize dp array with -1 for memoization
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return f_2(0, 0, prices, n, k, dp);
    }

    // TABULATION

    public static int maxProfit_3(int k, int[] prices) {
        int n = prices.length;

        if (n == 0 || k == 0)
            return 0; // Edge case: no prices or no transactions allowed

        // DP table to store maximum profit for given `ind` and `tranNo`
        int[][] dp = new int[n + 1][2 * k + 1];

        // Initialize the DP table for base cases
        for (int tranNo = 0; tranNo <= 2 * k; tranNo++) {
            dp[n][tranNo] = 0; // No profit possible when `ind == n`
        }

        // Fill the DP table in reverse order
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int tranNo = 0; tranNo < 2 * k; tranNo++) {
                if (tranNo % 2 == 0) { // Buy phase
                    dp[ind][tranNo] = Math.max(
                            -prices[ind] + dp[ind + 1][tranNo + 1], // Buy at current index
                            dp[ind + 1][tranNo] // Skip buying
                    );
                } else { // Sell phase
                    dp[ind][tranNo] = Math.max(
                            prices[ind] + dp[ind + 1][tranNo + 1], // Sell at current index
                            dp[ind + 1][tranNo] // Skip selling
                    );
                }
            }
        }

        return dp[0][0]; // The result is stored at the starting index with 0 transactions completed
    }

    public static int maxProfit_4(int k, int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0; // Edge case: no prices

        // Arrays to store the current and next states
        int[] next = new int[2 * k + 1];
        int[] curr = new int[2 * k + 1];

        // Traverse the prices array in reverse
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int tranNo = 2 * k - 1; tranNo >= 0; tranNo--) {
                if (tranNo % 2 == 0) { // Buy phase
                    curr[tranNo] = Math.max(
                            -prices[ind] + next[tranNo + 1], // Buy
                            next[tranNo] // Skip buying
                    );
                } else { // Sell phase
                    curr[tranNo] = Math.max(
                            prices[ind] + next[tranNo + 1], // Sell
                            next[tranNo] // Skip selling
                    );
                }
            }
            // Move current to next for the next iteration
            next = curr.clone();
        }

        return next[0]; // The answer is stored in next[0]
    }

    public static void main(String[] args) {
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
        int n = prices.length;
        int k = 2;

        // ans-6

        System.out.println("The maximum profit that can be generated is " + maxProfit_1(k, prices));
        System.out.println("The maximum profit that can be generated is " + maxProfit_2(k, prices));
        System.out.println("The maximum profit that can be generated is " + maxProfit_3(k, prices));
        System.out.println("The maximum profit that can be generated is " + maxProfit_4(k, prices));
    }

}
