package cn.leetcode.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 悠一木碧
 */
public class MergeTwoLists {

    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode headOfNewList = null;
            ListNode endOfNewList = null;
            while (l1 != null && null != l2) {
                ListNode nextMinimumNode = null;
                if (l1.val <= l2.val) {
                    nextMinimumNode = l1;
                    l1 = l1.next;
                } else {
                    nextMinimumNode = l2;
                    l2 = l2.next;
                }
                if (null == headOfNewList) {
                    endOfNewList = headOfNewList = nextMinimumNode;
                } else {
                    endOfNewList.next = nextMinimumNode;
                    endOfNewList = endOfNewList.next;
                }
            }
            if (null != l1) {
                endOfNewList = l1;
            } else {
                endOfNewList = l2;
            }
            return headOfNewList;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        go(root, result);
        return result;
    }

    public void go(TreeNode node, List<Integer> result) {
        if (null != node) {
            result.add(node.val);
            if (node.left != null) {
                go(node.left, result);
            }
            if (node.right != null) {
                go(node.right, result);
            }
        }

    }



}
