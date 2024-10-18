
public class q7_Factorial_of_N {

    static int getFactorial(int n) {

        if (n == 0) {
            return 1;
        }

        return n * getFactorial(n - 1);

    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println(getFactorial(n));

    }

}
