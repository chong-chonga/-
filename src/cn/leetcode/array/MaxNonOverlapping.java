package cn.leetcode.array;

/**
 * @author 悠一木碧
 */
public class MaxNonOverlapping {
    /**
     * 给你一个数组 nums 和一个整数 target 。
     * 请你返回 非空不重叠 子数组的最大数目，且每个子数组中数字和都为 target
     * 1 <= nums.length <= 10^5
     * -10^4 <= nums[i] <= 10^4
     * 0 <= target <= 10^6
     * @param nums
     * @param target
     * @return
     */
    public int maxNonOverLapping(int[] nums, int target){
            return 0;
    }

    private int[] getPrefixAndArray(int[] source){
        if(null == source){
            return null;
        }
        int[] target = new int[source.length];
        target[0] = 0;
        for (int i = 1; i < source.length; i++) {
            target[i] = target[i - 1] + source[i];
        }
        return target;
    }
}
