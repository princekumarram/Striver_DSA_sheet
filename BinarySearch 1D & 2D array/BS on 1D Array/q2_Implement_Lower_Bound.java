public class q2_Implement_Lower_Bound {

    // method 1;
    public static int lowerBound1(int arr[], int n, int x) {

        for (int i = 0; i < n; i++) {
            if (arr[i] >= x) {
                return i;
            }
        }
        return -1;
    }

    // method 2

    public static int lowerBound2(int arr[], int n, int x) {

        int ans = -1;

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == x) {
                return mid; // Exact match, so it’s the floor
            } else if (arr[mid] < x) {
                // Potential floor, update ans and search right
                ans = mid;
                start = mid + 1;
            } else {
                // arr[mid] > k, search left
                end = mid - 1;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 8, 15, 19 };
        int n = 5, x = 9;
        int ind = lowerBound1(arr, n, x);
        System.out.println("The lower bound is the index: " + ind);
    }
}
