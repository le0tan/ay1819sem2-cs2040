/**
 * Paint
 */
public class Paint {

    public static void paintBucketFill(int[][] mat, int row, int col, int color, int initColor) {
        if(row < 0 || col < 0 || row >= mat.length || (mat.length>=1 && col >= mat[0].length)) {
            return;
        } else if (mat[row][col] != initColor){
            return;
        } else {
            mat[row][col] = color;
            paintBucketFill(mat, row+1, col, color, initColor);
            paintBucketFill(mat, row, col+1, color, initColor);
            paintBucketFill(mat, row-1, col, color, initColor);
            paintBucketFill(mat, row, col-1, color, initColor);
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            } // not particular about extra trailing space here
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] colourMatrix = { { 1, 1, 1, 1, 2, 2, 2, 1 }, { 1, 1, 1, 0, 0, 0, 0, 2 }, { 2, 1, 0, 0, 0, 0, 2, 2 },
                { 1, 0, 0, 0, 0, 0, 2, 2 }, { 2, 0, 0, 2, 2, 2, 1, 1 }, { 2, 0, 0, 2, 2, 0, 0, 0 },
                { 1, 1, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 2 } };
        System.out.println("Before fill...");
        printMatrix(colourMatrix);
        System.out.println();
        paintBucketFill(colourMatrix, 2, 3, 2, 0);
        System.out.println("After fill...");
        printMatrix(colourMatrix);
    }
}