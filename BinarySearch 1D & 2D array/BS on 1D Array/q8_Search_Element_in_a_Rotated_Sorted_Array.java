import java.util.ArrayList;
import java.util.Arrays;

public class q8_Search_Element_in_a_Rotated_Sorted_Array {

    // BruteForce
    static int search1(ArrayList<Integer> arr, int n, int k) {

        for (int i = 0; i < n; i++) {
            if (arr.get(i) == k) {
                return i;
            }

        }
        return -1;
    }

    // by using binary Search
    static int search2(ArrayList<Integer> arr, int n, int k) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr.get(mid) == k) {
                return mid;

            }

            if (arr.get(start) <= arr.get(mid)) {

                if (arr.get(start) <= k && k <= arr.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            else {
                if (arr.get(mid) <= k && k <= arr.get(end)) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7, 8, 9, 1, 2, 3, 4, 5, 6));
        int n = 9, k = 1;
        int ans = search2(arr, n, k);
        if (ans == -1)
            System.out.println("Target is not present.");
        else
            System.out.println("The index is: " + ans);
    }

}
