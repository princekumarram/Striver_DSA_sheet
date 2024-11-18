import java.util.*;
import java.util.ArrayList;

public class q10_Median_of_Two_Sorted_Arrays_of_different_sizes {

    public static double median1(int[] a, int b[]) {
        // Size of two given arrays
        int n1 = a.length;
        int n2 = b.length;

        List<Integer> arr3 = new ArrayList<>();
        // Apply the merge step
        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {

            if (a[i] < b[j]) {
                arr3.add(a[i++]);
            } else {
                arr3.add(b[j++]);
            }
        }

        // Copy the left-out elements
        while (i < n1) {
            arr3.add(a[i++]);
        }
        while (j < n2) {
            arr3.add(b[j++]);
        }

        // Find the median
        int n = n1 + n2;
        if (n % 2 == 1) {
            return (double) arr3.get(n / 2);
        }

        double median = ((double) arr3.get(n / 2) + (double) arr3.get((n / 2) - 1) / 2);

        return median;

    }

    public static double median2(int[] a, int b[]) {
        int n1 = a.length;
        int n2 = b.length;

        int n = n1 + n2;

        int ind2 = n / 2;
        int ind1 = ind2 - 1;
        int cnt = 0;
        int ind1el = -1, ind2el = -1;

        // apply the merge step:
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                if (cnt == ind1)
                    ind1el = a[i];
                if (cnt == ind2)
                    ind2el = a[i];
                cnt++;
                i++;
            } else {
                if (cnt == ind1)
                    ind1el = b[j];
                if (cnt == ind2)
                    ind2el = b[j];
                cnt++;
                j++;
            }
        }

        // copy the left-out elements:
        while (i < n1) {
            if (cnt == ind1)
                ind1el = a[i];
            if (cnt == ind2)
                ind2el = a[i];
            cnt++;
            i++;
        }
        while (j < n2) {
            if (cnt == ind1)
                ind1el = b[j];
            if (cnt == ind2)
                ind2el = b[j];
            cnt++;
            j++;
        }

        // Find the median
        if (n % 2 == 1) {
            return (double) ind2el;
        }

        return (double) ((double) (ind1el + ind2el)) / 2.0;
    }

    public static void main(String args[]) {
        int a[] = { 1, 4, 7, 10, 12 };
        int b[] = { 2, 3, 6, 15 };
        // System.out.println("The median of two sorted arrays is : " + median1(a, b));
        System.out.println("The median of two sorted arrays is : " + median2(a, b));
    }

}
