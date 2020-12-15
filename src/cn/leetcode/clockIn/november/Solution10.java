package cn.leetcode.clockIn.november;

/**
 * @author 悠一木碧
 * 题目编号: 31. 下一个排列
 */
public class Solution10 {
    public void nextPermutation(int[] nums) {
        int L, R;
        L = R = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < nums[i + 1]){
                L = i;
                R = i + 1;
            }
        }
    }
}
