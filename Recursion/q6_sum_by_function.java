
public class q6_sum_by_function {

    static int PrintSum(int i) {

        if (i == 0) {
            return 0;
        }

        return i + PrintSum(i - 1);

    }

    public static void main(String[] args) {

        int i = 3;

        System.out.println(PrintSum(i));

    }

}
