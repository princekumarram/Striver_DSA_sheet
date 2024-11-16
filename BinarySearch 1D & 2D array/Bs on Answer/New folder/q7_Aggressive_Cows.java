import java.util.*;

public class q7_Aggressive_Cows {

    // Brute it
    /*
     * public static boolean canWePlace(int[] stalls, int dist, int cows) {
     * int n = stalls.length; // size of array
     * int cntCows = 1; // no. of cows placed
     * int last = stalls[0]; // position of last placed cow.
     * for (int i = 1; i < n; i++) {
     * if (stalls[i] - last >= dist) {
     * cntCows++; // place next cow.
     * last = stalls[i]; // update the last location.
     * }
     * if (cntCows >= cows)
     * return true;
     * }
     * return false;
     * }
     * 
     * public static int aggressiveCows(int[] stalls, int k) {
     * int n = stalls.length; // size of array
     * // sort the stalls[]:
     * Arrays.sort(stalls);
     * 
     * int limit = stalls[n - 1] - stalls[0];
     * for (int i = 1; i <= limit; i++) {
     * if (canWePlace(stalls, i, k) == false) {
     * return (i - 1);
     * }
     * }
     * return limit;
     * }
     * 
     * public static void main(String[] args) {
     * int[] stalls = { 0, 3, 4, 7, 10, 9 };
     * int k = 4;
     * int ans = aggressiveCows(stalls, k);
     * System.out.println("The maximum possible minimum distance is: " + ans);
     * }
     */

    public static boolean canWePlace(int[] stalls, int dist, int cows) {
        int n = stalls.length;
        int cntCows = 1;
        int last = stalls[0];

        for (int i = 1; i < n; i++) {
            if (stalls[i] - last >= dist) {
                cntCows++;
                last = stalls[i];

            }
            if (cntCows >= cows)
                return true;
        }
        return false;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);

        int low = 1, high = stalls[n - 1] - stalls[0];
        // apply brute force

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(stalls, mid, k) == true) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[] stalls = { 0, 3, 4, 7, 10, 9 };
        int k = 4;
        int ans = aggressiveCows(stalls, k);
        System.out.println("The maximum possible minimum distance is: " + ans);
    }
}
