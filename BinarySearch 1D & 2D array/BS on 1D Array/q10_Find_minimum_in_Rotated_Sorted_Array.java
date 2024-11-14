public class q10_Find_minimum_in_Rotated_Sorted_Array {

    // Brue force
    public static int findMin1(int arr[]) {

        int n = arr.length;
        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= mini) {
                mini = Math.min(mini, i);
            }
        }
        return mini;
    }

    // method 2:
    public static int findMin2(int nums[]) {
        int start = 0;
        int end = nums.length - 1;

        // Initialize mini to a high value (we'll use nums[start] instead)
        int mini = nums[start];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // If the current segment is already sorted, the minimum is at start
            if (nums[start] <= nums[end]) {
                mini = Math.min(mini, nums[start]);
                break;
            }

            // Update minimum based on the mid value
            mini = Math.min(mini, nums[mid]);

            // Decide which part to search
            if (nums[start] <= nums[mid]) {
                // Left part is sorted, search in the right
                start = mid + 1;
            } else {
                // Right part is sorted, search in the left
                end = mid - 1;
            }
        }
        return mini;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };
        int ans = findMin2(arr);
        System.out.println("The minimum element is: " + ans);
    }

}
