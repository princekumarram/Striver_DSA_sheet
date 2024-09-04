import java.util.*;

public class SetMatrixZeroes {

    /*
     * //---IT IS ONLY FOR POSITIVE INTEGER
     * static void markRow(ArrayList<ArrayList<Integer>> matrix, int n, int m, int
     * row) {
     * 
     * for (int i = 0; i < n; i++) {
     * if (matrix.get(row).get(i) != 0) {
     * matrix.get(row).set(i, -1);
     * 
     * }
     * }
     * 
     * }
     * 
     * static void markCol(ArrayList<ArrayList<Integer>> matrix, int n, int m, int
     * col) {
     * for (int i = 0; i < m; i++) {
     * if (matrix.get(i).get(col) != 0) {
     * matrix.get(i).set(col, -1);
     * }
     * }
     * 
     * }
     * 
     * static ArrayList<ArrayList<Integer>>
     * ZeroesMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
     * 
     * for (int row = 0; row < n; row++) {
     * for (int col = 0; col < m; col++) {
     * 
     * if (matrix.get(row).get(col) == 0) {
     * 
     * markRow(matrix, n, m, row);
     * markCol(matrix, n, m, col);
     * }
     * }
     * 
     * }
     * 
     * for (int row = 0; row < n; row++) {
     * for (int col = 0; col < m; col++) {
     * if (matrix.get(row).get(col) == -1) {
     * matrix.get(row).set(col, 0);
     * }
     * }
     * }
     * return matrix;
     * }
     */

    // ------------------ANTOHER METHOD------------------

    static ArrayList<ArrayList<Integer>> ZeroesMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {

        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (matrix.get(i).get(j) == 0) {

                    row[i] = 1;
                    col[j] = 1;

                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (row[i] == 1 || col[j] == 1) {

                    matrix.get(i).set(j, 0);

                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int n = matrix.size();
        int m = matrix.get(0).size();

        System.out.println("The final matrix is");
        ArrayList<ArrayList<Integer>> ans = ZeroesMatrix(matrix, n, m);

        for (ArrayList<Integer> row : ans) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}