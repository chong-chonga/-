package cn.leetcode.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 悠一木碧
 */
public class DeepCloneMap {
        static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
     * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
     * 思路: 使用深度优先遍历
     * 由于需要深度复制整个图, 所以一个节点只能创建一次, 并且由于邻居是相互的,
     * 所以在通过List获取邻居的时候, 需要设立好访问条件, 否则会进入到死循环
     * 由以上两个原因, 我们需要存储好创建的新节点, 并且得知道该节点是否已经完成了复制
     * 使用HashMap<K, V>结构能够完成上述两件事情
     * 最开始, 我们先创建1号节点, 然后对原图中1号的邻居节点进行遍历, 当HashMap中没有该节点时, 就说明这个节点还没有被复制过
     * 所以我们在递归调用前, 先new一个节点并加入到map中, ,然后对新的结点及其邻居进行遍历, 同时我们还得往其List中加入节点
     * 加入的节点有两种选择: 1.HashMap中获取 2.new一个, 当第一种没有获取到的时候, 我们采用第二种方式, 这样就保证了图中的每一个结点只会被创建一次
     *
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        if (null == node) {
            return null;
        }
        Node first = new Node(node.val);
        Map<Integer, Node> map = new HashMap<>();
        map.put(first.val, first);
        copyGraph(first, node.neighbors, map);

        return first;
    }

    /**
     * 通过循环遍历当前节点的邻居集合List, 判断该邻居节点是否被复制过
     * 如果复制过, 说明在map中可以找到,获取该节点, 将其加入到当前深度复制节点中的List中去
     * 如果没有复制过, 说明需要new一个并对该节点进行深度复制, 然后再将其加入到List中去
     *
     * @param currentNode 当前深度复制的节点
     * @param neighbors   当前结点的邻居节点集合
     * @param map         哈希表, 用于存储复制了的节点的map
     */
    private void copyGraph(Node currentNode, List<Node> neighbors,
                           Map<Integer, Node> map) {
        if (null != neighbors) {
            Node newNode;
            for (Node neighbor : neighbors) {
                if (!map.containsKey(neighbor.val)) {
                    newNode = new Node(neighbor.val);
                    map.put(neighbor.val, newNode);
                    copyGraph(newNode, neighbor.neighbors, map);
                } else {
                    newNode = map.get(neighbor.val);
                }
                currentNode.neighbors.add(newNode);
            }
        }

    }
}
