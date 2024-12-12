import java.util.*;

public class q3_Largest_Divisible_Subset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return new ArrayList<>();

        int[] dp = new int[n];
        int[] hash = new int[n];

        Arrays.fill(dp, 1); // Each element is a subset of itself initially
        Arrays.fill(hash, -1);

        Arrays.sort(nums);

        int maxi = 1;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] % nums[prev] == 0 && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                    hash[i] = prev;
                }
            }

            if (dp[i] > maxi) {
                maxi = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> temp = new ArrayList<>();

        while (hash[lastIndex] != lastIndex) {
            temp.add(nums[lastIndex]);
            lastIndex = hash[lastIndex];
        }
        temp.add(nums[lastIndex]); // Add the last element

        Collections.reverse(temp);

        return temp;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 16, 7, 8, 4 };

        q3_Largest_Divisible_Subset solution = new q3_Largest_Divisible_Subset();
        List<Integer> ans = solution.largestDivisibleSubset(arr);

        System.out.print("The longest divisible subset elements are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}