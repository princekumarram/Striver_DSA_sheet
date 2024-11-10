
import java.util.*;

public class q8_Merge_two_Sorted_Arrays_Without_Extra_Space {

    // METHOD:1 -Brute Force Approach
    public static void merge1(long[] arr1, long[] arr2, int n, int m) {

        // Declare a 3rd array and 2 pointer:
        long[] arr3 = new long[n + m];
        int left = 0;
        int right = 0;
        int index = 0;

        // Insert the elements from the 2 arrays
        // into the 3rd array using left and right
        // pointers:

        while (left < n && right < m) {

            if (arr1[left] <= arr2[right]) {
                arr3[index] = arr1[left];
                left++;
                index++;
            } else {
                arr3[index] = arr2[right];
                right++;
                index++;
            }
        }
        // If right pointer reaches the end:
        while (left < n) {
            arr3[index++] = arr1[left++];
        }
        // If left pointer reaches the end:
        while (right < m) {
            arr3[index++] = arr2[right++];
        }

        // Fill back the elements from arr3[]
        // to arr1[] and arr2[]:

        for (int i = 0; i < n + m; i++) {
            if (i < n) {
                arr1[i] = arr3[i];
            } else {
                arr2[i - n] = arr3[i];
            }
        }
    }

    // METHOD:2 -Optimal1
    public static void merge2(long[] arr1, long[] arr2, int n, int m) {

        // Declare 2 pointer
        int left = n - 1;
        int right = 0;

        // Swap the elements until arr1[left]is smaller than arr2[right];

        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }
        // Sort arr1[] and arr2[] individually:
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    // METHOD:3 -Optimal2
    public static void merge3(long[] arr1, long[] arr2, int n, int m) {

        int len = n + m;

        // Initial gap:

        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            // place 2 pointer:
            int left = 0;
            int right = left + gap;
            while (right < len) {
                // case 1: left in arr1[]
                // and right in arr2[]:

                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                // case 2: both pointers in arr2[]:
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                // case 3: both pointers in arr1[]:
                else {
                    swapIfGreater(arr1, arr1, left, right);

                }
                left++;
                right++;

            }
            // break if iteration gap=1 is completed:
            if (gap == 1)
                break;

            // Otherwise, calculate new gap:
            gap = (gap / 2) + (gap % 2);
        }

    }

    public static void swapIfGreater(long[] arr1, long[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            long temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }

    }

    public static void main(String[] args) {
        long[] arr1 = { 1, 4, 8, 10 };
        long[] arr2 = { 2, 3, 9 };
        int n = 4, m = 3;
        merge3(arr1, arr2, n, m);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }

}
