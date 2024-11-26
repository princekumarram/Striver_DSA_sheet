import java.util.*;

public class q7_Longest_Common_Subsequence {

    // Method 1~ Using Recursion
    public static int LCS1(String s1, String s2, int m, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }

        // if string is same
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + LCS1(s1, s2, m - 1, n - 1);
        }

        // if string is diff
        else {
            int ans1 = LCS1(s1, s2, m - 1, n);
            int ans2 = LCS1(s1, s2, m, n - 1);

            return Math.max(ans1, ans2);

        }
    }

    // Method 2~ Memoization

    public static int LCS2(String s1, String s2, int m, int n, int dp[][]) {

        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {// same
            return dp[m][n] = LCS2(s1, s2, m - 1, n - 1, dp) + 1;
        } else {
            int ans1 = LCS2(s1, s2, m - 1, n, dp);
            int ans2 = LCS2(s1, s2, m, n - 1, dp);
            return dp[m][n] = Math.max(ans1, ans2);
        }

    }

    public static int lcsTab(String s1, String s2, int m, int n) {

        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];

                    dp[i][j] = Math.max(ans1, ans2);
                }

            }
        }

        return dp[m][n];
    }

    public static void main(String args[]) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        // String s1 = "ABCDE";
        // String s2 = "ACE";
        int m = s1.length();
        int n = s2.length();

        // System.out.println(LCS1(s1, s2, m, n));

        // memoization

        /*
         * int dp[][] = new int[m + 1][n + 1];
         * 
         * for (int i = 0; i < m + 1; i++) {
         * for (int j = 0; j < n + 1; j++) {
         * dp[i][j] = -1;
         * }
         * }
         * System.out.println(LCS2(s1, s2, m, n, dp));
         * 
         */

        System.out.println(lcsTab(s1, s2, m, n));
    }

}
