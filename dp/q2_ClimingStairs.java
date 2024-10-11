import java.util.Arrays;

/* 
public class q2_ClimingStairs {

    public static int countWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return countWays(n - 1) + countWays(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;// n=3-> 3 & n=4 -> 5=>8
        System.out.println(countWays(n));
    }

}*/

//memoization

public class q2_ClimingStairs {

    public static int countWays(int n, int ways[]) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ways[n] != -1) {// already calcuted
            return ways[n];
        }
        ways[n] = countWays(n - 1, ways) + countWays(n - 2, ways);
        return ways[n];
    }

    // by tabulation

    public static int countWaysTab(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;

        // tabulation loop
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1] + 0;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        int n = 5;// n=3-> 3 & n=4 -> 5=>8
        int ways[] = new int[n + 1];
        Arrays.fill(ways, -1);
        // System.out.println(countWays(n, ways));
        System.out.println(countWaysTab(n));
    }

}
