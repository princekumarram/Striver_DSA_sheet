import java.util.Stack;

public class q3_Parenthesis_Checker {
    static boolean isParenthesisBalanced(String str) {

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char current = str.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                stk.push(current);
            } else {
                if (stk.isEmpty()) {
                    return false; // If there's a closing bracket but no opening bracket
                }

                char top = stk.pop(); // Move this line outside of the if statement

                // Check for matching parentheses
                if ((current == ')' && top != '(') ||
                        (current == '}' && top != '{') ||
                        (current == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stk.isEmpty(); // Return true if all opening brackets are matched
    }

    public static void main(String args[]) {

        // Test cases
        String s1 = "{([])}";
        String s2 = "()";
        String s3 = "([]";
        String s4 = "([{}])";
        String s5 = "((()))";
        String s6 = "({[()]})";
        String s7 = "([)]"; // Should return false

        System.out.println(isParenthesisBalanced(s1)); // true
        System.out.println(isParenthesisBalanced(s2)); // true
        System.out.println(isParenthesisBalanced(s3)); // false
        System.out.println(isParenthesisBalanced(s4)); // true
        System.out.println(isParenthesisBalanced(s5)); // true
        System.out.println(isParenthesisBalanced(s6)); // true
        System.out.println(isParenthesisBalanced(s7)); // false
    }
}