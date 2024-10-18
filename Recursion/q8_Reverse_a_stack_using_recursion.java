public class q8_Reverse_a_stack_using_recursion {

    public static void reverseStack(int[] arr, int i, int n) {

        if (i >= n)
            return;

        swap(arr, i, n);

        reverseStack(arr, i + 1, n - 1);
    }

    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void printArray(int arr[], int n) {
        System.out.print("Reversed array is:- \n");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int N = 5;
        reverseStack(arr, 0, N - 1);

        printArray(arr, N);
    }

}
