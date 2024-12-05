
// Count Partitions with Given Difference

// This article will be divided into two parts:

// First, we will discuss an extra edge case of the problem discussed in Count Subsets with Sum K, and then,
// we will discuss the problem for this article: Partitions with Given Difference.

//Let the target arr = [0,0,1] and the target = 1

import java.util.*;

public class q5_Count_Subsets_part_2 {

    static int findWaysUtil(int ind, int target, int[] arr, int[][] dp) {
        if (ind == 0) {
            if (target == 0 && arr[0] == 0)
                return 2;
            if (target == 0 || target == arr[0])
                return 1;
            return 0;
        }

        if (dp[ind][target] != -1)
            return dp[ind][target];

        int notTaken = findWaysUtil(ind - 1, target, arr, dp);

        int taken = 0;
        if (arr[ind] <= target)
            taken = findWaysUtil(ind - 1, target - arr[ind], arr, dp);

        return dp[ind][target] = notTaken + taken;
    }

    static int findWays(int[] num, int k) {
        int n = num.length;
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return findWaysUtil(n - 1, k, num, dp);
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 1 };
        int k = 1;

        System.out.println("The number of subsets found are " + findWays(arr, k));
    }
}
