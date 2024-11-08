import java.util.*;

public class q5_Reverse_Words {

    // Mehod-1: Bruete force methode

    public static String reverseWords1(String str) {

        String words[] = str.split(" ");

        StringBuilder reversed = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);

            if (i != 0) {
                reversed.append(" ");
            }
        }
        return reversed.toString();

    }

    // Mehod-2: Recursion

    public static String reverseWords2(String str) {

        if (!str.contains(" ")) {
            return str;
        }

    }

    public static void main(String args[]) {
        String str1 = "Hello World";
        String str2 = " i like this program very much";
        String str3 = "pqr mno";

        // System.out.println(reverseWords1(str1));
        // System.out.println(reverseWords1(str2));
        // System.out.println(reverseWords1(str3));

        System.out.println(reverseWords2(str1));
        System.out.println(reverseWords2(str2));
        System.out.println(reverseWords2(str3));

    }

}
