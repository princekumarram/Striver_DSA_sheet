import java.util.*;

public class q1_Longest_Common_Subsequence {

    // RECURSIVE
    public static int lcsUtil_1(int ind1, int ind2, String s1, String s2) {
        if (ind1 == 0 || ind2 == 0) {
            return 0;
        }

        // Access characters using charAt with adjusted indices
        if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
            return 1 + lcsUtil_1(ind1 - 1, ind2 - 1, s1, s2);
        } else {
            return Math.max(lcsUtil_1(ind1, ind2 - 1, s1, s2), lcsUtil_1(ind1 - 1, ind2, s1, s2));
        }
    }

    public static int lcs_1(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Call the utility function with the lengths of the strings
        return lcsUtil_1(m, n, s1, s2);
    }

    // --------------------------------------------------------------------------------------
    // MEMOIZATION
    public static int lcsUtil_2(int ind1, int ind2, String s1, String s2, int[][] dp) {
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }

        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + lcsUtil_2(ind1 - 1, ind2 - 1, s1, s2, dp);
        }

        else {
            return dp[ind1][ind2] = Math.max(lcsUtil_2(ind1 - 1, ind2, s1, s2, dp),
                    lcsUtil_2(ind1, ind2 - 1, s1, s2, dp));
        }
    }

    public static int lcs_2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return lcsUtil_2(m - 1, n - 1, s1, s2, dp);

    }

    // -------------------------------------------------------------------------------------------
    // TABULATION

    public static int lcs_3(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 0;
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {

                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                } else {
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }
        }
        return dp[n][m];
    }

    // -------------------------------------------------------------------------------
    // SPACE OPTIMIZATION
    public static int lcs_4(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int prev[] = new int[n + 1];
        int cur[] = new int[m + 1];

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {

                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    cur[ind2] = 1 + prev[ind2 - 1];

                } else {
                    cur[ind2] = Math.max(prev[ind2], cur[ind2 - 1]);
                }
            }
            prev = (int[]) (cur.clone());
        }

        return prev[m];
    }

    public static void main(String args[]) {
        String s1 = "acd";
        String s2 = "ced";

        // Call the lcs function and print the result
        System.out.println("The Length of Longest Common Subsequence is " + lcs_1(s1, s2));// RECURSIVE
        System.out.println("The Length of Longest Common Subsequence is " + lcs_2(s1, s2));// MEMOIZATION
        System.out.println("The Length of Longest Common Subsequence is " + lcs_3(s1, s2));// TABULATION
        System.out.println("The Length of Longest Common Subsequence is " + lcs_4(s1, s2));// SPACE OPTIMIZATION
    }
}