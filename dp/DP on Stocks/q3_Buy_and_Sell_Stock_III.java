import java.util.Arrays;

class q3_Buy_and_Sell_Stock_III {

    // MEMOIZATION

    static int getAns_1(int[] prices, int n, int ind, int buy, int cap, int[][][] dp) {
        // Base case: If we have processed all stocks or have no capital left, return 0
        // profit
        if (ind == n || cap == 0) {
            return 0;
        }

        // If the result for this state is already calculated, return it
        if (dp[ind][buy][cap] != -1) {
            return dp[ind][buy][cap];
        }

        int profit = 0; // Initialize profit to 0

        if (buy == 0) { // We can buy the stock
            profit = Math.max(0 + getAns_1(prices, n, ind + 1, 0, cap, dp),
                    -prices[ind] + getAns_1(prices, n, ind + 1, 1, cap, dp));
        } else { // We can sell the stock
            profit = Math.max(0 + getAns_1(prices, n, ind + 1, 1, cap, dp),
                    prices[ind] + getAns_1(prices, n, ind + 1, 0, cap - 1, dp));
        }

        // Store the calculated profit in the dp array and return it
        return dp[ind][buy][cap] = profit;
    }

    static int maxProfit_1(int[] prices) {
        int n = prices.length;

        // Creating a 3D dp array of size [n][2][3]
        int[][][] dp = new int[n][2][3];

        // Initialize the dp array with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // Calculate and return the maximum profit
        return getAns_1(prices, n, 0, 0, 2, dp);
    }

    // --------------------------------------------------------------------------------
    // TABULATIION
    static int maxProfit_2(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n + 1][2][3];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 0) {
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][0][cap],
                                -prices[ind] + dp[ind + 1][1][cap]);
                    }

                    if (buy == 1) {
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][1][cap], prices[ind] + dp[ind + 1][0][cap - 1]);
                    }
                }
            }
        }
        return dp[0][0][2];

    }

    // --------------------------------------------------------------------------------

    // SPACE OPTIMIZATION
    static int maxProfit_3(int[] prices) {
        int n = prices.length;

        int[][] ahead = new int[2][3];
        int[][] cur = new int[2][3];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 0) {
                        cur[buy][cap] = Math.max(0 + ahead[0][cap], -prices[ind] + ahead[1][cap]);
                    }

                    if (buy == 1) {
                        cur[buy][cap] = Math.max(0 + ahead[1][cap], prices[ind] + ahead[0][cap - 1]);
                    }
                }
            }
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j < 3; j++) {
                    ahead[i][j] = cur[i][j];
                }
            }
        }
        return ahead[0][2];
    }

    public static void main(String[] args) {
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };

        // Calculate and print the maximum profit

        // MEMOIZATION
        System.out.println("The maximum profit that can be generated is " + maxProfit_1(prices));

        // TABULATION
        System.out.println("The maximum profit that can be generated is " + maxProfit_2(prices));

        // SPACE OPTIMIZATION
        System.out.println("The maximum profit that can be generated is " + maxProfit_3(prices));
        // System.out.println("The maximum profit that can be generated is " +
        // maxProfit_1(prices));
    }
}