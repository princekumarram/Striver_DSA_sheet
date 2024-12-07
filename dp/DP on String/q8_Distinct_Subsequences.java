
import java.util.*;

class q8_Distinct_Subsequences {
    static int prime = (int) (Math.pow(10, 9) + 7);

    // Function to count the number of distinct subsequences of s1 that are equal to
    // s2
    static int countUtil_1(String s1, String s2, int ind1, int ind2, int[][] dp) {
        // If we have exhausted s2, there's one valid subsequence (empty string) in s1.
        if (ind2 < 0)
            return 1;
        // If we have exhausted s1 but not s2, there are no valid subsequences.
        if (ind1 < 0)
            return 0;

        // If the result is already computed, return it.
        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];

        // If the characters at the current positions match, we can either leave one
        // character from s1
        // or continue to the next character in s1 while staying at the same character
        // in s2.
        if (s1.charAt(ind1) == s2.charAt(ind2)) {
            int leaveOne = countUtil_1(s1, s2, ind1 - 1, ind2 - 1, dp);
            int stay = countUtil_1(s1, s2, ind1 - 1, ind2, dp);

            // Add the two possibilities and take modulo prime to avoid integer overflow.
            return dp[ind1][ind2] = (leaveOne + stay) % prime;
        } else {
            // If the characters don't match, we can only continue to the next character in
            // s1.
            return dp[ind1][ind2] = countUtil_1(s1, s2, ind1 - 1, ind2, dp);
        }
    }

    // Function to calculate the count of distinct subsequences of s1 equal to s2
    static int subsequenceCounting_1(String s1, String s2, int lt, int ls) {
        // Initialize a DP array to store intermediate results
        int dp[][] = new int[lt][ls];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        // Call the recursive helper function to compute the count
        return countUtil_1(s1, s2, lt - 1, ls - 1, dp);
    }

    // Function to calculate the count of distinct subsequences of s1 equal to s2
    static int subsequenceCounting_2(String s1, String s2, int n, int m) {
        // Create a 2D array to store the counts of subsequences
        int dp[][] = new int[n + 1][m + 1];

        // Initialize the first column with 1 because there's one empty subsequence in
        // any string.
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        // Initialize the first row (except dp[0][0]) with 0 because there's no way to
        // form s2 from an empty string.
        for (int i = 1; i < m + 1; i++) {
            dp[0][i] = 0;
        }

        // Fill the dp array using a bottom-up approach
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // If the characters match, we can either include this character in the
                    // subsequence
                    // or exclude it. So, we add the counts from both possibilities.
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % prime;
                } else {
                    // If the characters don't match, we can only exclude this character.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }

    static int subsequenceCounting_3(String s1, String s2, int n, int m) {

        int[] prev = new int[m + 1];

        prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    prev[j] = prev[j - 1] + prev[j];
                } else {
                    prev[j] = prev[j];
                }
            }
        }
        return prev[m];
    }

    static int subsequenceCounting_4(String s1, String s2, int n, int m) {
        // Create an array to store the counts of subsequences
        int[] prev = new int[m + 1];

        // Initialize the first element to 1 because there's one empty subsequence in
        // any string.
        prev[0] = 1;

        // Fill the prev array using a bottom-up approach
        for (int i = 1; i < n + 1; i++) {
            for (int j = m; j >= 1; j--) { // Reverse direction for updating

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // If the characters match, we can either include this character in the
                    // subsequence
                    // or exclude it. So, we add the counts from both possibilities.
                    prev[j] = (prev[j - 1] + prev[j]) % prime;
                } else {
                    // If the characters don't match, we can only exclude this character.
                    prev[j] = prev[j]; // This statement is not necessary, as it doesn't change the value.
                }
            }
        }

        return prev[m];
    }

    // RECURSIVE
    static int f(int i, int j, String s, String t) {
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;

        if (s.charAt(i) == t.charAt(j)) {
            return f(i - 1, j - 1, s, t) + f(i - 1, j, s, t);
        }

        return f(i - 1, j, s, t);
    }

    public static int subsequenceCounting_5(String s, String s2, int n, int m) {

        return f(n - 1, m - 1, s, s2);// recursion

    }

    public static void main(String args[]) {
        String s1 = "babgbag";
        String s2 = "bag";

        System.out.println("The Count of Distinct Subsequences is " +
                subsequenceCounting_1(s1, s2, s1.length(), s2.length()));

        System.out.println("The Count of Distinct Subsequences is " +
                subsequenceCounting_2(s1, s2, s1.length(), s2.length()));

        System.out.println("The Count of Distinct Subsequences is " +
                subsequenceCounting_3(s1, s2, s1.length(), s2.length()));

        System.out.println("The Count of Distinct Subsequences is " +
                subsequenceCounting_4(s1, s2, s1.length(), s2.length()));

        System.out.println("The Count of Distinct Subsequences is " +
                subsequenceCounting_5(s1, s2, s1.length(), s2.length()));
    }
}
