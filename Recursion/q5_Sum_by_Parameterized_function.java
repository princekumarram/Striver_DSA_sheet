
public class q5_Sum_by_Parameterized_function {

    static void PrintSum(int i, int n) {

        if (i < 1) {

            System.out.print("sum=" + n + "  ");
            return;

        }

        PrintSum(i - 1, n + i);

    }

    public static void main(String[] args) {

        int n = 0;
        int i = 3;

        PrintSum(i, n);

    }

}
