import java.util.*;

public class q13_minimum_cost_of_ropes {

    public static int minCost(int arr[], int n) {

        Arrays.sort(arr);

        int i = 0;
        int ans = 0;
        int sum = 0;

        while (i < n) {

            sum = sum + arr[i];
            ans = ans + sum;

        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 3, 2, 6 };
        int n = 4;

        System.out.println(minCost(arr, n));
    }

}
