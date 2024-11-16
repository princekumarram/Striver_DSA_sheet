import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class q8_Allocate_Minimum_Number_of_Pages {

    public static int countStudents(ArrayList<Integer> arr, int pages) {
        int n = arr.size();
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudent + arr.get(i) <= pages) {
                pagesStudent += arr.get(i);
            } else {
                students++;
                pagesStudent = arr.get(i);
            }
        }
        return students;
    }

    // method 1: BruteForce
    public static int findPages1(ArrayList<Integer> arr, int n, int m) {
        // book allocation imposible
        if (m > n)
            return -1;

        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();

        for (int pages = low; pages <= high; pages++) {
            if (countStudents(arr, pages) == m) {
                return pages;
            }
        }
        return low;
    }

    // method 2: Binary Search
    public static int findPages2(ArrayList<Integer> arr, int n, int m) {
        // book allocation imposible
        if (m > n)
            return -1;

        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();

        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(arr, mid);
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String args[]) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        int n = 5;
        int m = 4;
        int ans = findPages2(arr, n, m);
        System.out.println("The answer is: " + ans);
    }

}
