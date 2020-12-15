package cn.leetcode.clockIn.november;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 悠一木碧
 * 题目编号: 349
 */
public class Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index1, index2;
        index1 = index2 = 0;
        List<Integer> intersection = new ArrayList<>();
        while(index1 < nums1.length && index2 < nums2.length){
            if(nums1[index1] == nums2[index2]){
                intersection.add(nums1[index1]);
                while(index1 < nums1.length  - 1&& nums1[index1] == nums1[index1 + 1]){
                    ++index1;
                }
                ++index1;
                while(index2 < nums2.length  - 1&& nums2[index2] == nums2[index2 + 1]){
                    ++index2;
                }
                ++index2;
            } else if(nums1[index1] < nums2[index2]){
                while(index1 < nums1.length  - 1&& nums1[index1] == nums1[index1 + 1]){
                    ++index1;
                }
                ++index1;
            } else{
                while(index2 < nums2.length  - 1&& nums2[index2] == nums2[index2 + 1]){
                    ++index2;
                }
                ++index2;
            }
        }
        int[] ans = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            ans[i] = intersection.get(i);
        }
        return ans;
    }
}
