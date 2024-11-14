public class q11_Find_out_how_many_times_the_array_has_been_rotated {

    // Brute forcee
    public static int findKRotation1(int arr[]) {
        int n = arr.length;
        int mini = Integer.MAX_VALUE;
        int ans = -1;

        for (int i = 0; i < n; i++) {

            if (arr[i] < mini) {
                mini = Math.min(mini, arr[i]);
                ans = i;
            }
        }
        return ans;
    }

    // optimize
    public static int findKRotation2(int arr[]) {

        int start = 0;
        int end = arr.length - 1;
        int mini = Integer.MAX_VALUE;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[start] <= mini) {

                mini = Math.max(mini, start);
                end = mid - 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };
        int ans = findKRotation2(arr);
        System.out.println("The array is rotated " + ans + " times.");
    }

}
