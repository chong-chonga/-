package cn.leetcode.clockIn.november;

import cn.leetcode.list.ListNode;

import java.time.LocalDate;

/**
 * @author 悠一木碧
 * 题目编号:328 奇偶链表
 */
public class Solution14 {
    public ListNode oddEvenList(ListNode head) {
        if(null == head || null == head.next){
            return head;
        }
        ListNode oddDigits = head;
        ListNode firstEvenNode = head.next;
        ListNode lastOdd = oddDigits;
        ListNode lastEven = null;
        while(true){
            if(oddDigits.next == null){
//                奇数号结点是最后一个
                break;
            }
            oddDigits = oddDigits.next;
            if(null == lastEven){
                lastEven = firstEvenNode;
            } else{
                lastEven.next = oddDigits;
                lastEven = oddDigits;
            }
            if(null == oddDigits.next){
//                偶数号结点是最后一个
                break;
            } else{
                oddDigits = oddDigits.next;
            }
            lastOdd.next = oddDigits;
            lastOdd = oddDigits;
        }
        oddDigits.next = firstEvenNode;
        lastEven.next = null;
        return head;
    }
}
