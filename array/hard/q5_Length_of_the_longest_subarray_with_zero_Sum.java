import java.util.*;

public class q5_Length_of_the_longest_subarray_with_zero_Sum {

    // approach 1: two pointer appraoch
    public static int solve1(int a[]) {
        int n = a.length;
        int maxi = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += a[j];

                if (sum == 0) {
                    maxi = Math.max(maxi, j - i + 1);
                }
            }
        }
        return maxi;

    }

    // approach 2:by using hashmap
    public static int solve2(int a[]) {
        int n = a.length;
        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();

        int maxi = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {

            sum += a[i];

            if (sum == 0) {
                maxi = i + 1;
            } else {
                if (mpp.get(sum) != null) {
                    maxi = Math.max(maxi, i - mpp.get(sum));
                } else {
                    mpp.put(sum, i);
                }
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        int a[] = { 9, -3, 3, -1, 6, -5 };
        System.out.println(solve2(a));
    }

}
