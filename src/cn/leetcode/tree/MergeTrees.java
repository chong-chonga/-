package cn.leetcode.tree;

import cn.leetcode.tree.domain.TreeNode;

/**
 * @author 悠一木碧
 * 题目编号: 617
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return add(t1, t2);
    }

    private TreeNode add(TreeNode t1, TreeNode t2){
        if(null == t1){
            return t2;
        } else if(null == t2){
            return t1;
        }

        t1.val += t2.val;
        t1.left = add(t1.left, t2.left);
        t1.right = add(t1.right, t2.right);
        return t1;
    }
}
