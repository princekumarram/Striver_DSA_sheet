import java.util.*;

public class q4_Reverse_String {

    // Using the stack Method -1
    public static String getReverse1(String str) {

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stk.push(str.charAt(i));

        }

        StringBuilder revString = new StringBuilder();

        while (!stk.isEmpty()) {
            char top = stk.pop();
            revString.append(top);
        }

        return revString.toString();

    }

    // Using recursion method -2
    public static String getReverse2(String str) {

        // Base case: if the string is empty or has one character
        if (str.isEmpty()) {
            return str;
        }

        // Recursive case: take the first character and move it to the end, then reverse
        // the rest
        return getReverse2(str.substring(1)) + str.charAt(0);

    }

    // Method 3: Using StringBuilder

    public static String getReverse3(String str) {

        String reversed = new StringBuilder(str).reverse().toString();

        return reversed;

    }

    public static void main(String[] args) {
        String str = "Hello";

        System.out.println(getReverse2(str));
    }

}
