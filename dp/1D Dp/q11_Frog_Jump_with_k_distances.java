import java.util.Arrays;
import java.util.*;

public class q11_Frog_Jump_with_k_distances {

    // Memoization approach
    public static int solveUntil(int ind, int height[], int k, int dp[]) {

        if (ind == 0)
            return 0;

        if (dp[ind] != -1) {
            return dp[ind];
        }

        int mmSteps = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {

            if (ind - j >= 0) {
                int jump = solveUntil(ind - j, height, k, dp) + Math.abs(height[ind] - height[ind - j]);

                mmSteps = Math.min(mmSteps, jump);
            }

        }
        return dp[ind] = mmSteps;
    }

    public static int solve1(int n, int height[], int k) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        return solveUntil(n - 1, height, k, dp);
    }

    // -------------------------------------------------------------------------
    // Tabulation

    public static int sovleUntil2(int n, int height[], int k, int dp[]) {
        dp[0] = 0;
        // Loop through the array to fill in the dp array

        for (int i = 1; i < n; i++) {

            int mmSteps = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {

                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    mmSteps = Math.min(mmSteps, jump);
                }
            }
            dp[i] = mmSteps;
        }
        return dp[n - 1];
    }

    public static int solve2(int n, int height[], int k) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        return sovleUntil2(n, height, k, dp);
    }

    public static void main(String args[]) {
        int height[] = { 30, 10, 60, 10, 60, 50 };// ans=40
        int n = height.length;
        int k = 2;
        // System.out.println(solve1(n, height, k)); // Print the result of the solve
        // function

        System.out.println(solve2(n, height, k));
    }

}
