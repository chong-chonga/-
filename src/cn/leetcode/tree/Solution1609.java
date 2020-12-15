package cn.leetcode.tree;

import cn.leetcode.tree.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 悠一木碧
 * 题目编号: 1609
 */
public class Solution1609 {

    public boolean isEvenOddTree(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        if (null != root) {
            nodes.add(root);
        }
        return traverse(nodes, 0);
    }


    public boolean traverse(List<TreeNode> nodes, int level) {
        if (null == nodes || 0 == nodes.size()) {
            return true;
        }
        int font;
        List<TreeNode> newNodes = new ArrayList<>();
        if (level % 2 == 0) {
            font = Integer.MIN_VALUE;
            for (TreeNode node : nodes) {
                if ((node.val <= font) || (node.val % 2 == 0)) {
                    return false;
                }
                font = node.val;
                if (null != node.left) {
                    newNodes.add(node.left);
                }
                if (null != node.right) {
                    newNodes.add(node.right);
                }

            }
        } else{
            font = Integer.MAX_VALUE;
            for (TreeNode node : nodes) {
                if ((node.val >= font) || (node.val % 2 != 0)) {
                    return false;
                }
                font = node.val;
                if (null != node.left) {
                    newNodes.add(node.left);
                }
                if (null != node.right) {
                    newNodes.add(node.right);
                }

            }
        }
        if(0 == newNodes.size()){
            return true;
        } else{
            return traverse(newNodes, level + 1);
        }
    }
}
