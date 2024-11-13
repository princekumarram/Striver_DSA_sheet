
public class q1_Binary_Search {

    // method: 1 Iterative Implementation
    public static int binarySearch1(int arr[], int target) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        // Perform the steps:
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else
                end = mid - 1;

        }
        return -1;
    }

    // method: 2 -> Recursive method
    public static int binarySearch2(int arr[], int target) {

        return ans(arr, 0, arr.length - 1, target);
    }

    public static int ans(int arr[], int start, int end, int target) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (target == arr[mid]) {
            return mid;
        } else if (target > arr[mid]) {
            return ans(arr, mid + 1, end, target);
        } else {
            return ans(arr, start, mid - 1, target);
        }

    }

    public static void main(String args[]) {
        int[] a = { 3, 4, 6, 7, 9, 12, 16, 17 };
        int target = 6;
        int ind = binarySearch2(a, target);

        if (ind == -1) {
            System.out.println("The target is not present.");
        } else {
            System.out.println("The target is at index: " + ind);
        }
    }

}
