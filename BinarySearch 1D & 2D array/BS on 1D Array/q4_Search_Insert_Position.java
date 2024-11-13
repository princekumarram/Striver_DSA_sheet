
public class q4_Search_Insert_Position {

    public static int searchInsert(int arr[], int x) {

        int n = arr.length;
        int ans = -1;

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] >= x) {
                ans = mid;
                end = mid - 1;

            } else {
                start = mid + 1;

            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 7 };
        int x = 6;
        int ind = searchInsert(arr, x);
        System.out.println("The index is: " + ind);

    }

}
