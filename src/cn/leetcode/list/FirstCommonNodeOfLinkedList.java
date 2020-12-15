package cn.leetcode.list;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 */
public class FirstCommonNodeOfLinkedList {

    public int getLength(ListNode head){
        int len = 0;
        while(head != null){
            head = head.next;
            ++len;
        }
        return len;
    }

    /**
     * 先判断两条链表的长度, 找到最长的那条链表, 让其先走(lenB - lenA/ lenA - lenB)步
     * 使headA和headB位于相同的相对位置上
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = getLength(headA);
        int lenB = getLength(headB);
        if(lenA >= lenB)
        {
            for(int i = 0; i < lenA - lenB; i++){
                headA = headA.next;
            }
        }
        else
        {
            for(int i = 0; i < lenB - lenA; i++){
                headB = headB.next;
            }
        }
        while(headA != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    /**
     * 双指针法解决
     * 此方法是同时移动, 所以确保了移动的距离是相同的, 如果一个人先到达了终点, 那么就继续走另外一个人路
     * 也就是说, 如果你先跑完了200米, 你的队友跑400米, 你继续跑他跑的400米, 同时, 如果队友跑完了400米
     * 再跑你的200米, 所以你们必定会在一个地方相遇----如果没有交点, 那么即使同样走了2圈, 也不会相遇
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int count = 0;
        if(null == headA || null == headB) { return null; }
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != tempB)
        {
            tempA = tempA.next;
            tempB = tempB.next;
            if(tempA == null){
                tempA = headB;
                ++count;
            }
            if(null == tempB){
                tempB = headA;
                ++count;
            }
            if(count > 2){
                return null;
            }
        }
        return tempA;
    }
}
