import java.util.Stack;
import java.util.*;

public class q5_Reverse_String_array__using_Stack {

    public static String ReverseArray(String s) {
        Stack<Character> stack = new Stack<>();

        int indx = 0;
        while (indx < s.length()) {
            stack.push(s.charAt(indx));
            indx++;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {

            char curr = stack.pop();
            result.append(curr);
        }
        return result.toString();

    }

    public static void main(String[] args) {

        String s = "abc";

        String result = ReverseArray(s);
        System.out.println(result);

    }

}
