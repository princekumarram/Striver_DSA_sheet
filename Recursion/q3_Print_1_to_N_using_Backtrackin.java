
public class q3_Print_1_to_N_using_Backtrackin {

    static void PrintNumber(int i, int n) {

        if (i < 1)
            return;

        PrintNumber(i - 1, n);

        System.out.print(i + " ");
    }

    public static void main(String[] args) {

        int n = 10;
        int i = 10;

        PrintNumber(i, n);

    }

}
