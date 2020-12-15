package cn.leetcode.clockIn.october;

/**
 * @author 悠一木碧
 * 题目编号: 1365
 */
public class Solution26 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] numsCount = new int[101];
        int[] dp = new int[101];
        for (int num : nums) {
            ++numsCount[num];
        }
        dp[0] = 0;
        for (int i = 1; i < numsCount.length; i++) {
            dp[i] = dp[i - 1] + numsCount[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = dp[nums[i]];
        }
        return nums;
    }
}
