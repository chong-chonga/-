package cn.leetcode.list;

/**
 * @author 悠一木碧
 * 题目编号: 234
 * 初始都是走1步, 慢指针走 n + 1步(n = 0,1,2,3...) 快指针走了 (2n + 1)步
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if(null == head){
            return true;
        }

        ListNode slow, fast;
        slow = fast = head;
        while(null != fast.next && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverseList(slow.next);
        ListNode font, back;
        font = head;
        back = slow.next;
        while(back != null){
            if(font.val != back.val){
                reverseList(slow.next);
                return false;
            }
            font = font.next;
            back = back.next;
        }
        reverseList(slow.next);
        return true;

    }


    private ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode currentNode = head;
        ListNode nextNode;
        while(null != currentNode){
            nextNode = currentNode.next;
            currentNode.next = preNode;

            preNode = currentNode;
            currentNode = nextNode;
        }
        return preNode;

    }


}
