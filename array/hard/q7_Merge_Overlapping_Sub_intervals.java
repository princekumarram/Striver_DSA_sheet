import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class q7_Merge_Overlapping_Sub_intervals {

    /*
     * // METHOD-1
     * public static List<List<Integer>> mergeOverlappingIntervals1(int[][] arr) {
     * int n = arr.length;
     * 
     * Arrays.sort(arr, new Comparator<int[]>() {
     * public int compare(int[] a, int[] b) {
     * return a[0] - b[0];
     * }
     * });
     * 
     * List<List<Integer>> ans = new ArrayList<>();
     * 
     * for (int i = 0; i < n; i++) {
     * int start = arr[i][0];
     * int end = arr[i][1];
     * 
     * // Check if the current interval overlaps with the last added interval
     * if (!ans.isEmpty() && start <= ans.get(ans.size() - 1).get(1)) {
     * // Merge the intervals
     * end = Math.max(end, ans.get(ans.size() - 1).get(1));
     * start = ans.get(ans.size() - 1).get(0);
     * ans.remove(ans.size() - 1); // Remove the last interval
     * }
     * 
     * // Check the rest of the intervals:
     * for (int j = i + 1; j < n; j++) {
     * if (arr[j][0] <= end) {
     * end = Math.max(end, arr[j][1]);
     * } else {
     * break;
     * }
     * }
     * ans.add(Arrays.asList(start, end));
     * }
     * return ans;
     * }
     * 
     * public static List<List<Integer>> mergeOverlappingIntervals2(int[][] arr) {
     * int n = arr.length;
     * // sort the given intervals
     * 
     * Arrays.sort(arr, new Comparator<int[]>() {
     * public int compare(int[] a, int[] b) {
     * return a[0] - b[0];
     * }
     * 
     * });
     * 
     * List<List<Integer>> ans = new ArrayList<>();
     * 
     * for (int i = 0; i < n; i++) {
     * 
     * if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
     * ans.add(Arrays.asList(arr[i][0], arr[i][1]));
     * }
     * 
     * else {
     * ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1),
     * arr[i][1]));
     * }
     * }
     * return ans;
     * }
     * 
     * public static void main(String[] args) {
     * int[][] arr = { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 15, 18 } };
     * List<List<Integer>> ans = mergeOverlappingIntervals2(arr);
     * 
     * System.out.print("The merged Overlapping Intervals are:\n");
     * 
     * for (List<Integer> it : ans) {
     * System.out.print("[" + it.get(0) + "," + it.get(1) + "] ");
     * }
     * System.out.println();
     * }
     * 
     * 
     */

    public static int[][] mergeOverlappingIntervals3(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return new int[0][0];
        }

        // Sort intervals based on the starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> res = new ArrayList<>();
        int[] currentInterval = intervals[0];
        res.add(currentInterval);

        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];

            // If intervals overlap, merge them
            if (currentInterval[1] >= interval[0]) {
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                // Disjoint interval, add it to the result list
                currentInterval = interval;
                res.add(currentInterval);
            }
        }

        // Convert ArrayList to 2D array
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 15, 18 } };
        int[][] mergedIntervals = mergeOverlappingIntervals3(intervals);

        System.out.println("The merged intervals are:");
        for (int[] interval : mergedIntervals) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
    }
}
