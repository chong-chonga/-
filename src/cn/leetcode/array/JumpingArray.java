package cn.leetcode.array;

import org.junit.Test;

/**
 * @author 悠一木碧
 */
public class JumpingArray {
    /**
     * 题目: 跳跃数组
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个位置。
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if(isOnlyOneElement(nums)){
            return true;
        }
        int upperLimit = nums.length;
        int optimalPosition = 0;
        int startingPoint = optimalPosition;
        int numberOfSteps = nums[optimalPosition];
        int optimalDistance = 0;

        while(true){
            for(int i = startingPoint + 1; i <= startingPoint + numberOfSteps && i < upperLimit; i++){
                if(i + nums[i] >= optimalDistance){
                    optimalDistance = i + nums[i];
                    optimalPosition = i;
                }
            }
            numberOfSteps = nums[optimalPosition];
            startingPoint = optimalPosition;
            if (0 == numberOfSteps && optimalPosition != upperLimit - 1) {
                return false;
            } else if(numberOfSteps + optimalPosition + 1 >= upperLimit){
                return true;
            }
        }


    }

    private boolean isOnlyOneElement(int[] array){
        return array != null && array.length == 1;
    }


    @Test
    public void testLongestWord(){
        int[] array = {3,2,1,0,4};
        canJump(array);
    }
}
