package cn.leetcode.tree;

/**
 * @author 悠一木碧
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 */
public class ListToBST {
    static class ListNode {
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

    static class  ArrayInterval{
        int[] arr;
        int leftLimit;
        int rightLimit;

        public ArrayInterval(int left, int right, int[] arr){
            this.leftLimit = left;
            this.rightLimit = right;
            this.arr = arr;
        }

        public int medianIndex(){
            return (leftLimit + rightLimit) / 2;
        }

        public boolean boundaryCoincides() {
            return this.leftLimit == this.rightLimit;
        }
    }

    /**
     * 分治法求解
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        int[] array = createArrayBy(head);
        TreeNode root = buildTreeBy(array);

        return root;
    }

    private int[] createArrayBy(ListNode head) {
        int lengthOfList = getListLength(head);
        int[] array = new int[lengthOfList];
        putListValueIntoArray(head, array);

        return array;
    }

    private void putListValueIntoArray(ListNode head, int[] arr) {
        ListNode temp = head;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp.val;
            temp = temp.next;
        }
    }

    private int getListLength(ListNode head) {
        int lengthOfList = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            lengthOfList++;
        }
        return lengthOfList;
    }

    private TreeNode buildTreeBy(int[] array) {
        return createTree(new ArrayInterval(0, array.length, array));
    }

    /**
     * 在此方法中, 有两次递归调用, 区间的选择很重要,由于我们采用的是medianIndex的值
     * 所以第二次递归中, 我们将区间更改为(medianIndex + 1, rightLimit)
     * @param interval
     * @return
     */
    private TreeNode createTree(ArrayInterval interval) {
        if (interval.boundaryCoincides()) {
            return null;
        }
        int medianIndex = interval.medianIndex();
        int[] arr = interval.arr;
        TreeNode root = new TreeNode(arr[medianIndex]);
        root.left = createTree(new ArrayInterval(interval.leftLimit, medianIndex, arr));
        root.right = createTree(new ArrayInterval(medianIndex + 1, interval.rightLimit, arr));
        return root;

    }

}
