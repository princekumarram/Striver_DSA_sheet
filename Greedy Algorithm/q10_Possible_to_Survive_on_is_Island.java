import java.util.*;

public class q10_Possible_to_Survive_on_is_Island {

    public static int minimumDay(int S, int N, int M) {
        int sunday = S / 7;

        int buyingDays = S - sunday;
        int totalFood = S * M;
        int ans = 0;

        if (totalFood % N == 0) {
            ans = totalFood / N;
        } else {
            ans = totalFood / N + 1;
        }

        if (ans <= buyingDays) {
            return ans;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int S = 10;
        int N = 16;
        int M = 2;

        System.out.println(minimumDay(S, N, M));
    }

}
