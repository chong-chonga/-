package cn.leetcode.list;

import org.jetbrains.annotations.NotNull;

/**
 * @author 悠一木碧
 * 编号: 203
 */
public class RemoveSpecificElements {

    private int targetVal;

    public ListNode removeElements(ListNode head, int val) {
        ListNode newListHead;

        setTargetValAs(val);
        newListHead = getFirstNodeNotHasTargetValIn(head);
        if(newListHead != null){
            deleteNodesContainTargetValueAfter(newListHead);
        }

        return newListHead;
    }

    private void setTargetValAs(int val) {
        this.targetVal = val;
    }

    private ListNode getFirstNodeNotHasTargetValIn(ListNode head){
        while(null != head && containsTargetVal(head)){
            head = head.next;
        }
        return head;
    }

    private void deleteNodesContainTargetValueAfter(@NotNull ListNode node) {
        while(null != node.next){
            if(containsTargetVal(node.next)){
                node.next = getNodeNotHasTargetValAfter(node.next);
            }
            node = node.next;
            if(null == node){
                break;
            }
        }
    }

    private ListNode getNodeNotHasTargetValAfter(ListNode node){
        while (node != null && containsTargetVal(node)) {
            node = node.next;
        }
        return node;
    }

    private boolean containsTargetVal(ListNode node){
        return node.val == targetVal;
    }


}
