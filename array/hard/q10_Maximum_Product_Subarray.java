
public class q10_Maximum_Product_Subarray {

    public static int maxProductSubArray1(int nums[]) {

        int n = nums.length;
        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int prod = 1;
                for (int k = i; k <= j; k++) {
                    prod *= nums[k];
                    maxi = Math.max(prod, maxi);
                }

            }

        }
        return maxi;
    }

    public static int maxProductSubArray2(int nums[]) {
        int n = nums.length;
        int pre = 1;
        int suff = 1;

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (pre == 0)
                pre = 1;
            if (suff == 0)
                suff = 1;

            pre *= nums[i];
            suff *= nums[n - i - 1];

            ans = Math.max(ans, Math.max(pre, suff));
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, -3, 0, -4, -5 };
        int answer = maxProductSubArray2(nums);
        System.out.print("The maximum product subarray is: " + answer);
    }

}
