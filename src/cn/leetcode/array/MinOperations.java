package cn.leetcode.array;

import java.util.Arrays;

/**
 * @author 悠一木碧
 * 0: 给指定的元素+1, 1: 将所有元素的值进行翻倍
 *
 */
public class MinOperations {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int totalOperations = 0;
        boolean hasDivision;
        while(nums[nums.length - 1] != 0){
            hasDivision = false;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] == 1){
                    nums[i] = 0;
                    totalOperations++;
                } else if(nums[i] > 1){
                    if(nums[i] % 2 != 0){
                        nums[i] -= 1;
                        totalOperations++;
                    }
                    if(!hasDivision){
                        totalOperations++;
                        hasDivision = true;
                    }
                    nums[i] /= 2;
                }
            }

        }
        return totalOperations;
    }
}
