package cn.leetcode.clockIn.october;

import cn.leetcode.tree.domain.TreeNode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author 悠一木碧
 * 题目编号: 129
 */
public class Solution29 {
    private int sum;
    public int sumNumbers(TreeNode root) {
        this.sum = 0;
        List<Integer> nums = new ArrayList<>();
        traverse(root, nums);
        return sum;
    }

    private void traverse(TreeNode root, List<Integer> nums) {
        if(root != null){
            nums.add(root.val);
            if(null == root.left && null == root.right){
                calculate(nums);
            } else{
                traverse(root.left, nums);
                traverse(root.right, nums);
            }
            nums.remove(nums.size() - 1);
        }

    }

    private void calculate(List<Integer> nums){
        int len = nums.size();
        System.out.println("执行了");
        for (int num : nums){
            this.sum += (Math.pow(10, len - 1) * num);
            --len;
        }
    }
}
