package cn.leetcode.array;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * 输出: 4
 */
public class LargestSquareInMatrix {
    /**
     * 为了预防数组越界, 在获取列数的时候, 需要确保row != 0;
     * 确定矩形中能够存在的正方形的最大边长----Math.min(row, col)
     * 从最大的边长开始找, 找不到就将最大边长自减, 然后继续找....如此循环下去, 直至小于1, 返回0
     * 在找的过程中, 发现满足条件的正方形, 立即返回最大面积
     *
     * 取一个例子:
     * 当寻找的正方形边长为maxSize的时候, 由于行索引最大为row-1, 列索引最大为col-1
     * 则在 0 ~ maxSize-row  0 ~ maxSize-col 索引范围内可能存在要寻找的正方形
     * 超出这个索引范围, 将无法容纳下正方形, 也就不用找了, 直接开始下一个循环
     * @param matrix
     * @return
     */
    public int maximalSquare1(char[][] matrix) {
        if(null == matrix || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int maxSize = Math.min(row, col);

        while (maxSize > 0) {
            for (int r = 0; r <= row - maxSize; r++) {
                for (int c = 0; c <= col - maxSize; c++) {
                    if (matrix[r][c] == '1') {
                        if (isSquare(maxSize, matrix, r, c)) {
                            return maxSize * maxSize;
                        }
                    }
                }
            }
            maxSize--;
        }
        return 0;

    }

    /**
     * 使用动态规划, 比暴力解法的时间复杂度小很多
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if(null == matrix || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int maxLength = 0;
        int[][] dp = new int[row][col];
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(matrix[r][c] == '1'){
                    if(0 == r || c == 0){
                        dp[r][c] = 1;
                    } else{
                        dp[r][c] = Math.min(Math.min(dp[r-1][c], dp[r-1][c-1]),
                                dp[r][c-1]) + 1;
                    }
                    if(maxLength < dp[r][c]){
                        maxLength = dp[r][c];
                    }
                }
            }
        }
        return maxLength * maxLength;
    }

    private boolean isSquare(int squareSize, char[][] matrix, int startRow, int startCol) {

        for (int r = 0; r < squareSize; r++) {
            for (int c = 0; c < squareSize; c++) {
                if (matrix[startRow + r][startCol + c] != '1') {
                }
            }
        }
        return true;
    }

    /**
     * 事实证明, 可以在Java中定义一个0行的二维数组
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] array = new char[0][3];
        System.out.println(array.length);
    }

}
