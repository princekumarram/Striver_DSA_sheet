import java.util.*;

public class q1_Matrix_Chain_Multiplication {

    // RECURSIVE SOLUTION

    static int f1(int arr[], int i, int j) {

        // base condition
        if (i == j)
            return 0;

        int mini = Integer.MAX_VALUE;

        // partioning loop
        for (int k = i; k <= j - 1; k++) {

            int ans = f1(arr, i, k) + f1(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];

            mini = Math.min(mini, ans);

        }

        return mini;

    }

    static int matrixMultiplication_1(int arr[], int n) {
        int i = 1;
        int j = n - 1;

        return f1(arr, i, j);
    }

    // -----------------------------------------------------------------------------------------
    // MEMOIZATION
    static int f2(int arr[], int i, int j, int dp[][]) {

        // base condition
        if (i == j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int mini = Integer.MAX_VALUE;

        // partioning loop
        for (int k = i; k <= j - 1; k++) {

            int ans = f2(arr, i, k, dp) + f2(arr, k + 1, j, dp) + arr[i - 1] * arr[k] * arr[j];

            mini = Math.min(mini, ans);

        }

        dp[i][j] = mini;
        return mini;

    }

    static int matrixMultiplication_2(int arr[], int n) {
        int i = 1;
        int j = n - 1;

        int dp[][] = new int[n][n];

        for (int row[] : dp)
            Arrays.fill(row, -1);
        return f2(arr, i, j, dp);
    }

    // -------------------------------------------------------------------------------
    // TABULATION
    static int matrixMultiplication_3(int arr[], int n) {

        int dp[][] = new int[n][n];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int mini = Integer.MAX_VALUE;

                // Partionining loop to find the optimal

                for (int k = i; k <= j - 1; k++) {
                    int ans = dp[i][k] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j];

                    mini = Math.min(mini, ans);
                }
                dp[i][j] = mini;
            }
        }

        return dp[1][n - 1];

    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };

        int n = arr.length;

        System.out.println("The minimum number of operations are " +
                matrixMultiplication_1(arr, n));

        System.out.println("The minimum number of operations are " +
                matrixMultiplication_2(arr, n));

        System.out.println("The minimum number of operations are " +
                matrixMultiplication_3(arr, n));
    }
}