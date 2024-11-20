import java.util.*;

public class q2_Minimum_Sum_absolute_difference_pairs {

    public static void getDiff(int A[], int B[]) {
        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;

        for (int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i] - B[i]);
        }

        System.out.println("min absolute diff of pairs = " + minDiff);
    }

    public static void main(String[] args) {
        int A[] = { 1, 2, 3 };
        int B[] = { 2, 1, 3 };

        getDiff(A, B);

    }
}