
public class q10_Print_fibonacci {

    public static int getFib(int n) {
        if (n <= 1)
            return 1;

        int last = getFib(n - 1);
        int slast = getFib(n - 2);

        return last + slast;
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println(getFib(n));
    }

}
