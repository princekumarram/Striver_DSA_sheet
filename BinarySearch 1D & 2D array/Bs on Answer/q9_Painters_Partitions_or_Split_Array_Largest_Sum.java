public class q9_Painters_Partitions_or_Split_Array_Largest_Sum {

    public static int countPartition(int arr[], int maxSum) {
        int n = arr.length;
        int partitions = 1;
        long subArraySum = 0;
        for (int i = 0; i < n; i++) {
            if (subArraySum + arr[i] <= maxSum) {
                // insert element to current subarray
                subArraySum += arr[i];
            } else {
                // insert element to current subbarray
                partitions++;
                subArraySum = arr[i];
            }
        }
        return partitions;
    }

    // method 1 : Brute Force
    public static int LargestSubarraySumMinimized1(int[] arr, int k) {
        int n = arr.length;
        int low = arr[0];
        int high = 0;
        // find maximum an summation
        for (int i = 0; i < n; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }

        for (int maxSum = low; maxSum <= high; maxSum++) {
            if (countPartition(arr, maxSum) == k)
                return maxSum;
        }
        return low;
    }

    // method 2: BinarySearch

    public static int LargestSubarraySumMinimized2(int arr[], int k) {
        int n = arr.length;
        int low = arr[0];
        int high = 0;
        // find maximum an summation
        for (int i = 0; i < n; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }

        // apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            int partition = countPartition(arr, mid);

            if (partition > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String args[]) {
        int arr[] = { 10, 20, 30, 40 };
        int k = 2;
        int ans = LargestSubarraySumMinimized2(arr, k);
        System.out.println("The answer is:" + ans);
    }
}
