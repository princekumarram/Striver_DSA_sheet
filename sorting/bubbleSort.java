
import java.util.*;

public class bubbleSort {

    static void getSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("After the insetion");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 13, 46, 24, 52, 20, 9 };

        getSort(arr);

    }
}