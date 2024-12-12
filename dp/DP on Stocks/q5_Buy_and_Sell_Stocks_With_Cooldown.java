import java.util.*;

public class q5_Buy_and_Sell_Stocks_With_Cooldown {

    // RECUSRSION
    public static int fun_1(int ind, int buy, int prices[], int n) {

        if (ind >= n)
            return 0;

        if (buy == 1) {
            return Math.max(-prices[ind] + fun_1(ind + 1, 0, prices, n), 0 + fun_1(ind + 1, 1, prices, n));
        }

        return Math.max(prices[ind] + fun_1(ind + 2, 1, prices, n), 0 + fun_1(ind + 1, 1, prices, n));

    }

    public static int stockProfit_1(int prices[], int n) {

        return fun_1(0, 1, prices, n);
    }

    // --------------------------------------------------------------------------
    // MEMOIZATION
    public static int fun_2(int ind, int buy, int prices[], int n, int dp[][]) {

        if (ind >= n)
            return 0;

        if (buy == 1) {
            return dp[ind][buy] = Math.max(-prices[ind] + fun_2(ind + 1, 0, prices, n, dp),
                    0 + fun_2(ind + 1, 1, prices, n, dp));
        }

        return dp[ind][buy] = Math.max(prices[ind] + fun_2(ind + 2, 1, prices, n, dp),
                0 + fun_2(ind + 1, 1, prices, n, dp));

    }

    public static int stockProfit_2(int prices[], int n) {

        int dp[][] = new int[n + 1][n + 1];
        return fun_2(0, 1, prices, n, dp);
    }

    // ----------------------------------------------------------------------------
    // TABULATION
    public static int stockProfit_3(int prices[], int n) {

        int dp[][] = new int[n + 2][2];

        // Iterate through the array backwards
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;

                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + dp[ind + 1][0], -prices[ind] + dp[ind + 1][1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + dp[ind + 1][1], prices[ind] + dp[ind + 2][0]);
                }

                dp[ind][buy] = profit;
            }
        }

        // The maximum profit is stored in dp[0][0]
        return dp[0][0];
    }

    // ----------------------------------------------------------------------------
    // SPACE OPTIMIZATION
    // SPACE OPTIMIZATION
    public static int stockProfit_4(int prices[], int n) {

        int[] cur = new int[2];
        int[] front1 = new int[2];
        int[] front2 = new int[2];

        // Iterate through the array backwards
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;

                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + front1[0], -prices[ind] + front1[1]);
                } else { // We can sell the stock
                    profit = Math.max(0 + front1[1], prices[ind] + front2[0]);
                }

                cur[buy] = profit;
            }

            // Update the front pointers
            front2 = front1.clone();
            front1 = cur.clone();
        }

        // The maximum profit is stored in cur[0]
        return cur[0];
    }

    public static void main(String args[]) {
        int prices[] = { 4, 9, 0, 4, 10 };// ans-1
        int n = prices.length;

        // recursion
        System.out.println("The maximum profit that can be generated is " + stockProfit_1(prices, n));

        // memoization
        System.out.println("The maximum profit that can be generated is " + stockProfit_2(prices, n));

        // tabulaiton
        System.out.println("The maximum profit that can be generated is " + stockProfit_3(prices, n));

        // space optimization
        System.out.println("The maximum profit that can be generated is " + stockProfit_4(prices, n));
    }
}
