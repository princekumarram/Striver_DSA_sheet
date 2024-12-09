import java.util.*;

public class q2_Buy_and_Sell_Stock_II {

    // RECURSIVE SOLUTION
    public static int maxProfitUtil_1(int ind, int buy, int arr[], int n) {

        if (ind == n) {
            return 0;
        }

        int profit = 0;
        if (buy == 0) { // We can buy
            int op1 = 0 + maxProfitUtil_1(ind + 1, 0, arr, n); // Not buying
            int op2 = -arr[ind] + maxProfitUtil_1(ind + 1, 1, arr, n); // Buying
            profit = Math.max(op1, op2);
        }
        if (buy == 1) { // We can sell
            int op1 = 0 + maxProfitUtil_1(ind + 1, 1, arr, n); // Not selling
            int op2 = arr[ind] + maxProfitUtil_1(ind + 1, 0, arr, n); // Selling
            profit = Math.max(op1, op2);
        }
        return profit;
    }

    public static long getMaximumProfit_1(int[] Arr, int n) {
        return maxProfitUtil_1(0, 0, Arr, n); // Start with buy = 0
    }

    // -------------------------------------------------------------------------------------------

    // MEMOIZATION
    public static int maxProfitUtil_2(int ind, int buy, int arr[], int n, int dp[][]) {

        if (ind == n) {
            return 0;
        }

        if (dp[ind][buy] != -1)
            return dp[ind][buy];

        int profit = 0;
        if (buy == 0) { // We can buy
            int op1 = 0 + maxProfitUtil_2(ind + 1, 0, arr, n, dp); // Not buying
            int op2 = -arr[ind] + maxProfitUtil_2(ind + 1, 1, arr, n, dp); // Buying
            profit = Math.max(op1, op2);
        }
        if (buy == 1) { // We can sell
            int op1 = 0 + maxProfitUtil_2(ind + 1, 1, arr, n, dp); // Not selling
            int op2 = arr[ind] + maxProfitUtil_2(ind + 1, 0, arr, n, dp); // Selling
            profit = Math.max(op1, op2);
        }

        return dp[ind][buy] = profit;
    }

    public static long getMaximumProfit_2(int[] Arr, int n) {

        int dp[][] = new int[n + 1][n + 1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return maxProfitUtil_2(0, 0, Arr, n, dp); // Start with buy = 0
    }

    // -------------------------------------------------------------------------------------------------
    public static long getMaximumProfit_3(int[] Arr, int n) {
        // Create a dp array of size [n+1][2]
        long[][] dp = new long[n + 1][2];

        // Base case: At the end of the array, profit is 0
        for (int buy = 0; buy <= 1; buy++) {
            dp[n][buy] = 0;
        }

        // Fill the dp array from the bottom up
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    // We can buy the stock or skip
                    dp[ind][buy] = Math.max(-Arr[ind] + dp[ind + 1][0], dp[ind + 1][1]);
                } else {
                    // We can sell the stock or skip
                    dp[ind][buy] = Math.max(Arr[ind] + dp[ind + 1][1], dp[ind + 1][0]);
                }
            }
        }

        // Return the result starting from the first index with a "buy" option
        return dp[0][1];
    }

    public static long getMaximumProfit_4(int[] Arr, int n) {
        // Create arrays 'ahead' and 'cur' to store the maximum profit ahead and current
        // profit
        long[] ahead = new long[2];
        long[] cur = new long[2];

        // Base condition: If we have no stocks to buy or sell, profit is 0
        ahead[0] = ahead[1] = 0;

        long profit = 0;

        // Iterate through the array in reverse to calculate the maximum profit
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + ahead[0], -Arr[ind] + ahead[1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + ahead[1], Arr[ind] + ahead[0]);
                }
                cur[buy] = profit;
            }

            // Update the 'ahead' array with the current profit values
            System.arraycopy(cur, 0, ahead, 0, 2);
        }
        return cur[0];
    }

    public static long getMaximumProfit_5(int[] Arr, int n) {
        int aheadNotBuy, aheadBuy, curBuy, curNotBuy;
        aheadNotBuy = aheadBuy = 0;

        for (int ind = n - 1; ind >= 0; ind--) {

            curNotBuy = Math.max(Arr[ind] + aheadBuy, 0 + aheadNotBuy);
            curBuy = Math.max(-Arr[ind] + aheadNotBuy, 0 + aheadBuy);

            aheadBuy = curBuy;
            aheadNotBuy = curNotBuy;

        }

        return aheadBuy;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] Arr = { 7, 1, 5, 3, 6, 4 }; // Changed to int[]

        // Calculate and print the maximum profit

        // RECURSIVE
        System.out.println("The maximum profit that can be generated is " + getMaximumProfit_1(Arr, n));

        // MEMOIZATION
        System.out.println("The maximum profit that can be generated is " + getMaximumProfit_2(Arr, n));

        // TABULATION
        System.out.println("The maximum profit that can be generated is " + getMaximumProfit_3(Arr, n));

        // SPACE OPTIMIZATION-2D array
        System.out.println("The maximum profit that can be generated is " +
                getMaximumProfit_4(Arr, n));

        // SPACE OPTIMIZATION-1D array
        System.out.println("The maximum profit that can be generated is " +
                getMaximumProfit_5(Arr, n));
    }
}