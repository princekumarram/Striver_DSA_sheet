import java.util.*;

public class q1_CheckPalindrome {

    public static boolean getPalindrome(String str) {

        str = str.toLowerCase();

        for (int i = 0; i < str.length() / 2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length() - 1 - i);

            while (start != end) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abba";

        System.out.println(getPalindrome(str));
    }

}
