package cn.leetcode.clockIn.october;

/**
 * @author 悠一木碧
 * 题目编号: 463
 */
public class Solution30 {
    private int ans;
    public int islandPerimeter(int[][] grid) {
        int[][] flags = new int[grid.length][grid[0].length];
        this.ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(1 == grid[i][j]){
                    find(grid, flags, i, j);
                    return this.ans;
                }
            }
        }
        return 0;
    }

    private void find(int[][] grid, int[][] flags, int i, int j) {
        flags[i][j] = 2;
        if(0 == j || 0 == grid[i][j - 1]){
            ++this.ans;
        } else{
            if(flags[i][j - 1] != 2){
                find(grid, flags, i, j - 1);
            }
        }
        if(grid[i].length - 1 == j || 0 == grid[i][j + 1]){
            ++this.ans;
        } else{
            if(flags[i][j + 1] != 2){
                find(grid, flags, i, j + 1);
            }
        }
        if(0 == i || 0 == grid[i - 1][j]){
            ++this.ans;
        } else{
            if(flags[i - 1][j] != 2){
                find(grid, flags, i - 1, j);
            }
        }
        if(grid.length - 1 == i || 0 == grid[i + 1][j]){
            ++this.ans;
        } else{
            if(flags[i + 1][j] != 2){
                find(grid, flags, i + 1, j);
            }
        }

    }
}
