
public class q11_Minimum_number_of_Parentheses_to_be_added_to_make_it_valid {

    public static int minAddToMakeValid(String s) {

        int open = 0;
        int close = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                open++;
            }

            else if (ch == ')') {

                if (open > 0) {
                    open--;
                } else
                    close++;
            }

        }
        return open + close;

    }

    public static void main(String[] args) {
        String exp1 = "())";
        String exp2 = "(((";
        String exp3 = "()";

        System.out.println("Minimum parentheses to be added for exp1: " + minAddToMakeValid(exp1)); // Output: 1
        System.out.println("Minimum parentheses to be added for exp2: " + minAddToMakeValid(exp2)); // Output: 3
        System.out.println("Minimum parentheses to be added for exp3: " + minAddToMakeValid(exp3)); // Output: 0
    }

}
