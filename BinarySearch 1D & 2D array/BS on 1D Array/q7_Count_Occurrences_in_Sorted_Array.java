public class q7_Count_Occurrences_in_Sorted_Array {

    // method 1

    public static int count1(int arr[], int n, int x) {

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x)
                cnt++;
        }
        return cnt;
    }

    // method 2
    public static int count2(int arr[], int n, int x) {

        int cnt = 0;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == x) {
                cnt++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 8, 8, 11, 13 };
        int n = 8, x = 8;
        int ans = count2(arr, n, x);
        System.out.println("The number of occurrences is: " + ans);
    }

}
