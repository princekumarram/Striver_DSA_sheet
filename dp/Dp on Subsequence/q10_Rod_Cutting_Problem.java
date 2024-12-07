import java.util.Arrays;

public class q10_Rod_Cutting_Problem {

    // MEMOIZATION

    private int solve_1(int ind, int n, int[] price, int[][] dp) {
        if (ind == 0) {
            return n * price[0];
        }
        if (dp[ind][n] != -1) {
            return dp[ind][n];
        }

        int not_cut = solve_1(ind - 1, n, price, dp);
        int cut = Integer.MIN_VALUE;
        if (ind + 1 <= n) {
            cut = price[ind] + solve_1(ind, n - (ind + 1), price, dp);
        }

        return dp[ind][n] = Math.max(cut, not_cut);
    }

    public int cutRod_1(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve_1(n - 1, n, price, dp);
    }

    // TABULATION

    public int cutRod_2(int[] price) {
        int n = price.length;

        // Initialize the DP table
        int[][] dp = new int[n][n + 1];

        // Base case: Filling for the 0th index
        for (int N = 0; N <= n; N++) {
            dp[0][N] = N * price[0];
        }

        // Fill the DP table iteratively
        for (int ind = 1; ind < n; ind++) {
            for (int j = 0; j <= n; j++) {
                // Not taking the current piece
                int notTaken = dp[ind - 1][j];

                // Taking the current piece
                int take = Integer.MIN_VALUE;
                int rodLength = ind + 1;
                if (rodLength <= j) {
                    take = price[ind] + dp[ind][j - rodLength];
                }

                // Update DP table with the maximum of taking or not taking
                dp[ind][j] = Math.max(take, notTaken);
            }
        }

        // The answer will be stored in dp[n-1][n]
        return dp[n - 1][n];
    }

    public int cutRod_3(int[] price) {
        int n = price.length;

        // Previous row to store DP states
        int[] prev = new int[n + 1];

        // Base case: When only the first piece is considered
        for (int N = 0; N <= n; N++) {
            prev[N] = N * price[0];
        }

        // Iteratively build up the solution
        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[n + 1]; // Temporary array for the current row

            for (int j = 0; j <= n; j++) {
                // Not taking the current piece
                int notTake = prev[j];

                // Taking the current piece
                int take = Integer.MIN_VALUE;
                int rodLength = ind + 1;

                if (rodLength <= j) {
                    take = price[ind] + curr[j - rodLength]; // Use curr for correct calculations
                }

                curr[j] = Math.max(take, notTake);
            }

            // Update prev to be the current row
            prev = curr;
        }

        // The result is stored in prev[n]
        return prev[n];
    }

    public static void main(String[] args) {
        q10_Rod_Cutting_Problem rodCutting = new q10_Rod_Cutting_Problem();
        int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };// ans->22
        System.out.println("Maximum revenue: " + rodCutting.cutRod_1(price));
        System.out.println("Maximum revenue: " + rodCutting.cutRod_2(price));
        System.out.println("Maximum revenue: " + rodCutting.cutRod_3(price));

    }
}