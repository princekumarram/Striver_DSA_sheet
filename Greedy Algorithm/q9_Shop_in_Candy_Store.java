import java.util.*;
import java.util.ArrayList;

public class q9_Shop_in_Candy_Store {

    public static ArrayList<Integer> CandyStore(int candies[], int N, int K) {

        Arrays.sort(candies);

        int min = 0;
        int max = 0;
        int count = 0;

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            count = count + 1;
            min = min + candies[i];
            max = max + candies[N - i + 1];

            if (count >= N) {
                ans.add(min);
                ans.add(max);
                return ans;
            }

        }

        ans.add(-1);
        ans.add(-1);
        return ans;

    }

    public static void main(String args[]) {
        // ArrayList<Integer> candies = new ArrayList<>();
        // candies.add(3);
        // candies.add(2);
        // candies.add(1);
        // candies.add(4);

        int[] candies = { 3, 2, 1, 4 };

        ArrayList<Integer> ans = CandyStore(candies, 2, 4);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

}
