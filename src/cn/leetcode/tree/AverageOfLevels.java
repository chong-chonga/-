package cn.leetcode.tree;

import org.junit.Test;

import java.util.*;

/**
 * @author 悠一木碧
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组
 */
public class AverageOfLevels {
    private List<TreeNode> nodesOfCurrentLayer;
    private TreeNode treeRoot;

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        this.treeRoot = root;
        List<Double> result = new ArrayList<>();
        nodesOfCurrentLayer = new ArrayList<>();
        if (!emptyTree()) {
            nodesOfCurrentLayer.add(root);
        }
        calculateAverageValuesAndPutInto(result);
        return result;
    }

    private boolean emptyTree() {
        return this.treeRoot == null;
    }

    private void calculateAverageValuesAndPutInto(List<Double> result) {
        if (noMoreNodes()) {
            return;
        }
        addAverageValueInto(result);
        stepToTheNextLevel();
        calculateAverageValuesAndPutInto(result);
    }

    private boolean noMoreNodes() {
        return nodesOfCurrentLayer == null || nodesOfCurrentLayer.isEmpty();
    }

    private void addAverageValueInto(List<Double> result) {
        double sum = getSumOfCurrentLayerNodes();
        result.add(sum / nodesOfCurrentLayer.size());
    }

    private double getSumOfCurrentLayerNodes() {
        double sum = 0;
        for (TreeNode treeNode : nodesOfCurrentLayer) {
            sum += treeNode.val;
        }
        return sum;
    }

    private void stepToTheNextLevel() {
        List<TreeNode> nodesOfNextLayer = new ArrayList<>();
        for (TreeNode treeNode : nodesOfCurrentLayer) {
            if (treeNode.left != null) {
                nodesOfNextLayer.add(treeNode.left);
            }
            if (treeNode.right != null) {
                nodesOfNextLayer.add(treeNode.right);
            }
        }
        this.nodesOfCurrentLayer = nodesOfNextLayer;
    }

}
