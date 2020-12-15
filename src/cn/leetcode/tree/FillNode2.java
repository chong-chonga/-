package cn.leetcode.tree;

import cn.leetcode.lcp.CalculateRobot;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 悠一木碧
 * 编号: 117
 */
public class FillNode2 {
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if(null == root){
            return null;
        }
        List<Node> currentNodes = new ArrayList<>();
        currentNodes.add(root);
        fill(currentNodes);
        return root;
    }

    private void fill(List<Node> currentNodes){
        if(0 != currentNodes.size()){
            List<Node> nodes = new ArrayList<>();
            Node first;
            for(int i = 0; i < currentNodes.size(); i++){
                first = currentNodes.get(i);
                if(first.left != null){
                    nodes.add(first.left);
                }
                if(first.right != null){
                    nodes.add(first.right);
                }
                if(i != nodes.size() - 1){
                    first.next = currentNodes.get(i + 1);
                } else{
                    first.next = null;
                }
            }
            fill(nodes);
        }
    }
}
