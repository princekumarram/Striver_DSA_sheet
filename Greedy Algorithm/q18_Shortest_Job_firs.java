import java.util.*;

public class q18_Shortest_Job_firs {

    public static float shortestJobFirst(int[] jobs) {

        Arrays.sort(jobs);

        float waitTime = 0;
        int totalTime = 0;
        int n = jobs.length;

        for (int i = 0; i < n; i++) {
            waitTime += totalTime;
            totalTime += jobs[i];
        }
        return waitTime / n;
    }

    public static void main(String[] args) {
        int[] jobs = { 4, 3, 7, 1, 2 };

        System.out.print("Array Representing Job Durations: ");
        for (int i = 0; i < jobs.length; i++) {
            System.out.print(jobs[i] + " ");
        }
        System.out.println();

        float ans = shortestJobFirst(jobs);
        System.out.println("Average waiting time: " + ans);
    }

}
