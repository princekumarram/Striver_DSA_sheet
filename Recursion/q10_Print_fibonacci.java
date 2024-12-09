
public class q10_Print_fibonacci {

    public static int getFib(int n) {
        if (n <= 1)
            return 1;

        int last = getFib(n - 1);
        int slast = getFib(n - 2);

        return last + slast;

    }

    public static void f(int n) {
        int a = 0, b = 1;
        System.out.print(a + " " + b + " ");

        for (int i = 2; i < n; i++) {
            int next = a + b;
            System.out.print(next + " ");
            a = b;
            b = next;
        }
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println(getFib(n));
        f(n);
    }

}
