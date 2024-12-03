import java.util.*;

public class q19_Minimum_or_Maximum_Falling_Path_Sum {

    // RECURSIVE SOLUTION
    public static int f(int i, int j, int[][] matrix) {

        if (j < 0 || j >= matrix[0].length)
            return Integer.MIN_VALUE;

        if (i == 0)
            return matrix[0][j];

        int up = matrix[i - 1][j] + f(i - 1, j, matrix);
        int leftDiagonal = matrix[i - 1][j] + f(i - 1, j - 1, matrix);
        int rightDiagonal = matrix[i - 1][j] + f(i - 1, j - 1, matrix);

        // Return the maximum of the three paths
        return Math.max(up, Math.max(leftDiagonal, rightDiagonal));
    }

    public static int getMaxPathSum_1(int n, int matrix[][]) {
        int m = matrix[0].length;

        int maxi = Integer.MIN_VALUE;

        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, f(n, j, matrix));
        }
        return maxi;
    }

    // -----------------------------------------------------------------------------------------------------
    // MEMOIZATION

    static int getMaxUtil_2(int i, int j, int m, int matrix[][], int dp[][]) {
        if (j < 0 || j >= m)
            return (int) Math.pow(-10, 9);

        if (i == 0)
            return matrix[0][j];

        if (dp[i][j] != -1)
            return dp[i][j];

        int up = matrix[i][j] + getMaxUtil_2(i - 1, j, m, matrix, dp);
        int leftDiagonal = matrix[i][j] + getMaxUtil_2(i - 1, j - 1, m, matrix, dp);
        int rightDiagonal = matrix[i][j] + getMaxUtil_2(i - 1, j + 1, m, matrix, dp);

        dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));

        return dp[i][j];

    }

    public static int getMaxPathSum_2(int n, int matrix[][]) {
        int m = matrix[0].length;
        int dp[][] = new int[n][m];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        int maxi = Integer.MIN_VALUE;

        for (int j = 0; j < m; j++) {
            int ans = getMaxUtil_2(n - 1, j, m, matrix, dp);
            maxi = Math.max(maxi, ans);
        }
        return maxi;
    }

    // --------------------------------------------------------------------------------------------------------
    // TABULATION
    public static int getMaxPathSum_3(int n, int matrix[][]) {

        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                int leftDiagonal = matrix[i][j];

                if (j - 1 >= 0) {
                    leftDiagonal = leftDiagonal + dp[i - 1][j - 1];
                } else {
                    leftDiagonal = leftDiagonal + (int) Math.pow(-10, 9);
                }

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal = rightDiagonal + dp[i - 1][j + 1];
                } else {
                    rightDiagonal = rightDiagonal + (int) Math.pow(-10, 9);
                }

                dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
            }
        }
        // Find the maximum value in the last row of dp
        int maxi = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, dp[n - 1][j]);
        }
        return maxi;
    }

    // SPACE OPTIMIZATION
    public static int getMaxPathSum_4(List<List<Integer>> matrix) {
        int n = matrix.size();
        int m = matrix.get(0).size();

        List<Integer> prev = new ArrayList<>(Collections.nCopies(m, 0));
        List<Integer> cur = new ArrayList<>(Collections.nCopies(m, 0));

        // Initializing the first row - base condition
        for (int j = 0; j < m; j++) {
            prev.set(j, matrix.get(0).get(j));
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix.get(i).get(j) + prev.get(j);

                int leftDiagonal = matrix.get(i).get(j);
                if (j - 1 >= 0) {
                    leftDiagonal += prev.get(j - 1);
                } else {
                    leftDiagonal += -1e9;
                }

                int rightDiagonal = matrix.get(i).get(j);
                if (j + 1 < m) {
                    rightDiagonal += prev.get(j + 1);
                } else {
                    rightDiagonal += -1e9;
                }

                // Store the maximum of the three paths in cur
                cur.set(j, Math.max(up, Math.max(leftDiagonal, rightDiagonal)));
            }

            // Update the prev list with the values from the cur list for the next row
            prev = new ArrayList<>(cur);
        }

        int maxi = Integer.MIN_VALUE;

        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, prev.get(j));
        }

        return maxi;

    }

    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 10, 4 },
                { 100, 3, 2, 1 },
                { 1, 1, 20, 2 },
                { 1, 2, 2, 1 } };

        int n = matrix.length;

        System.out.println(getMaxPathSum_1(n, matrix));// Recursive Solution
        System.out.println(getMaxPathSum_2(n, matrix));// Memoization Solution
        System.out.println(getMaxPathSum_3(n, matrix));// Tabulation Solution

        // space optimization
        List<List<Integer>> mat = new ArrayList<>();
        mat.add(Arrays.asList(1, 2, 10, 4));
        mat.add(Arrays.asList(100, 3, 2, 1));
        mat.add(Arrays.asList(1, 1, 20, 2));
        mat.add(Arrays.asList(1, 2, 2, 1));

        System.out.println(getMaxPathSum_4(mat));// Space Optimization Solution
    }

}
