package cn.leetcode.array;

/**
 * @author 悠一木碧
 */
public class TransposeMatrix {
    static class Coordinate{
        public int x;
        public int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int[][] transpose(int[][] A) {
        int totalRows = A.length;
        int totalCols = A[0].length;
        int[][] result = new int[totalCols][totalRows];
        int startCols = 0;
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }

}
