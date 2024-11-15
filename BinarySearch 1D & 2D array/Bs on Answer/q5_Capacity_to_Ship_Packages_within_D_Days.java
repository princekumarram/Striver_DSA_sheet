public class q5_Capacity_to_Ship_Packages_within_D_Days {

    public static int findDays(int[] weights, int cap) {
        int days = 1; // First day.
        int load = 0;
        int n = weights.length;
        for (int i = 0; i < n; i++) {
            if (load + weights[i] > cap) {
                days += 1;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }
        return days;
    }

    // method-1
    public static int leastWeightCapacity1(int[] weights, int d) {
        // find the maximum and the summation :
        int maxi = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            maxi = Math.max(maxi, weights[i]);
        }

        for (int i = maxi; i <= sum; i++) {
            if (findDays(weights, i) <= d) {
                return i;
            }
        }
        return -1;
    }

    // method-2
    public static int leastWeightCapacity2(int[] weights, int d) {
        // find the maximum and the sumation :

        /*
         * //Time exceed
         * int low = Integer.MIN_VALUE, high = 0;
         * for (int i = 0; i < weights.length; i++) {
         * high += weights[i];
         * low = Math.max(low, weights[i]);
         * }
         * 
         * while (low <= high) {
         * int mid = (low + high) / 2;
         * int numberOfDays = findDays(weights, mid);
         * if (numberOfDays <= d) {
         * // eliminate right half
         * high = mid - 1;
         * } else {
         * // eliminate left half
         * low = low + 1;
         * }
         * }
         * return low;
         */

        int low = 0, high = 0;
        for (int weight : weights) {
            high += weight; // Sum of all weights
            low = Math.max(low, weight); // Maximum weight
        }

        // Binary search
        while (low < high) {
            int mid = low + (high - low) / 2;
            int numberOfDays = findDays(weights, mid);
            if (numberOfDays <= d) {
                high = mid; // Try for smaller capacity
            } else {
                low = mid + 1; // Increase capacity
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] weights = { 5, 4, 5, 2, 3, 4, 5, 6 };
        int d = 5;
        int ans = leastWeightCapacity2(weights, d);
        System.out.println("The minimum capacity should be: " + ans);
    }

}
