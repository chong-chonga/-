package cn.leetcode.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author 悠一木碧
 */
public class SymmetricTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 判断二叉树是否是对称的
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        } else if (null == root.left && null == root.right) {
            return true;
        } else if (null == root.left || null == root.right) {
            return false;
        }
        ArrayList<Integer> leftArray = new ArrayList<>();
        ArrayList<Integer> rightArray = new ArrayList<>();
        go(root.left, leftArray);
        go1(root.right, rightArray);
        if(leftArray.size() != rightArray.size()){
            return false;
        }
        int len = leftArray.size();
        for(int i = 0; i < len; i++){
            if(!Objects.equals(leftArray.get(i), rightArray.get(i))){
                return false;
            }
        }
        return true;
    }

    public static void go(TreeNode root, ArrayList<Integer> result) {
        if (root.left != null) {
            go(root.left, result);
        } else{
            result.add(null);
        }
        if (root.right != null) {
            go(root.right, result);
        }else{
            result.add(null);
        }
        result.add(root.val);
    }

    public static void go1(TreeNode root, ArrayList<Integer> result) {
        if (root.right != null) {
            go1(root.right, result);
        }else{
            result.add(null);
        }
        if (root.left != null) {
            go1(root.left, result);
        }else{
            result.add(null);
        }
        result.add(root.val);
    }

    public static void main(String[] args) {
       TreeNode head = new TreeNode(1);
       head.left = new TreeNode(2);
       head.right = new TreeNode(2);
       head.left.left = new TreeNode(3);
       head.left.right = new TreeNode(4);
       head.right.right = new TreeNode(3);
       head.right.left = new TreeNode(4);
       head.left.left.left = new TreeNode(1);
       head.right.right.right = new TreeNode(1);
        System.out.println(isSymmetric(head));

    }

}
