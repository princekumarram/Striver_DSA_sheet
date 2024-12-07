import java.util.*;

public class q10_Wildcard_Matching {

    // RECURSION
    public static boolean wildcardMatchingUtil_1(int i, int j, String s1, String s2) {
        // Base cases
        if (i < 0 && j < 0)
            return true; // Both string and pattern are exhausted
        if (j < 0)
            return false; // Pattern exhausted but string remains
        if (i < 0) { // String exhausted
            for (int jj = 0; jj <= j; jj++) {
                if (s2.charAt(jj) != '*')
                    return false; // If any character is not '*', return false
            }
            return true; // All characters in pattern are '*'
        }

        // If characters match or pattern has '?'
        if (s1.charAt(i) == s2.charAt(j) || s2.charAt(j) == '?') {
            return wildcardMatchingUtil_1(i - 1, j - 1, s1, s2);
        }

        // If pattern has '*', match zero or more characters
        if (s2.charAt(j) == '*') {
            // Try to match '*' with no characters (j-1) or one character (i-1)
            return wildcardMatchingUtil_1(i, j - 1, s1, s2) || wildcardMatchingUtil_1(i - 1, j, s1, s2);
        }

        // Characters don't match
        return false;
    }

    public static boolean wildcardMatching_1(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        return wildcardMatchingUtil_1(n - 1, m - 1, s1, s2);
    }

    // -----------------------------------------------------------------------------------------
    // MEMOIZATION

    public static int wildcardMatchingUtil_2(String s1, String s2, int i, int j, int dp[][]) {

        // Base Case
        if (i < 0 && j < 0)
            return 1;
        if (i < 0 && j >= 0)
            return 0;

        if (j < 0 && i >= 0)
            return isAllStars(s1, i) ? 1 : 0;

        if (dp[i][j] != -1)
            return dp[i][j];

            if(s1)
    }

    public static boolean wildcardMatching_2(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n][m];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        return wildcardMatchingUtil_2(n, m, s1, s2, dp);
    }

    public static void main(String args[]) {
        String S1 = "ab*cd"; // Pattern with wildcard
        String S2 = "abdefcd"; // String to match against the pattern

        // Corrected the order of parameters
        if (wildcardMatching_1(S1, S2)) // Now S1 is the pattern and S2 is the string
            System.out.println("String S1 and S2 do match");
        else
            System.out.println("String S1 and S2 do not match");
    }
}