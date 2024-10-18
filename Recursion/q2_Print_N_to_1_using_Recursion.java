
public class q2_Print_N_to_1_using_Recursion {

    static void PrintNumber(int i, int n) {

        if (i < 1)
            return;
        System.out.print(i + " ");

        PrintNumber(i - 1, n);

    }

    public static void main(String[] args) {

        int n = 10;
        int i = 10;

        PrintNumber(i, n);

    }

}
