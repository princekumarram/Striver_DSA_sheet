import java.util.*;

public class q6_Count_Partitions_with_Given_Difference {

    static int mod = (int) (Math.pow(10, 9) + 7);

    // MEMOIZATIION

    static int countPartitionsUtil_1(int ind, int target, int[] arr, int[][] dp) {

        if (ind == 0) {
            if (target == 0 && arr[0] == 0)
                return 2;
            if (target == 0 || target == arr[0])
                return 1;
            return 0;
        }

        if (dp[ind][target] != -1)
            return dp[ind][target];

        int notTaken = countPartitionsUtil_1(ind - 1, target, arr, dp);

        int taken = 0;
        if (arr[ind] <= target)
            taken = countPartitionsUtil_1(ind - 1, target - arr[ind], arr, dp);

        return dp[ind][target] = (notTaken + taken) % mod;
    }

    static int countPartitions_1(int d, int[] arr) {
        int n = arr.length;
        int totSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totSum += arr[i];
        }

        // Checking for edge cases
        if (totSum - d < 0)
            return 0;
        if ((totSum - d) % 2 == 1)
            return 0;

        int s2 = (totSum - d) / 2;

        int dp[][] = new int[n][s2 + 1];

        for (int row[] : dp)
            Arrays.fill(row, -1);

        return countPartitionsUtil_1(n - 1, s2, arr, dp);
    }

    // ---------------------------------------------------------------------------
    // TABULATION

    public static int countPartitionsFindways_2(int arr[], int tar) {
        int n = arr.length;

        int dp[][] = new int[n][tar + 1];

        if (arr[0] == 0)
            dp[0][0] = 2;

        else
            dp[0][0] = 1;

        if (arr[0] != 0 && arr[0] <= tar)
            dp[0][arr[0]] = 1;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= tar; target++) {

                int notTaken = dp[ind - 1][target];

                int taken = 0;

                if (arr[ind] <= target) {

                    taken = dp[ind - 1][target - arr[ind]];
                }

                dp[ind][target] = (taken + notTaken) % mod;
            }
        }
        return dp[n - 1][tar];

    }

    public static int countPartitions_2(int d, int arr[]) {
        int n = arr.length;

        int totSum = 0;

        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        if ((totSum - d) < 0 || (totSum - d) % 2 == 1)
            return 0;

        return countPartitionsFindways_2(arr, (totSum - d) / 2);
    }

    // ---------------------------------------------------------------------------
    // SPACE OPTIMIZATION

    public static int countPartitionsFindways_3(int arr[], int tar) {
        int n = arr.length;
        int prev[] = new int[tar + 1];

        if (arr[0] == 0)
            prev[0] = 2;
        else
            prev[0] = 1;

        if (arr[0] != 0 && arr[0] <= tar)
            prev[arr[0]] = 1;

        for (int ind = 1; ind < n; ind++) {
            int curr[] = new int[tar + 1];
            for (int target = 0; target <= tar; target++) {
                int notTaken = prev[target];

                int taken = 0;

                if (arr[ind] <= target) {
                    taken = prev[target - arr[ind]];

                }
                curr[target] = (taken + notTaken) % mod;

            }
            prev = curr;
        }
        return prev[tar];
    }

    public static int countPartitions_3(int d, int arr[]) {
        int n = arr.length;
        int totSum = 0;

        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        if ((totSum - d) == 0 || (totSum - d) % 2 == 1)
            return 0;

        return countPartitionsFindways_3(arr, (totSum - d) / 2);
    }

    public static void main(String args[]) {

        int arr[] = { 5, 2, 6, 4 };
        int d = 3;

        // MEMOIZATION
        System.out.println("The number of subsets found are " + countPartitions_1(d, arr));

        // TABULATION
        System.out.println("The number of subsets found are " + countPartitions_2(d, arr));

        // SPACE OPTIMIZATION
        System.out.println("The number of subsets found are " + countPartitions_3(d, arr));
    }
}