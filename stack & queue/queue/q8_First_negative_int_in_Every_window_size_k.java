
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class q8_First_negative_int_in_Every_window_size_k {

    public static List<Integer> firstNegativeInWindow(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>(); // to store indices of negative numbers

        for (int i = 0; i < arr.length; i++) {
            // Add current element index if it's negative
            if (arr[i] < 0) {
                dq.addLast(i);
            }

            // Remove elements that are out of the current window
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }

            // Process each window starting from i = k - 1
            if (i >= k - 1) {
                // If deque is not empty, the front element is the first negative in this window
                if (!dq.isEmpty()) {
                    result.add(arr[dq.peekFirst()]);
                } else {
                    result.add(0); // No negative integer in this window
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int k = 3;
        List<Integer> result = firstNegativeInWindow(arr, k);
        System.out.println(result); // Output: [-1, -1, -7, -15, -15, 0]
    }
}
