
public class q4_Print_N_time_Name_using_Recursion {

    static void PrintNumber(int i, int n) {

        if (i > n)
            return;
        System.out.print("Raj ");

        PrintNumber(i + 1, n);

    }

    public static void main(String[] args) {

        int n = 3;
        int i = 1;

        PrintNumber(i, n);

    }

}
