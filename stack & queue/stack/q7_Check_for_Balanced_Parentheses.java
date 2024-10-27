import java.util.Stack;

public class q7_Check_for_Balanced_Parentheses {

    public static boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                st.push(current);
            } else {
                if (st.isEmpty())
                    return false;

                char top = st.pop();

                if ((current == ')' && top != '(') ||
                        (current == ']' && top != '[') ||
                        (current == '}' && top != '{')) {
                    return false;
                }
            }

        }

        return st.isEmpty();

    }

    public static void main(String[] args) {

        String s = "()[{}()]";
        if (isValid(s) == true)
            System.out.println("True");
        else
            System.out.println("False");
    }

}