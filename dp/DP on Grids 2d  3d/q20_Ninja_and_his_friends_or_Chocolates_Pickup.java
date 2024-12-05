import java.util.*;

public class q20_Ninja_and_his_friends_or_Chocolates_Pickup {

    // RECURSIVE SOLUTION

    public static int maxChocolatesUtil_1(int i, int j1, int j2, int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        // Base Case

        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) {
            return Integer.MIN_VALUE;// out of bound
        }

        if (i == n - 1) {

            if (j1 == j2)
                return matrix[i][j2];
            else
                return matrix[i][j1] + matrix[i][j2];

        }

        int maxi = Integer.MIN_VALUE;

        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value;
                if (j1 == j2) {
                    value = matrix[i][j1] + maxChocolatesUtil_1(i + 1, j1 + dj1, j2 + dj2, matrix);
                } else {
                    value = matrix[i][j1] + matrix[i][j2] + maxChocolatesUtil_1(i + 1, j1 + dj1, j2 + dj2, matrix);
                }
                maxi = Math.max(maxi, value);
            }
        }

        return maxi;

    }

    public static int maximumChocolates_1(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Start the recursion from the first row
        return maxChocolatesUtil_1(0, 0, m - 1, matrix);

    }

    // ---------------------------------------------------------------------------------------------
    // MEMOIZATION
    public static int maxChocolatesUtil_1(int i, int j1, int j2, int n, int m, int matrix[][], int dp[][][]) {

        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) {
            return Integer.MIN_VALUE;// out of bound
        }

        if (i == n - 1)
            if (j1 == j2)
                return matrix[i][j1];
            else
                return matrix[i][j1] + matrix[i][j2];

        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        int maxi = Integer.MIN_VALUE;

        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {

                int ans;
                if (j1 == j2) {

                    ans = matrix[i][j1] + maxChocolatesUtil_1(i + 1, j1 + di, j2 + dj, n, m, matrix, dp);

                } else {
                    ans = matrix[i][j1] + matrix[i][j2]
                            + maxChocolatesUtil_1(i + 1, j1 + di, j2 + dj, n, m, matrix, dp);
                }

                maxi = Math.max(maxi, ans);
            }
        }
        return dp[i][j1][j2] = maxi;
    }

    public static int maximumChocolates_2(int matrix[][]) {

        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][][] = new int[n][m][m];

        for (int row1[][] : dp) {
            for (int row2[] : row1) {
                Arrays.fill(row2, -1);
            }
        }

        return maxChocolatesUtil_1(0, 0, m - 1, n, m, matrix, dp);
    }

    // -----------------------------------------------------------------------------------------------
    // Tabulation
    public static int maximumChocolates_3(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][][] = new int[n][m][m];

        // Initialize the dp array with values from the last row of the grid
        // Base Case
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {

                if (j1 == j2) {
                    dp[n - 1][j1][j2] = matrix[n - 1][j1];
                } else {
                    dp[n - 1][j1][j2] = matrix[n - 1][j1] + matrix[n - 1][j2];
                }
            }
        }

        // Outer nested loops to traverse the DP array from the second last row to the
        // first row
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {

                    int maxi = Integer.MIN_VALUE;

                    // Inner nested loops to try out 9 options

                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {

                            int ans;

                            if (j1 == j2)
                                ans = matrix[i][j1];
                            else
                                ans = matrix[i][j1] + matrix[i][j2];

                            // Check if the inidices are valid
                            if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))
                                ans = ans + (int) Math.pow(-10, 9);
                            else
                                ans = ans + dp[i + 1][j1 + di][j2 + dj];

                            // Update maxi with the maximum result
                            maxi = Math.max(ans, maxi);

                        }
                    }
                    dp[i][j1][j2] = maxi;

                }

            }
        }
        return dp[0][0][m - 1];
    }

    // ---------------------------------------------------------------------------------------------------
    // Space Optimization
    public static int maximumChocolates_4(int matrix[][]) {

        int n = matrix.length;
        int m = matrix[0].length;

        // Create two 2D arrays to store computed results: front and cur
        int[][] front = new int[m][m];
        int[][] cur = new int[m][m];

        // Initialize the front array with values from the last row of the grid
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    front[j1][j2] = matrix[n - 1][j1];
                else
                    front[j1][j2] = matrix[n - 1][j1] + matrix[n - 1][j2];
            }
        }

        // Outer nested loops to traverse the DP array from the second last row to the
        // first row
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = Integer.MIN_VALUE;

                    // Inner nested loops to try out 9 options
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;

                            if (j1 == j2)
                                ans = matrix[i][j1];
                            else
                                ans = matrix[i][j1] + matrix[i][j2];

                            // Check if the indices are valid
                            if ((j1 + di < 0 || j1 + di >= m) || (j2 + dj < 0 || j2 + dj >= m))
                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += front[j1 + di][j2 + dj];

                            // Update maxi with the maximum result
                            maxi = Math.max(ans, maxi);
                        }
                    }
                    // Store the result in the cur array
                    cur[j1][j2] = maxi;
                }
            }

            // Update the front array with the values from the cur array for the next row
            for (int a = 0; a < m; a++) {
                front[a] = cur[a].clone();
            }
        }

        // The final result is stored at the top left corner of the front array
        return front[0][m - 1];

    }

    public static void main(String args[]) {

        int matrix[][] = { { 2, 3, 1, 2 },
                { 3, 4, 2, 2 },
                { 5, 6, 3, 5 } };// ans=21

        System.out.println(maximumChocolates_1(matrix));// Recursive Solution
        System.out.println(maximumChocolates_2(matrix));// Memoization Solution
        System.out.println(maximumChocolates_3(matrix));// Tabulation Solution
        System.out.println(maximumChocolates_4(matrix));// Space Optimization Solution

    }

}
