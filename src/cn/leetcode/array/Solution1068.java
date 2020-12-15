package cn.leetcode.array;

import java.util.Arrays;

/**
 * @author 悠一木碧
 * 题目编号: 1608
 * 思路: 先对数组进行排序, 用index指针维护nums数组位置, 从0~100进行枚举i
 * 然后开始寻找不小于i的数, 并停下来判断当前大于等于x的元素的数量, 如果相等, 返回
 * 否则开始枚举下一个数
 */
public class Solution1068 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int index = 0;
        for(int i = 0; i <= 100; i++){
            if(nums[index] < i && nums.length - index < i){
                break;
            }
            for (;index < nums.length; index++) {
                if(nums[index] >= i){
                    if(nums.length - index == i){
                        return i;
                    }
                    break;
                }
            }
        }
        return -1;
    }
}
