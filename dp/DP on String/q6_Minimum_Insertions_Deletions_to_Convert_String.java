import java.util.*;

public class q6_Minimum_Insertions_Deletions_to_Convert_String {

    // TABULATION

    // Function to find the length of the Longest Common Subsequence (LCS)
    static int lcs_1(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create a 2D array to store the LCS lengths
        int dp[][] = new int[n + 1][m + 1];

        // Initialize the dp array with -1
        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        // Initialize the first row and first column with 0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        // Fill the dp array using a bottom-up approach
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        return dp[n][m];
    }

    // Function to find the minimum operations required to convert str1 to str2
    static int canYouMake_1(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // Find the length of the LCS between str1 and str2
        int k = lcs_1(str1, str2);

        // The minimum operations required is the sum of the lengths of str1 and str2
        // minus twice the length of LCS
        return (n - k) + (m - k);
    }

    // --------------------------------------------------------------------

    // SPACE OPTIMIZATION
    static int lcs_2(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create two arrays to store the LCS lengths
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        // Base Case: Initialized to 0, as no characters matched yet.

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    cur[ind2] = 1 + prev[ind2 - 1];
                else
                    cur[ind2] = Math.max(prev[ind2], cur[ind2 - 1]);
            }

            // Update prev array to store the current values
            prev = cur.clone();
        }

        return prev[m];
    }

    // Function to find the minimum operations required to convert str1 to str2
    static int canYouMake_2(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        // Find the length of the LCS between str1 and str2
        int k = lcs_2(str1, str2);

        // The minimum operations required is the sum of the lengths of str1 and str2
        // minus twice the length of LCS
        return (n - k) + (m - k);
    }

    public static void main(String args[]) {
        String str1 = "abcd";
        String str2 = "anc";
        System.out.println("The Minimum operations required to convert str1 to str2: " + canYouMake_1(str1, str2));// TABULATION

        System.out.println("The Minimum operations required to convert str1 to str2: " + canYouMake_2(str1, str2));// SPACE
                                                                                                                   // OPTIMIZATION

    }
}
