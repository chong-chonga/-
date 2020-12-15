package cn.leetcode.tree.traversal;

import cn.leetcode.tree.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 悠一木碧
 * 编号:145
 * 二叉树后序遍历
 */
public class PostSequence {
    Stack<TreeNode> nodesToBeTraversed = new Stack<>();
    Stack<Integer> nodesInfo = new Stack<>();
    List<Integer> resultOfTraverse;
    final int untraveled = 1;
    final int leftHasTraveled = 2;
    final int traveled = 3;
    int nodeAttribute;

    public List<Integer> postorderTraversal(TreeNode root) {
        resultOfTraverse = new ArrayList<>();
        traverseByRecursive(root, resultOfTraverse);
        traverseByIteration(root);
        return resultOfTraverse;
    }

    private void traverseByRecursive(TreeNode node, List<Integer> result) {
        if (null != node) {
            if (node.left != null) {
                traverseByRecursive(node.left, result);
            }
            if (null != node.right) {
                traverseByRecursive(node.right, result);
            }
            result.add(node.val);
        }
    }

    private void traverseByIteration(TreeNode root){
        resultOfTraverse = new ArrayList<>();
        if (root != null) {
            pushNodeAsNextTarget(root);
            setNodeAttributeAs(untraveled);
            TreeNode nodeInTraversing;

            while (hasUntraveledNode()) {
                nodeInTraversing = getNextNodeToBeTraversed();

                if (nodeAttributeIs(untraveled)) {
                    if (existsNode(nodeInTraversing.left)) {
                        pushNodeAsNextTarget(nodeInTraversing.left);
                        pushNodeAttribute(leftHasTraveled);
                    } else {
                        setNodeAttributeAs(leftHasTraveled);
                    }
                }

                if (nodeAttributeIs(leftHasTraveled)) {
                    if (existsNode(nodeInTraversing.right)) {
                        pushNodeAsNextTarget(nodeInTraversing.right);
                        pushNodeAttribute(traveled);
                        setNodeAttributeAs(untraveled);
                    } else {
                        setNodeAttributeAs(traveled);
                    }
                }

                if (nodeAttributeIs(traveled)) {
                    addValueToResultAndRemove(nodeInTraversing);
                    if (root != nodeInTraversing) {
                        setNodeAttributeAs(nodesInfo.pop());
                    }
                }

            }
        }

    }

    private void pushNodeAsNextTarget(TreeNode node) {
        nodesToBeTraversed.push(node);
    }

    private void setNodeAttributeAs(int flag) {
        nodeAttribute = flag;
    }

    private boolean hasUntraveledNode() {
        return nodesToBeTraversed.size() != 0;
    }

    private TreeNode getNextNodeToBeTraversed(){
        return nodesToBeTraversed.pop();

    }

    private boolean nodeAttributeIs(int flag) {
        return flag == nodeAttribute;
    }

    private void pushNodeAttribute(int attribute) {
        nodesInfo.push(attribute);
    }

    private boolean existsNode(TreeNode node) {
        return null != node;
    }

    private void addValueToResultAndRemove(TreeNode node) {
        resultOfTraverse.add(node.val);
        nodesToBeTraversed.pop();

    }

}
