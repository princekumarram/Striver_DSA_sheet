import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class q3_Partition_Set_Into_2_Subsets_With_Min_Absolute_Sum_Diff {

    // MEMOIZATION
    public static int minSubsetSumDifference_1(ArrayList<Integer> arr, int n) {
        int totSum = 0;

        for (int i = 0; i < n; i++) {
            totSum += arr.get(i);
        }

        boolean dp[][] = new boolean[n][totSum + 1];

        for (int i = 0; i <= totSum; i++) {
            dp[0][i] = (i == arr.get(0));

        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= totSum; target++) {

                boolean notTaken = dp[ind - 1][target];

                boolean taken = false;

                if (arr.get(ind) <= target) {
                    taken = dp[ind - 1][target - arr.get(ind)];
                }

                // Update the DP table for the current element and target sum
                dp[ind][target] = notTaken || taken;

            }
        }

        int mini = Integer.MAX_VALUE;

        for (int i = 0; i <= totSum; i++) {
            if (dp[n - 1][i]) {
                int diff = Math.abs(i - (totSum - i));

                mini = Math.min(mini, diff);
            }
        }
        return mini;

    }

    // TABULATIOIN
    public static int minSubsetSumDifference_2(ArrayList<Integer> arr, int n) {
        int totSum = 0;

        for (int i = 0; i < n; i++) {
            totSum += arr.get(i);
        }

        boolean dp[][] = new boolean[n][totSum + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr.get(0) <= totSum) {
            dp[0][totSum] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= totSum; target++) {
                boolean notTaken = dp[ind - 1][target];

                boolean taken = false;

                if (arr.get(ind) <= target) {
                    taken = dp[ind - 1][target - arr.get(ind)];
                }

                dp[ind][target] = notTaken || taken;
            }
        }

        int mini = Integer.MAX_VALUE;

        for (int i = 0; i <= totSum; i++) {
            if (dp[n - 1][i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }

        }
        return mini;
    }

    // SPACE OPTIMIZATION
    public static int minSubsetSumDifference_3(ArrayList<Integer> arr, int n) {
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += arr.get(i);
        }

        boolean prev[] = new boolean[totSum + 1];

        prev[0] = true;
        if (arr.get(0) <= totSum) {
            prev[arr.get(0)] = true;
        }

        for (int ind = 1; ind < n; ind++) {
            boolean curr[] = new boolean[totSum + 1];
            curr[0] = true;

            for (int target = 1; target <= totSum; target++) {

                boolean notTaken = prev[target];

                boolean taken = false;

                if (arr.get(ind) <= target) {
                    taken = prev[target - arr.get(ind)];
                }

                curr[target] = notTaken || taken;
            }
            prev = curr;
        }

        int mini = Integer.MAX_VALUE;

        for (int i = 0; i <= totSum; i++) {
            if (prev[i]) {
                int diff = Math.abs(i - (totSum - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;

    }

    public static void main(String args[]) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4));// ans->0;
        int n = arr.size();

        // Calculate and print the minimum absolute difference
        // MEMOIZATION
        System.out.println("The minimum absolute difference is: " + minSubsetSumDifference_1(arr, n));

        // TABULATIION
        System.out.println("The minimum absolute difference is: " + minSubsetSumDifference_2(arr, n));

        // SPACE OPTIMIZATION
        System.out.println("The minimum absolute difference is: " + minSubsetSumDifference_3(arr, n));

    }
}
