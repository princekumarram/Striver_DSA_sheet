import java.util.*;

public class q2_Partition_Equal_Subset_Sum {

    // MEMOIZATION

    public static boolean subsetSumUtil_1(int ind, int target, int arr[], int dp[][]) {
        // If the target sum is 0,we have found a valid subset

        if (target == 0)
            return true;

        // If we have processed all elements in the array
        if (ind == 0)
            return arr[0] == target;

        // If this subproblem has already been solved,return the result
        if (dp[ind][target] != -1)
            return dp[ind][target] == 0 ? false : true;

        // Try not taking the current elements into the subset
        boolean notTaken = subsetSumUtil_1(ind - 1, target, arr, dp);

        // Try taking the current element into the subset
        boolean taken = false;
        if (arr[ind] <= target)
            taken = subsetSumUtil_1(ind - 1, target - arr[ind], arr, dp);

        // Memoize the result and return true if either choice results in valid subset
        dp[ind][target] = notTaken || taken ? 1 : 0;

        return notTaken || taken;
    }

    public static boolean canPartition_1(int n, int arr[]) {
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum = totSum + arr[i];
        }

        // If the total sum is odd, it cannot be partitioned into equals subsets
        if (totSum % 2 == 1)
            return false;

        else {
            // Calculate the target sum for each subset
            int k = totSum / 2;

            int dp[][] = new int[n][k + 1];
            for (int row[] : dp)
                Arrays.fill(row, -1);

            // call the helper function to check if a valid subset exists

            return subsetSumUtil_1(n - 1, k, arr, dp);
        }
    }

    public static void main(String args[]) {
        int arr[] = { 2, 3, 3, 3, 4, 5 };
        int n = arr.length;

        // Checck if the array can be partitioned into two equals subsets

        if (canPartition_1(n, arr))
            System.out.println("The Array can be partitioned into two equal subssets");

        else
            System.out.println("The Array cannot be partitioned into eqauls subset");
    }

}
