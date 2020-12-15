package cn.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 悠一木碧
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 */
public class MainElement {
    public int majorityElement(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        Map<Integer, Integer> elementOccurrence = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(!elementOccurrence.containsKey(nums[i])){
                elementOccurrence.put(nums[i], 1);
            } else{
                Integer times = elementOccurrence.get(nums[i]);
                times += 1;
                if(times > nums.length / 2){
                    return nums[i];
                } else{
                    elementOccurrence.replace(nums[i], times);
                }
            }
        }
        return -1;
    }
}
