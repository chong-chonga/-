package cn.leetcode.array;

/**
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 */
public class SumOfLargestSubarray1 {
    /**
     * 使用Max存储遍历到的所有子数组的最大的那个和, 最大子数组可能下次遍历的时候因为加上了负数, 被淘汰了
     * 但是没关系, 全盛时期的它可能在Max那里保留着记录
     * maxOfTwo用于存储当前子数组的和, 当子数组的和没有num大的时候, 就换目标, 变成以num开始的子数组
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int forwardSum = 0;
        int currentSum = 0;
        int Max = nums[0];
        for (int num : nums)
        {
            currentSum = forwardSum + num;
            forwardSum = Math.max(currentSum, num);
            Max = Math.max(Max, forwardSum);
        }
        return Max;
    }

}
