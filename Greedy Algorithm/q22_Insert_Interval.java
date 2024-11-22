import java.util.*;

public class q22_Insert_Interval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add all intervals that come before the new interval

        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        // Merge intervals that overlap with the new interval

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        result.add(newInterval);

        // Add all intervals that come after the new interval

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert result list back to a 2D array

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        q22_Insert_Interval solution = new q22_Insert_Interval();
        int[][] intervals = { { 1, 3 }, { 6, 9 } };
        int[] newInterval = { 2, 5 };
        int[][] result = solution.insert(intervals, newInterval);

        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }

}
