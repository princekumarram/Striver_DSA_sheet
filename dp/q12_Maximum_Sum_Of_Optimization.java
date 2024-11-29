import java.lang.reflect.Array;
import java.util.*;

public class q12_Maximum_Sum_Of_Optimization {

    // MEMOIZATION METHOD
    public static int solveUtil1(int ind, int arr[], int dp[]) {

        if (ind < 0)
            return 0;

        if (ind == 0)
            return arr[ind];

        if (dp[ind] != -1)
            return dp[ind];

        int pick = arr[ind] + solveUtil1(ind - 2, arr, dp);
        int notPick = solveUtil1(ind - 1, arr, dp);

        return dp[ind] = Math.max(pick, notPick);

    }

    public static int solve1(int n, int arr[]) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        return solveUtil1(n - 1, arr, dp);
    }

    // -----------------------------------------------------------------------------------
    // TABULTION

    public static int solve2Util(int n, int arr[], int dp[]) {
        dp[0] = 0;
    }

    public static int solve2(int n, int arr[]) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        return solve2Util(n, arr, dp);

    }

    public static void main(String args[]) {
        // Input array with elements.
        int arr[] = { 2, 1, 4, 9 };

        // Get the length of the array.
        int n = arr.length;

        // Call the solve function to find the maximum possible sum.

        // int result = solve1(n, arr);//memoization
        int result = solve2(n, arr); // tabulation

        // Print the result.
        System.out.println(result);
    }
}
