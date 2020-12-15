package cn.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 悠一木碧
 * 题目编号: 15
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        if(null != nums && nums.length >= 3){
            Arrays.sort(nums);
            int len = nums.length;
            for(int i = 0; i < nums.length - 2; i++){
                if(i > 0 && nums[i] == nums[i - 1]){
                    continue;
                }
                if(nums[i] + nums[i + 1] + nums[i + 2] > 0){
                    break;
                }
                if(nums[i] + nums[len - 2] + nums[len - 1] < 0){
                    continue;
                }
                int left = i + 1;
                int right = len - 1;
                while(left < right){
                    int sum = nums[i] + nums[left] + nums[right];
                    if(sum == 0){
                        ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                        left++;
                        while(left < right && nums[right] == nums[right - 1]){
                            right--;
                        }
                        right--;
                    } else if(sum > 0){
                        right--;
                    } else{
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}
