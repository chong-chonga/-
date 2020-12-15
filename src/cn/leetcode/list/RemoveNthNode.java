package cn.leetcode.list;

/**
 * @author 悠一木碧
 * 题目编号: 19
 */
public class RemoveNthNode {
    private int target;
    private ListNode head;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        this.head = head;
        this.target = n;
        remove(null, head);
        return this.head;
    }

    private int remove(ListNode fontNode, ListNode currentNode){
        if(currentNode.next != null){
            int index = remove(currentNode, currentNode.next);
            if(index == target){
                if(fontNode == null){
                    this.head = currentNode.next;
                } else{
                    fontNode.next = currentNode.next;
                }
                return target + 1;
            } else{
                return index + 1;
            }
        } else{
            if(1 == target){
                if(fontNode == null){
                    this.head = null;
                } else{
                    fontNode.next = null;
                }
            }
            return 2;
        }
    }
}
