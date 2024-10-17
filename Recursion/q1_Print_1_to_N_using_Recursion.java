
public class q1_Print_1_to_N_using_Recursion {

    static void PrintNumber(int x) {

        System.out.println(x + " ");

        if (x <= 10) {
            PrintNumber(x + 1);
        }

    }

    public static void main(String[] args) {

        int x = 1;

        PrintNumber(x);

    }

}
