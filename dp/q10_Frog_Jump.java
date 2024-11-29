import java.util.*;

public class q10_Frog_Jump {

    // METHOD 1: Recursive Solution
    public static int solve1(int ind, int height[]) {

        if (ind == 0)
            return 0;
        int jumpTwo = Integer.MAX_VALUE;

        int jumpOne = solve1(ind - 1, height) + Math.abs(height[ind] - height[ind - 1]);

        if (ind > 1) {
            jumpTwo = solve1(ind - 2, height) + Math.abs(height[ind] - height[ind - 2]);
        }

        return Math.min(jumpOne, jumpTwo);
    }

    // METHOD 2 : Memoization Solution
    public static int solve2(int ind, int height[], int dp[]) {

        if (ind == 0)
            return 0;

        if (dp[ind] != -1)
            return dp[ind];

        int jumpTwo = Integer.MAX_VALUE;

        int jumpOne = solve2(ind - 1, height, dp) + Math.abs(height[ind] - height[ind - 1]);

        if (ind > 1)
            jumpTwo = solve2(ind - 2, height, dp) + Math.abs(height[ind] - height[ind - 2]);

        return dp[ind] = Math.min(jumpOne, jumpTwo);

    }

    // METHOD 3:Tabulation
    public static int solve3(int n, int height[], int dp[]) {

        dp[0] = 0;

        for (int ind = 1; ind < n; ind++) {
            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne = dp[ind - 1] + Math.abs(height[ind] - height[ind - 1]);

            if (ind > 1)
                jumpTwo = dp[ind - 2] + Math.abs(height[ind] - height[ind - 2]);

            dp[ind] = Math.min(jumpOne, jumpTwo);

        }
        return dp[n - 1];
    }

    // METHOD 4: Space Optimization
    public static int solve4(int n, int height[]) {
        int prev = 0;
        int prev2 = 0;

        for (int ind = 1; ind < n; ind++) {

            int jumpTwo = Integer.MAX_VALUE;
            int jumpOne = prev + Math.abs(height[ind] - height[ind - 1]);

            if (ind > 1)
                jumpTwo = prev2 + Math.abs(height[ind] - height[ind - 2]);

            int curr_i = Math.min(jumpOne, jumpTwo);

            prev2 = prev;
            prev = curr_i;

        }
        return prev;

    }

    public static void main(String args[]) {
        int height[] = { 30, 10, 60, 10, 60, 50 };
        int n = height.length;

        // System.out.println(solve1(n - 1, height));//40 recursive solution

        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        // System.out.println(solve2(n - 1, height, dp));//Memoization

        // System.out.println(solve3(n, height, dp));//Tabulation

        System.out.println(solve4(n, height));

    }

}
