import java.util.*;

public class q9_Edit_Distance {

    // RECURSIVE SOLUTION
    public static int editDistaceUtil_1(int i, int j, String s1, String s2) {

        if (i < 0)
            return j + 1;

        if (j < 0)
            return i + 1;

        if (s1.charAt(i) == s2.charAt(j))
            return editDistaceUtil_1(i - 1, j - 1, s1, s2);

        else
            return 1 + Math.min(editDistaceUtil_1(i - 1, j - 1, s1, s2),
                    Math.min(editDistaceUtil_1(i - 1, j, s1, s2), editDistaceUtil_1(i, j - 1, s1, s2)));
    }

    public static int editDistance_1(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        return editDistaceUtil_1(n - 1, m - 1, s1, s2);
    }

    // MEMOIZATION SOLUTION
    public static int editDistaceUtil_2(int i, int j, String s1, String s2, int[][] dp) {

        if (i < 0)
            return j + 1;

        if (j < 0)
            return i + 1;

        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = editDistaceUtil_2(i - 1, j - 1, s1, s2, dp);

        else
            return dp[i][j] = 1 + Math.min(editDistaceUtil_2(i - 1, j - 1, s1, s2, dp),
                    Math.min(editDistaceUtil_2(i - 1, j, s1, s2, dp), editDistaceUtil_2(i, j - 1, s1, s2, dp)));
    }

    public static int editDistance_2(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n][m];

        for (int row[] : dp)
            Arrays.fill(row, -1);

        return editDistaceUtil_2(n - 1, m - 1, s1, s2, dp);
    }

    // TABULATION
    public static int editDistance_3(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Base Case
        if (n == 0)
            return m;
        if (m == 0)
            return n;

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[n][m];
    }

    // SPACE OPIMIZATION
    public static int editDistance_4(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        // Initialize the base case for the first row
        for (int j = 0; j <= m; j++) { // Change to m
            prev[j] = j;
        }

        for (int i = 1; i <= n; i++) {
            cur[0] = i; // Initialize the base case for the first column
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    cur[j] = prev[j - 1]; // Characters match
                } else {
                    cur[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], cur[j - 1])); // Edit distance formula
                }
            }
            prev = cur.clone(); // Copy current row to previous row
        }
        return prev[m]; // Result is in the last cell of the last row
    }

    public static void main(String args[]) {
        String s1 = "horse";
        String s2 = "ros";

        // ans=3

        // RECURSIVE SOLUTION
        System.out.println("The minimum number of operations required is: " +
                editDistance_1(s1, s2));

        // MEMOIZATION SOLUTION
        System.out.println("The minimum number of operations required is: " +
                editDistance_2(s1, s2));

        // Tabulation SOLUTION
        System.out.println("The minimum number of operations required is: " +
                editDistance_3(s1, s2));

        // SPACE OPTIMIZATION SOLUTION
        System.out.println("The minimum number of operations required is: " +
                editDistance_4(s1, s2));
    }

}
