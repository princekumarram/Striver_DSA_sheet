import java.util.Arrays;

public class q21_Non_overlapping_Intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int c = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                c++;
            } else {
                end = intervals[i][1];
            }
        }

        return c;
    }

    public static void main(String[] args) {
        q21_Non_overlapping_Intervals s = new q21_Non_overlapping_Intervals();
        int[][] intervals = { { 1, 2 }, { 2, 3 },
                { 3, 4 }, { 1, 3 } };
        System.out.println(s.eraseOverlapIntervals(intervals)); // 1

    }

}
