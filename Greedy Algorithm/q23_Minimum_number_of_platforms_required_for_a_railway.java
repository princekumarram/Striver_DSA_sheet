import java.util.*;

public class q23_Minimum_number_of_platforms_required_for_a_railway {

    // Method 1: Brute Force
    static int countPlatforms1(int n, int arr[], int dep[]) {

        int ans = 1;// final value;

        for (int i = 0; i < n; i++) {

            int count = 1;
            for (int j = i + 1; j < n; j++) {

                if ((arr[i] >= arr[j] && arr[i] <= dep[j]) || (arr[j] >= arr[i] && arr[j] <= dep[i])) {
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    // Method 2: Optimize method
    static int countPlatforms2(int n, int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int plar_needed = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {

            if (arr[i] <= dep[j]) {
                plar_needed++;
                i++;
            } else if (arr[i] > dep[j]) {
                plar_needed--;
                j++;
            }

            if (plar_needed > result)
                result = plar_needed;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = { 900, 945, 955, 1100, 1500, 1800 };
        int[] dep = { 920, 1200, 1130, 1150, 1900, 2000 };
        int n = arr.length;
        int totalCount = countPlatforms2(n, arr, dep);
        System.out.println("Minimum number of Platforms required " + totalCount);
    }

}
