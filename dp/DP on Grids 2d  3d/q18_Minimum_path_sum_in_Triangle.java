import java.util.*;

public class q18_Minimum_path_sum_in_Triangle {

    // MEMEOIZATON

    public static int minPathSumUtil_1(int i, int j, int triangle[][], int n, int dp[][]) {

        if (dp[i][j] != -1)
            return dp[i][j];

        if (i == n - 1)
            return triangle[i][j];

        int down = triangle[i][j] + minPathSumUtil_1(i + 1, j, triangle, n, dp);

        int diagonal = triangle[i][j] + minPathSumUtil_1(i + 1, j + 1, triangle, n, dp);

        return dp[i][j] = Math.min(down, diagonal);
    }

    public static int minPathSum_1(int n, int triangle[][]) {
        int dp[][] = new int[n][n];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return minPathSumUtil_1(0, 0, triangle, n, dp);
    }

    // --------------------------------------------------------------------------------------------

    // TABILATION METHOD

    public static int minPathSum_2(int n, int triangle[][]) {

        int dp[][] = new int[n][n];

        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            {
                for (int j = i; j >= 0; j--) {

                    int down = triangle[i][j] + dp[i + 1][j];
                    int diagonal = triangle[i][j] + dp[i + 1][j + 1];

                    dp[i][j] = Math.min(down, diagonal);
                }
            }

        }
        return dp[0][0];

    }

    // --------------------------------------------------------------------------------------------
    // SPACE OPTIMIZATION
    public static int minPathSum_3(int n, int triangle[][]) {

        int front[] = new int[n];
        int cur_i[] = new int[n];

        for (int j = 0; j < n; j++) {
            front[j] = triangle[n - 1][j];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {

                int down = triangle[i][j] + front[j];
                int diagonal = triangle[i][j] + front[j + 1];

                cur_i[j] = Math.min(down, diagonal);

            }
            front = cur_i.clone();
        }
        return front[0];

    }

    public static void main(String args[]) {
        int triangle[][] = { { 1 },
                { 2, 3 },
                { 3, 6, 7 },
                { 8, 9, 6, 10 } };// ANS=14

        int n = triangle.length;

        System.out.println(minPathSum_1(n, triangle));// Memoization
        System.out.println(minPathSum_2(n, triangle));// Tabulation
        System.out.println(minPathSum_3(n, triangle));// Space Optimizatoin
    }

}
