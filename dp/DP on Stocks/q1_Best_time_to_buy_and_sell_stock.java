
public class q1_Best_time_to_buy_and_sell_stock {

    public static int maximumProfit(int arr[]) {
        int n = arr.length;
        int maxProfit = Integer.MIN_VALUE;
        int mini = arr[0];

        for (int i = 1; i < n; i++) {
            int ans = arr[i] - mini;
            maxProfit = Math.max(maxProfit, ans);
            mini = Math.min(mini, arr[i]);

        }
        return maxProfit;
    }

    public static void main(String args[]) {

        int[] Arr = { 7, 1, 5, 3, 6, 4 };

        System.out.println("The maximum profit by selling the stock is " +
                maximumProfit(Arr));
    }

}