import java.util.*;

public class q4_Longest_Palindromic_Subsequence {

    // TABULATION

    public static int LCS_1(String s1, String s2) {

        int n = s2.length();
        int m = s1.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {

                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                }

                else {
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }

            }
        }
        return dp[n][m];
    }

    public static int LPS_1(String s) {

        String reversed = new StringBuilder(s).reverse().toString();

        return LCS_1(s, reversed);

    }

    // SPACE OPTIMIZATION
    public static int LCS_2(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] prev = new int[n + 1];
        int[] cur = new int[n + 1];

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {

                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    cur[ind2] = 1 + prev[ind2 - 1];
                } else {
                    cur[ind2] = Math.max(prev[ind2], cur[ind2 - 1]);
                }

            }
            prev = cur.clone();
        }
        return prev[m];
    }

    public static int LPS_2(String s) {
        String reversed = new StringBuilder(s).reverse().toString();

        return LCS_2(s, reversed);
    }

    public static void main(String[] args) {
        String s = "bbabcbcab";

        System.out.println("longest Palindromic subSequence ");
        System.out.println(LPS_1(s));// TABULATION
        System.out.println(LPS_2(s));// SPACE OPTIMIZATION
    }

}
