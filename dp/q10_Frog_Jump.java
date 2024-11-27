import java.util.*;

public class q10_Frog_Jump {

    public static int solve(int ind, int height[]) {

        if (ind == 0)
            return 0;
        int jumpTwo = Integer.MAX_VALUE;

        int jumpOne = solve(ind - 1, height) + Math.abs(height[ind] - height[ind - 1]);

        if (ind > 1) {
            jumpTwo = solve(ind - 2, height) + Math.abs(height[ind] - height[ind - 2]);
        }

        return Math.min(jumpOne, jumpTwo);
    }

    public static void main(String args[]) {
        int height[] = { 30, 10, 60, 10, 60, 50 };
        int n = height.length;

        System.out.println(solve(n - 1, height));
    }

}
