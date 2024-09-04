import java.util.*;;

public class RotateImage_90 {

    /*
     * static int[][] rotate(int[][] arr) {
     * int n = arr.length;
     * 
     * int[][] rotatedImage = new int[n][n];
     * for (int i = 0; i < n; i++) {
     * for (int j = 0; j < n; j++) {
     * rotatedImage[j][n - i - 1] = arr[i][j];
     * }
     * }
     * return rotatedImage;
     * }
     * 
     * 
     * 
     * public static void main(String[] args) {
     * int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
     * 
     * int rotated[][] = rotate(arr);
     * 
     * System.out.println("Rotated image");
     * for (int i = 0; i < rotated.length; i++) {
     * for (int j = 0; j < rotated[0].length; j++) {
     * System.out.print(rotated[i][j]);
     * }
     * System.out.println();
     * }
     * }
     * 
     * }
     * 
     */

    // ANOTHER METHOD
    static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        rotate(arr);

        System.out.println("Rotated image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}