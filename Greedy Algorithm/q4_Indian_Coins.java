import java.util.*;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class q4_Indian_Coins {
    public static void main(String[] args) {
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };

        Arrays.sort(coins, Comparator.reverseOrder());

        int countOfcoins = 0;
        int amount = 590;// 500+50+20+20
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {

                while (coins[i] <= amount) {
                    countOfcoins++;
                    ans.add(coins[i]);
                    amount = amount - coins[i];
                }

            }
        }
        System.out.println("total (min) coins used = " + countOfcoins);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }

}
