package cn.leetcode.clockIn.october;

/**
 * @author 悠一木碧
 * 题目编号: 845
 * 数组中最长的山脉
 */
public class Solution25 {
    public int longestMountain(int[] A) {
/*        先是升序, 然后降序, 中间有一个最大值
        0 1 2 假设长度为3, 左山脚到山顶是严格递增的, 山顶到右山脚是严格递减的*/
        if(null == A || 0 == A.length){
            return 0;
        }
        int length = A.length;
        int[] left = new int[length];
        int[] right = new int[length];

        right[length - 1] = left[0] = 0;
        for(int i = 1; i < length; i++){
            if(A[i] > A[i - 1]){
                left[i] = left[i - 1] + 1;
            } else{
                left[i] = 0;
            }
        }

        for(int i = length - 2; i >= 0; i--){
            if(A[i] > A[i + 1]){
                right[i] = right[i + 1] + 1;
            } else{
                right[i] = 0;
            }
        }

        int ans = -1;
        for (int i = 0; i < length; i++) {
            if(0 != left[i] && 0 != right[i]){
                ans = Math.max((left[i] + right[i] + 1), ans);
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.println(left[i]);
        }
        return ans;

    }
}
