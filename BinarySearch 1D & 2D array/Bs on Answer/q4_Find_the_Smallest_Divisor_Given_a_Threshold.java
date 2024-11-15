public class q4_Find_the_Smallest_Divisor_Given_a_Threshold {

    // method -1

    public static int samllestDivisior(int[] arr, int limit) {
        int n = arr.length;
        // find the maximum element
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        // find the smallest divisor:
        for (int d = 1; d <= maxi; d++) {
            // find the summation result:
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.ceil((double) (arr[i]) / (double) (d));
            }
            if (sum <= limit) {
                return d;
            }

        }
        return -1;
    }

    // __________________________________________________________________________
    // method-2

    public static int sumByD(int arr[], int div) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double) (arr[i]) / (double) (div));

        }
        return sum;
    }

    public static int samllestDivisior1(int[] arr, int limit) {
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        int low = 1, high = maxi;

        // apply binary search:
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sumByD(arr, mid) <= limit) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return low;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int limit = 8;
        int ans = samllestDivisior1(arr, limit);
        System.out.println("The minimum divisor is: " + ans);
    }

}
