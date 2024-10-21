public class q14_Next_Greater_Element {
    public static void main(String args[]) {
        int arr[] = { 5, 7, 1, 2, 6, 0 };

        int arr2[] = nextGreaterElements(arr);
        System.out.println("The next greater elements are ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

    }
}
