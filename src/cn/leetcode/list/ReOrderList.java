package cn.leetcode.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 悠一木碧
 */
public class ReOrderList {
    public void reorderList(ListNode head) {
//        用数组存储所有的结点, 然后使用双指针, 第一个指针指向前面的结点, 当左右指针重合时, 退出
//        You may not modify the values in the list's nodes, only nodes itself may be changed.

        if(null == head || head.next == null){
            return;
        }
        List<ListNode> nodes = new ArrayList<>();
        while(head != null){
            nodes.add(head);
            head = head.next;
        }

        int index1 = 0;
        int index2 = nodes.size() - 1;
        ListNode node1 = null;
        ListNode node2 = null;
        ListNode fontNode = null;

        while(index1 < index2){
            node1 = nodes.get(index1);
            node2 = nodes.get(index2);
            if(fontNode != null){
                fontNode.next = node1;
            }
            node1.next = node2;
            ++index1;
            --index2;
            fontNode = node2;
        }
        if(index1 == index2){
            node2 = nodes.get(index1);
            fontNode.next = node2;
        }
        node2.next = null;
    }
}
