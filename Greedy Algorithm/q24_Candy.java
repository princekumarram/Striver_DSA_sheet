
import java.util.Arrays;

class q24_Candy {

    // TC--> O(3N)
    // SC--> O(2N)

    public int candy1(int[] ratings) {

        int n = ratings.length;

        if (n == 0)
            return 0; // Handle edge case when ratings is empty

        int[] left = new int[n];
        int[] right = new int[n];

        // Initialize the arrays
        left[0] = 1;
        right[n - 1] = 1;

        // Fill the left array
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        // Fill the right array
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        // Calculate the total candies
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(left[i], right[i]);
        }

        return sum;
    }

    // TC--O(2N)
    // SC--O(N)

    public int candy2(int[] ratings) {
        int n = ratings.length;

        if (n == 0)
            return 0; // Edge case: empty ratings array

        int[] left = new int[n];
        left[0] = 1; // The first child gets at least one candy

        // Fill the `left` array based on ratings
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int sum = 0;
        int cur = 1; // Tracks the current candy count from the right

        // Traverse from the right and calculate the sum
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                cur += 1;
            } else {
                cur = 1;
            }
            sum += Math.max(left[i], cur); // Max of left[i] and right[i] determines candies for child i
        }

        return sum;
    }

    // TC-->O(N)
    // SC-->O(1)

    public int candy3(int[] ratings) {
        int n = ratings.length;

        if (n == 0)
            return 0; // Handle edge case of empty ratings array

        int sum = 1; // The first child gets at least one candy
        int i = 1;

        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }

            int peak = 1;

            // Handle the increasing sequence (uphill)
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak += 1;
                sum += peak;
                i++;
            }

            int down = 0;

            // Handle the decreasing sequence (downhill)
            while (i < n && ratings[i] < ratings[i - 1]) {
                down += 1;
                sum += down;
                i++;
            }

            // If the downhill is longer than the uphill, adjust the sum
            if (down >= peak) {
                sum += down - peak + 1;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        q24_Candy solution = new q24_Candy();

        // Input: ratings = [1, 0, 2]
        int[] ratings = { 1, 0, 2 };

        // Call the candy method and print the result
        int result = solution.candy1(ratings);
        // int result = solution.candy2(ratings);
        // int result = solution.candy3(ratings);
        System.out.println("Total candies needed: " + result);
    }
}
