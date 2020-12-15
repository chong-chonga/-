package cn.datastructure.structure.tree;

/**
 * @author 悠一木碧
 * 红黑树实现:
 * 基于了2-3查找树的思想:
 * 任意空链接到根节点的路径长度都是相等的
 * 4-结点变换为3-结点时, 树的高度不会发生变化, 只有当根节点是临时的4-结点时, 分解根节点后, 树的高度+1
 * 普通二叉查找树是自顶向下生长的, 2-3查找树的自底向上生长的
 * 且:
 * 红链接均为左连接
 * 没有任何一个结点同时与两个红链接相连
 * 任意空链接到根节点的路径经过相同的黑链接
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private int size;
    private final boolean RED = true;
    private final boolean BLACK = false;

    private class Node{
        public Key key;
        public Value value;
        public Node left;
        public Node right;
//        用来标识父节点指向自己链接的颜色
        public boolean color;

        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }

        public Node() {
        }

    }



    public void put(Key key, Value value){
        root = put(root, key, value);
        this.root.color = BLACK;
    }

    private Node put(Node node, Key key, Value value){
        if(null == node){
            size++;
            return new Node(key, value, null, null, BLACK);
        }
        if(key.compareTo(node.key) < 0){
            node.left = put(node.left, key, value);
        } else if(key.compareTo(node.key) > 0){
            node.right = put(node.right, key, value);
        } else{
            node.value = value;
        }

        if(isRed(node.right) && !isRed(node.left)){
            rotateLeft(node);
        }
        if(isRed(node.left) && isRed(node.left.left)){
            rotateRight(node);
        }
        if(isRed(node.left) && isRed(node.right)){
            colorInversion(node);
        }
        return node;
    }

    /**
     * 左旋操作,
     * @param head
     */
    private Node rotateLeft(Node head){
        Node rightSon = head.right;
        head.right = rightSon.left;
        rightSon.left = head;
        rightSon.color = head.color;
        head.color = RED;
        return rightSon;
    }

    /**
     * 右旋操作
     * @param head
     * @return
     */
    private Node rotateRight(Node head){
        Node leftSon = head.left;
        head.left = leftSon.right;
        leftSon.right = head;
        leftSon.color = head.color;
        head.color = RED;
        return leftSon;
    }

    /**
     * 空链接默认为黑色
     * @param node
     * @return
     */
    private boolean isRed(Node node){
        if(null == node){
            return false;
        }
        return node.color == RED;
    }


    /**
     * 相当于拆分掉4-结点, 在红黑树中, 临时的4-结点相当于当前结点的左右链接都是红色
     * @param node
     */
    private void colorInversion(Node node){
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }




    public Value get(Key key){
        return get(root, key);
    }

    private Value get(Node node, Key key){
        if(null == node){
            return null;
        }

        int res = key.compareTo(node.key);

        if(res > 0){
            return get(node.right, key);
        } else if(res < 0){
            return get(node.left, key);
        } else{
            return node.value;
        }
    }



    public int size(){
        return size;
    }

}
