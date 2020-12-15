package cn.leetcode.bfs;

/**
 * @author 悠一木碧
 */
public class SurroundedArea {
    /**
     * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
     * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
     * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     * @param board
     */
    public void solve(char[][] board) {
        /*
        矩阵为2X2时, 将不会有被包围的'O'字符, 不进行操作
        与边界字符相连的字符肯定不是被包围的字符, 所以先寻找边界点字符, 进行标记和递归
         */
        if (board.length > 2 && board[0].length > 2) {
            int totalRows = board.length;
            int totalCols = board[0].length;
            for (int rowIndex = 0; rowIndex < totalRows; rowIndex++) {
                for (int colIndex = 0; colIndex < totalCols; colIndex++) {
                    if (
                            (0 == rowIndex || colIndex == 0 || rowIndex == totalRows - 1 || colIndex == totalCols - 1)
                                    &&
                                    (board[rowIndex][colIndex] == 'O')
                    ) {
                        mark(board, rowIndex, colIndex);
                    }
                }
            }
            for (int rowIndex = 0; rowIndex < totalRows; rowIndex++) {
                for (int colIndex = 0; colIndex < totalCols; colIndex++) {
                    if ('O' == board[rowIndex][colIndex]) {
                        board[rowIndex][colIndex] = 'X';
                    } else if ('M' == board[rowIndex][colIndex]) {
                        board[rowIndex][colIndex] = 'O';
                    }
                }
            }
        }
    }

    private void mark(char[][] board, int rowIndex, int colIndex) {
        board[rowIndex][colIndex] = 'M';
        if (rowIndex > 0 && board[rowIndex - 1][colIndex] == 'O') {
            mark(board, rowIndex - 1, colIndex);
        }
        if (colIndex > 0 && board[rowIndex][colIndex - 1] == 'O') {
            mark(board, rowIndex, colIndex - 1);
        }
        if (rowIndex < board.length - 1 && board[rowIndex + 1][colIndex] == 'O') {
            mark(board, rowIndex + 1, colIndex);
        }
        if (colIndex < board[0].length - 1 && board[rowIndex][colIndex + 1] == 'O') {
            mark(board, rowIndex, colIndex + 1);
        }

    }
}
