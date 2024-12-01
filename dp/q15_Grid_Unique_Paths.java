import java.util.*;

public class q15_Grid_Unique_Paths {

    // MEMOIZATION

    static int countWaysUtil_1(int i, int j, int dp[][]) {
        if (i == 0 && j == 0)
            return 1;

        if (i < 0 || j < 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int up = countWaysUtil_1(i - 1, j, dp);
        int left = countWaysUtil_1(i, j - 1, dp);

        return dp[i][j] = up + left;
    }

    static int countWays1(int m, int n) {
        int[][] dp = new int[m][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return countWaysUtil_1(m - 1, n - 1, dp);
    }

    // --------------------------------------------------------
    // TABULATION

    public static int countWaysUtil_2(int m, int n, int dp[][]) {

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;

                if (i > 0)
                    up = dp[i - 1][j];
                if (j > 0)
                    left = dp[i][j - 1];

                dp[i][j] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }

    public static int countWays2(int m, int n) {
        int[][] dp = new int[m][n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return countWaysUtil_2(m, n, dp);

    }

    // Space Optimization

    public static int countWays3(int m, int n) {
        int prev[] = new int[n];

        for (int i = 0; i < m; i++) {
            int temp[] = new int[n];

            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = temp[j - 1];

                temp[j] = -up + left;
            }
            prev = temp;

        }
        return prev[n - 1];

    }

    public static void main(String args[]) {
        int m = 3, n = 2;// ans=3 ways

        // System.out.println(countWays1(m, n));//memoizaton

        // System.out.println(countWays2(m, n));// Tabulaton

        System.out.println(countWays3(m, n));// Space Optimizaton
    }

}
