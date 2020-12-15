package cn.leetcode.tree;

/**
 * @author 悠一木碧
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class TheMaxDepth {
    private int maxnimum = 1;
      class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    /**
     * 找出二叉树的最大深度, 可以使用递归, 每次深入一层, 传入的参数就大1, 退出一层, 就减1
     * 用一个变量存储历史最大深度, 递归完成后, 返回最大深度即可
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
          if(null == root)
              return 0;
          go(root, 1);
          return maxnimum;
    }

    public void go(TreeNode node, int currentDepth){
          if(null != node.left){
              ++currentDepth;
              go(node.left, currentDepth);
              --currentDepth;
          }
          if(null != node.right){
              ++currentDepth;
              go(node.right, currentDepth);
              --currentDepth;
          }
          if(currentDepth > maxnimum){
              maxnimum = currentDepth;
          }
    }



}
