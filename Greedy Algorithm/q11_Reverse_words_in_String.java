
public class q11_Reverse_words_in_String {

    public static String reverseWords(String s) {
        StringBuilder ans = new StringBuilder(); // To store the final answer
        StringBuilder temp = new StringBuilder(); // To store the current word being processed

        // Traverse the string in reverse order
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '.') {
                // Reverse the current word and append to the answer
                ans.append(temp.reverse());
                ans.append('.'); // Add the dot separator
                temp.setLength(0); // Clear the temp buffer
            } else {
                // Add the current character to the temp word
                temp.append(s.charAt(i));
            }
        }

        // Append the last word after reversing
        ans.append(temp.reverse());

        return ans.toString();
    }

    public static void main(String args[]) {
        String input = "i.like.this.program.very.much";
        String result = reverseWords(input);
        System.out.println(result); // Output: much.very.program.this.like.i
    }

}
