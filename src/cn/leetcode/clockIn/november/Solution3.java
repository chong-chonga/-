package cn.leetcode.clockIn.november;

/**
 * @author 悠一木碧
 * 题目编号: 941
 */
public class Solution3 {
    public boolean validMountainArray(int[] A) {
        int len = A.length;
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];

        dp1[0] = dp2[len - 1] = 0;

        for (int i = 1; i < len; i++) {
            if(A[i] > A[i - 1]){
                dp1[i] = dp1[i - 1] + 1;
            } else{
                dp1[i] = 0;
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            if(A[i] > A[i + 1]){
                dp2[i] = dp2[i + 1] + 1;
            } else{
                dp2[i] = 0;
            }
        }


        for (int i = 1; i < len - 1; i++) {
            if(dp1[i] + dp2[i] == len - 1){
                return true;
            }
        }
        return false;
    }
}
