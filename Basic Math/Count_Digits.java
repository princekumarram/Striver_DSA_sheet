import java.io.*;
import java.util.*;

class Count_Digits {

    static int evenlyDivides(int N) {

        int cnt = 0;
        int num = N;
        int id;
        while (num > 0) {

            id = num % 10;

            if (id > 0) {
                if (N % id == 0) {
                    cnt++;
                }
            }
            num = num / 10;

        }
        return cnt;

    }

    public static void main(String[] args) throws IOException {

        Scanner is = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int N = is.nextInt();

        System.out.println(evenlyDivides(N));
    }

}
