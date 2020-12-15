package cn.leetcode.tree.traversal;

import cn.leetcode.tree.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 悠一木碧
 * 题目编号: 94
 */
public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverseByRecursive(root, ans);
        return ans;
    }

    private void traverseByRecursive(TreeNode root, List<Integer> ans) {
        if(null != root){
            if(root.left != null){
                traverseByRecursive(root.left, ans);
            }
            ans.add(root.val);
            if(root.right != null){
                traverseByRecursive(root.right, ans);
            }
        }

    }

    /**
     * Morris算法, 当遍历只有右子节点的链表的时候, 此方法不会做任何的标记, 一直遍历到尾
     * 由于中序遍历需要先遍历好左子节点, 所以当有子节点的时候, 会优先跳到左子节点
     * 但是需要有一个回到原节点的方法, 所以当我们遍历好左子节点时, 就应当从左子节点回到原节点
     * 为什么是左子树中的最右结点呢?
     * @param root
     * @return
     */
    public List<Integer> traverseByIteration(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode current = root;

        while(null != current){
            if(null != current.left){
                TreeNode node = current.left;
                while(null != node.right && node.right != current){
                    node = node.right;
                }
                if(null == node.right){
                    node.right = current;
                    current = current.left;
                } else{
                    ans.add(current.val);
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


}
