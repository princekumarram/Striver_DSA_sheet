
public class q2_Print_Longest_Common_Subsequence {

    public static void longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {

                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2];
                }

                else {
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }
        }

        int len = dp[n][m];
        int i = n, j = m;
        ;
        int index = len - 1;

        String str = "";
        for (int k = 1; k <= len; k++) {
            str += "$";
        }

        StringBuilder ss1 = new StringBuilder(s1);
        StringBuilder ss2 = new StringBuilder(str);

        while (i > 0 && j > 0) {
            if (ss1.charAt(i - 1) == s2.charAt(j - 1)) {
                ss2.setCharAt(index, ss1.charAt(i - 1));
                index--;
                i--;
                j--;
            } else if (ss1.charAt(i - 1) > s2.charAt(j - 1)) {
                i--;
            } else {
                j--;
            }

        }
        System.out.println(ss2);
    }

    public static void main(String[] args) {

        String s1 = "abcde";
        String s2 = "bdgek";

        System.out.println(" the longest common subsequence");
        longestCommonSubsequence(s1, s2);
    }
}
