import java.util.*;

public class q19_Minimum_or_Maximum_Falling_Path_Sum {

    // MEMOIZATION
    public static int getMaxPathSum_1(int n, int matrix[][]) {

        int dp[][] = new int[n][n];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        int maxi = Integer.MIN_VALUE;

    }

    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 10, 4 },
                { 100, 3, 2, 1 },
                { 1, 1, 20, 2 },
                { 1, 2, 2, 1 } };

        int n = matrix.length;

        System.out.println(getMaxPathSum_1(n, matrix));// MEMOIZATION
    }

}
