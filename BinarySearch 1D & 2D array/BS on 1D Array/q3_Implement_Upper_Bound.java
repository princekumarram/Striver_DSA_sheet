
public class q3_Implement_Upper_Bound {

    // method -1
    public static int upperBound1(int[] arr, int x, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] > x) {
                // upper bound found:
                return i;
            }
        }
        return n;
    }

    // method -2 using binary Search;
    public static int upperBound2(int[] arr, int x, int n) {

        int start = 0;
        int end = n - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > x) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 8, 9, 15, 19 };
        int n = 6, x = 10;
        int ind = upperBound2(arr, x, n);
        System.out.println("The upper bound is the index: " + ind);
    }
}
