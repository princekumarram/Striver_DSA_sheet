import java.util.Arrays;
import java.util.HashMap;

public class q9_Find_the_repeating_and_missing_numbers {

    public static int[] getFreq(int arr[]) {
        int n = arr.length;

        boolean visited[] = new boolean[n];

        for (int i = 0; i < n - 1; i++) {

            if (visited[i] == true)
                continue;
            int freq = 1;

            for (int j = i + 1; j < n; j++) {

                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    freq++;
                }

            }
            return new int[] { arr[i], freq };

        }
        return new int[] {};
    }

    public static int getMissing(int arr[]) {
        int n = arr.length + 1;

        int sum = (n * (n + 1)) / 2;

        int s2 = 0;
        for (int i = 0; i < n - 1; i++) {
            s2 += arr[i];
        }
        int mising = sum - s2;

        return mising;
    }

    // METHOD1 - Brute Force Approach
    public static int[] findMissingRepeatingNumbers1(int[] arr) {
        int n = arr.length;

        int mising = -1;
        int repeating = -1;

        for (int i = 1; i <= n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {

                if (arr[j] == i)
                    count++;

            }
            if (count == 2)
                repeating = i;
            else if (count == 0)
                mising = i;

            if (repeating != -1 && mising != -1) {
                break;
            }
        }
        int res[] = { repeating, mising };

        return res;

    }

    // METHOD2 - USING HASHMAP
    public static int[] findMissingRepeatingNumbers2(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> res = new HashMap<>();
    }

    public static void main(String args[]) {
        int arr[] = { 3, 1, 2, 5, 3 };
        // int temp[] = getFreq(arr);
        int temp2 = getMissing(arr);

        // System.out.print(Arrays.toString(temp));
        // System.out.println(temp2);

        int[] nums = { 3, 1, 2, 5, 4, 6, 7, 5 };
        int[] ans = findMissingRepeatingNumbers2(nums);
        System.out.println("The repeating and missing numbers are: {" + ans[0] + " " + ans[1] + "}");
    }

}
