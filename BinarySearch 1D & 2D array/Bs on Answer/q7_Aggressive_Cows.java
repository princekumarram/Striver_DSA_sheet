
public class q7_Aggressive_Cows {

    // Brute force
    public static int missingK1(int[] arr, int n, int k) {

        for (int i = 0; i < n; i++) {
            if (arr[i] <= k)
                k++;
            else
                break;
        }
        return k;
    }

    // Binary Search
    public static int missingK2(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k + high + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 7, 9, 10 };
        int n = 4, k = 4;
        int ans = missingK2(arr, n, k);
        System.out.println("The missing number is: " + ans);
    }

}
