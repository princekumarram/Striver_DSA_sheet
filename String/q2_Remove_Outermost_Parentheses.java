import java.util.*;

public class q2_Remove_Outermost_Parentheses {

    public static String removeOuterParentheses(String S) {
        StringBuilder res = new StringBuilder(); // Use StringBuilder for efficiency
        int count = 0;

        for (int i = 0; i < S.length(); i++) {
            char current = S.charAt(i);

            // Increment count for '(' and decrement for ')'
            if (current == '(') {
                // Only add to result if it's not the outermost '('
                if (count > 0) {
                    res.append(current);
                }
                count++;
            } else if (current == ')') {
                // Only add to result if it's not the outermost ')'
                if (count > 1) {
                    res.append(current);
                }
                count--;
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String S = "(()())(())()";
        System.out.print(removeOuterParentheses(S)); // Expected output: ()()()
    }
}