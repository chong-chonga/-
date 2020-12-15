package cn.leetcode.clockIn.october;

import cn.leetcode.tree.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 悠一木碧
 * 题目编号: 144
 */
public class Solution27 {
    private List<Integer> ans;
    public List<Integer> preorderTraversal(TreeNode root) {
        this.ans = new ArrayList<>();

        TreeNode current = root;

        while(!isNULL(current)){
            if(!isNULL(current.left)){
                TreeNode node = current.left;
                while(node.right != null && current != node.right){
                    node = node.right;
                }
                if(isNULL(node.right)){
                    setBackPathAndAddVal(node, current);
                    current = current.left;
                } else{
                    node.right = null;
                    current = current.right;
                }

            } else{
                ans.add(current.val);
                current = current.right;
            }
        }
        return ans;
    }

    private boolean isNULL(TreeNode node){
        return null == node;
    }

    private void setBackPathAndAddVal(TreeNode start, TreeNode target){
        start.right = target;
        ans.add(target.val);
    }
}
