package cn.leetcode.dynamic;

/**
 * @author 悠一木碧
 */
public class NumberOfWays {
    /**
     * dp[i][j]表示走i步, 到达j结点的路径总数
     * relation数组中指定了从[0]结点->[1]结点的可达性
     * @param n
     * @param relation
     * @param k
     * @return
     */
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for(int i = 0; i < k; i++){
            for (int[] ints : relation) {
                dp[i + 1][ints[1]] += dp[i][ints[0]];
            }
        }
        return dp[k][n - 1];
    }
}
