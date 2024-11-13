public class q6_Last_occurrence_in_a_sorted_array {

    // method -1 TC--O(N)

    public static int lastOccurence1(int[] arr, int target) {
        int n = arr.length;
        int result = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == target)
                result = i;
            break;
        }
        return result;
    }

    // method 2 TC- O(log(N))

    public static int lastOccurence2(int[] arr, int target) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int ans = -1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                ans = mid;
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;

            } else {
                start = mid + 1;
            }

        }
        return ans;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 3, 3, 5, 5, 2, 5, 2, 1, 2, 3 };
        int target = 3;

        int ans = lastOccurence2(arr, target);
        System.out.println("The last occurence index is " + ans);
    }

}
