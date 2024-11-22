import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class q12_Chocolate_Distribution_Problem {

    // public static long findMinDiff(ArrayList<Integer> arr, int n, int m) {
    public static int findMinDiff(int[] arr, int n, int m) {

        Arrays.sort(arr);

        int i = 0;
        int j = m - 1;

        int mini = Integer.MAX_VALUE;

        while (j < arr.length) {
            int diff = arr[j] - arr[i];
            mini = Math.min(mini, diff);

            i++;
            j++;
        }

        return mini;
    }

    public static void main(String[] args) {

        /*
         * ArrayList<Integer> arr = new ArrayList<>();
         * 
         * arr.add(3);
         * arr.add(4);
         * arr.add(1);
         * arr.add(9);
         * arr.add(56);
         * arr.add(7);
         * arr.add(9);
         * arr.add(12);
         * 
         * 
         * // long n = 8;// size of array
         * // long m = 5;// chocolate
         * 
         * 
         */

        int arr[] = { 3, 4, 1, 9, 56, 7, 9, 12 };
        int n = 8;
        int m = 5;
        int ans = findMinDiff(arr, n, m);

        System.out.println(ans);

    }

}
