import java.util.*;

public class q17_Minimum_Path_Sum_In_a_Grid {

    // Memoization

    static int minSumPathUtil_1(int i, int j, int[][] matrix, int[][] dp) {
        // Base cases
        if (i == 0 && j == 0)
            return matrix[0][0]; // If we're at the top-left cell, return its value
        if (i < 0 || j < 0)
            return (int) Math.pow(10, 9); // If we're out of bounds, return a large value
        if (dp[i][j] != -1)
            return dp[i][j]; // If we've already calculated this cell, return the stored result

        // Calculate the sum of the current cell plus the minimum sum path from above
        // and from the left
        int up = matrix[i][j] + minSumPathUtil_1(i - 1, j, matrix, dp);
        int left = matrix[i][j] + minSumPathUtil_1(i, j - 1, matrix, dp);

        // Store the minimum of the two possible paths
        return dp[i][j] = Math.min(up, left);
    }

    public static int minSumPath1(int n, int m, int matrix[][]) {
        int[][] dp = new int[n][m];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return minSumPathUtil_1(n - 1, m - 1, matrix, dp);
    }

    // -----------------------------------------------------------------------------------------------------

    // Tabulation

    public static int minSumPath2(int n, int m, int matrix[][]) {
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    int up = matrix[i][j];
                    if (i > 0)
                        up = up + dp[i - 1][j];

                    else
                        up = up + (int) Math.pow(10, 9);

                    int left = matrix[i][j];

                    if (j > 0)
                        left = left + dp[i][j - 1];

                    else
                        left = left + (int) Math.pow(10, 9);
                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    // Space Optimization

    public static int minSumPath3(int n, int m, int matrix[][]) {

        int prev[] = new int[m];

        for (int i = 0; i < n; i++) {
            int temp[] = new int[m];

            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    temp[j] = matrix[i][j];
                } else {
                    int up = matrix[i][j];

                    if (i > 0)
                        up = up + prev[j];

                    else
                        up = up + (int) Math.pow(10, 9);

                    int left = matrix[i][j];
                    if (j > 0)
                        left = left + temp[j - 1];
                    else
                        left = left + (int) Math.pow(10, 9);

                    temp[j] = Math.min(up, left);
                }
            }
            prev = temp;
        }

        return prev[m - 1];

    }

    public static void main(String[] args) {
        int matrix[][] = {
                { 5, 9, 6 },
                { 11, 5, 2 }
        };

        int n = matrix.length;
        int m = matrix[0].length;
        // Calculate and print the minimum sum path in the matrix
        System.out.println(minSumPath1(n, m, matrix));// Memoization
        System.out.println(minSumPath2(n, m, matrix));// Memoization
        System.out.println(minSumPath3(n, m, matrix));// Space Optimization
    }

}
