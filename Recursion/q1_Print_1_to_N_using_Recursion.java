
public class q1_Print_1_to_N_using_Recursion {

    static void PrintNumber(int i, int n) {

        if (i >= n)
            return;
        System.out.print(i + " ");

        PrintNumber(i + 1, n);

    }

    public static void main(String[] args) {

        int n = 3;
        int i = 0;

        PrintNumber(i, n);

    }

}
