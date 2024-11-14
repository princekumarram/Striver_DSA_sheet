public class q9_Search_Element_in_Rotated_Sorted_Array_II {

    public static boolean searchInARotatedSortedArrayII(int arr[], int k) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // if mid points the target
            if (arr[mid] == k)
                return true;

            // Edge Case

            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                start = start + 1;
                end = end - 1;
                continue;
            }
            
            //if left part id sorted

            if(arr[start]<=arr[mid]){
                if(arr[start]<=k && k)
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = { 7, 8, 1, 2, 3, 3, 3, 4, 5, 6 };
        int k = 3;
        boolean ans = searchInARotatedSortedArrayII(arr, k);
        if (ans == false)
            System.out.println("Target is not present.");
        else
            System.out.println("Target is present in the array.");
    }

}
