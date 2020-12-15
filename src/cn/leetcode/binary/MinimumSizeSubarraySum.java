package cn.leetcode.binary;

import org.junit.Test;

import static cn.datastructure.search.Binary.contains;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s
 * 找出该数组中满足其和 ≥ s 的长度最小的连续子数组，
 * 并返回其长度。如果不存在符合条件的连续子数组，返回 0。

 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
public class MinimumSizeSubarraySum {
    /**
     * 传递前缀和数组S, 以及开始计算在内的元素下标l
     * @param S 前缀和数组S
     * @param l 开始计算在内的元素下标l
     * @param r 数组最大可用下标
     * @param target
     * @return 从l下标开始计算, 如果往后的和最先大于等于target, 返回其下标, 否则返回-1
     * 本质就是从下标为l的元素开始计算和, 找到当和大于等于target的时候的最小成立下标
     * 由于传递的是前缀和数组, 所以需要将对应值减去下标l之前的元素和
     */
    private int getMinIndex(int[] S, int l, int r, int target){
        int forwardSum, mid;
        if(l > 0)
        {
            forwardSum = S[l - 1];
        }
        else{
            forwardSum = 0;
        }
        while(l < r)
        {
            mid = (l + r) / 2;
            if(S[mid] - forwardSum < target){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return S[l] - forwardSum >= target ? l : -1;
    }

/*    public int minSubArrayLen(int s, int[] nums) {
        int size = nums.length;
        if (0 == size) {
            return 0;
        }
        int[] sums = new int[size];
        sums[0] = nums[0];
        for (int i = 1; i < size; ++i) {
            sums[i] = sums[i - 1] + nums[i];
        }

        int minLen = size + 1;
        for (int i = 0; i < size; ++i) {
            int index = getMinIndex(sums, i, size - 1, s);
            if (-1 != index) {
                minLen = Math.min(minLen, index - i + 1);
            }
        }
        return minLen == size + 1 ? 0 : minLen;
    }*/

    public int minSubArrayLen(int s, int[] nums){
        int size = nums.length;
        int start;
        int end;
        start = end = 0;
        int minSize = size + 1;
        int sum = nums[0];
        int n;
        while(true) {
            while (sum < s)
            {
                end++;
                if(end < size) {
                    sum += nums[end];
                } else {
                    return minSize == size+1 ? 0 : minSize;
                }
            }
            n = end - start + 1;
            minSize = Math.min(minSize, n);
            while(sum >= s)
            {
                sum -= nums[start];
                start++;
                if(sum >= s)
                {
                    n = end - start + 1;
                    minSize = Math.min(minSize, n);
                }
            }
        }
    }

    @Test
    public void testSearch(){
        int[] array = {12, 32, 44, 54, 65, 66, 67, 72, 78, 79, 90};
        System.out.println(contains(array, 12));
    }

}
