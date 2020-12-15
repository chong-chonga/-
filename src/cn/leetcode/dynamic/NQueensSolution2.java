package cn.leetcode.dynamic;

public class NQueensSolution2 {
    int count;
    int[] cols;
    int[] leftDiagonals;
    int[] rightDiagonals;
    int solutions;
    /**
     * 现在返回的是解的个数, 也就是说, 不需要去存储皇后所在的位置, 也不需要存储解决方案
     * 只需要拿出判定条件即可, 还是一样的, 一行一行循环下去
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        count = n;
        cols = new int[n];
        leftDiagonals = new int[2 * n - 1];
        rightDiagonals = new int[2 * n - 1];
        solutions = 0;
        solve(0);
        return solutions;
    }

    private void solve(int row) {
        for(int c = 0; c < count; c++){
            if(isAvailable(row, c))
            {
                cols[c] = 1;
                leftDiagonals[row + c] = 1;
                rightDiagonals[row - c +count - 1] = 1;
                if(row == count - 1)
                { solutions++; }
                else
                { solve(row + 1); }
                {
                    cols[c] = 0;
                    leftDiagonals[row + c] = 0;
                    rightDiagonals[row - c +count - 1] = 0;
                }
            }
        }
    }

    private boolean isAvailable(int row, int col) {
        return cols[col] == 0 && leftDiagonals[row + col] == 0 && rightDiagonals[row - col + count - 1] == 0;
    }


}
