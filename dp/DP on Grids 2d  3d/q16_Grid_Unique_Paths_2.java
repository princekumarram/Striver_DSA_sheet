import java.util.*;

public class q16_Grid_Unique_Paths_2 {

    // Memoization

    // Helper function to calculate the number of paths through the maze
    static int mazeObastaclesUtils_1(int i, int j, int[][] maze, int[][] dp) {
        // If there's an obstacle at this cell or out of bounds, return 0
        if (i >= 0 && j >= 0 && maze[i][j] == -1)
            return 0;
        // If we've reached the start cell, there's one valid path
        if (i == 0 && j == 0)
            return 1;
        // If we're out of bounds, return 0
        if (i < 0 || j < 0)
            return 0;
        // If we've already calculated this cell, return the stored result
        if (dp[i][j] != -1)
            return dp[i][j];

        // Calculate the number of paths by moving up and left
        int up = mazeObastaclesUtils_1(i - 1, j, maze, dp);
        int left = mazeObastaclesUtils_1(i, j - 1, maze, dp);

        // Store the result and return it
        return dp[i][j] = up + left;
    }

    public static int mazeObastacles1(int n, int m, int[][] maze) {
        int dp[][] = new int[n][m];

        for (int row[] : dp)
            Arrays.fill(row, -1);

        return mazeObastaclesUtils_1(n - 1, m - 1, maze, dp);
    }

    // ----------------------------------------------------------------------------
    // Tabulation metod

    public static int mazeObastaclesUtils_2(int n, int m, int maze[][], int dp[][]) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // Base conditions
                if (i > 0 && j > 0 && maze[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                if (i > 0)
                    up = dp[i - 1][j];

                if (j > 0)
                    left = dp[i][j - 1];

                dp[i][j] = up + left;
            }
        }
        return dp[n - 1][m - 1];
    }

    public static int mazeObastacles2(int n, int m, int[][] maze) {

        int dp[][] = new int[n][m];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return mazeObastaclesUtils_2(n, m, maze, dp);
    }

    // ------------------------------------------------------------------------------------------------------------
    // Space Optimization

    public static int mazeObastacles3(int n, int m, int[][] maze) {
        int prev[] = new int[n];

        for (int i = 0; i < n; i++) {
            int temp[] = new int[m];

            for (int j = 0; j < m; j++) {

                // Base conditions
                if (i > 0 && j > 0 && maze[i][j] == -1) {
                    temp[j] = 0;
                    continue;
                }

                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                // check if moving up is possible

                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = temp[j - 1];

                temp[j] = up + left;

            }
            prev = temp;
        }

        return prev[n - 1];

    }

    public static void main(String[] args) {
        int maze[][] = {
                { 0, 0, 0 },
                { 0, -1, 0 },
                { 0, 0, 0 }
        };

        int n = maze.length;
        int m = maze[0].length;

        System.out.println(mazeObastacles1(n, m, maze));// memoization
        System.out.println(mazeObastacles2(n, m, maze));// Tabulization
        System.out.println(mazeObastacles3(n, m, maze));// Space Optimization
    }

}
