public class q2_Nth_Root_of_a_Number_using_Binary_Search {

    /*
     * //Method is some time happen overflow
     * // Power exponential method:
     * public static long fun(int b, int exp) {
     * long ans = 1;
     * long base = b;
     * while (exp > 0) {
     * if (exp % 2 == 1) {
     * exp--;
     * ans = ans * base;
     * } else {
     * exp = exp / 2;
     * base = base * base;
     * }
     * }
     * return ans;
     * }
     * 
     * public static int NthRoot(int n, int m) {
     * 
     * // Use linear search on the answer space:
     * for (int i = 0; i <= m; i++) {
     * long val = fun(i, n);
     * 
     * if (val == (long) m)
     * return i;
     * else if (val > (long) m)
     * break;
     * }
     * return -1;
     * }
     * 
     */

    // method

    public static int fun(int mid, int n, int m) {

        // return 1 if mid==m
        // return 0 if mid<m
        // return 2 if mid >m
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > m)
                return 2;
        }
        if (ans == m)
            return 1;
        return 0;
    }

    public static int NthRoot(int n, int m) {
        int low = 1;
        int high = m;

        while (low <= high) {
            int mid = (low + high) / 2;
            int MIDN = fun(mid, n, m);

            if (MIDN == 1) {
                return mid;
            } else if (MIDN == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3, m = 27;
        int ans = NthRoot(n, m);
        System.out.println("The answer is: " + ans);
    }
}