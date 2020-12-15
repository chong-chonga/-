package cn.leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

public class NQueensSolution1 {

    private List<List<String>> solutions = new ArrayList<>();
    //    利用queens数组的下标, 确定queens的row, 存储的值为queen所在的列, 即col索引
    private int[] queens;
    private int[] cols;
    private int[] leftDiagonals;
    private int[] rightDiagonals;
    private int count;

    /**
     * 传入的n参数, 表示了是nXn大小的棋盘, 有n个皇后, 一行一个, 一列一个
     * 左对角线(r + c) 的取值范围是0 ~ 2n - 2, 换算成数组大小就是 2n - 1, 最小下标为0, 正常创建即可
     * 右对角线(r - c) 的取值范围 (1-n) ~ (n-1), 最小下标是(1-n), 下标可能小于0 , 因此访问时, 加上n - 1即可
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        count = n;
        queens = new int[n];
        cols = new int[n];
        leftDiagonals = new int[2 * n - 1];
        rightDiagonals = new int[2 * n - 1];
        solve(0);
        return solutions;
    }

    /**
     * 递归方法, 统领全局, 在索引为r的行中放置皇后, 放置前先判断是否满足条件
     * 如果满足条件, 那么就调用place, 接着判断是否已经满足皇后数量, 满足就进行答案存储
     * 否则向下进一行, 放置好这行的皇后后, 我们得考虑不同列上的情况, 所以就需要remove当前放置的情况
     * 所以count定好了上界, 也定好了下界, 递归到什么时候就给出答案, 并且返回
     * @param r
     */
    private void solve(int r) {
        for(int c = 0; c < count; c++){
            if(isSuitable(r, c))
            {
                placeQueen(r, c);
                if(r == count - 1){
                    addQueen(r, c);
                }
                else {
                    solve(r+1);
                }
                removeQueen(r, c);
            }
        }
    }

    private void addQueen(int row, int col) {
        List<String> answer = new ArrayList<>();

        for(int i = 0; i < count; i++){
            StringBuilder stringBuilder = new StringBuilder();
            int n = queens[i];
            for(int j = 0; j < n; j++){
                stringBuilder.append('.');
            }
            stringBuilder.append('Q');
            for(int j = 0; j < count - n - 1; j++){
                stringBuilder.append('.');
            }
            answer.add(String.valueOf(stringBuilder));
        }
        solutions.add(answer);
    }

    private void removeQueen(int row, int col) {
        queens[row] = -1;
        cols[col] = 0;
        leftDiagonals[row + col] = 0;
        rightDiagonals[row - col + count - 1] = 0;
    }

    private  void placeQueen(int row, int col) {
        queens[row] = col;
        cols[col] = 1;
        leftDiagonals[row + col] = 1;
        rightDiagonals[row - col + count - 1] = 1;
    }

    private boolean isSuitable(int row, int col) {
        return  cols[col] == 0 && leftDiagonals[row + col] == 0 && rightDiagonals[row - col + count - 1] == 0;
    }


}
