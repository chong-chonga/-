package cn.datastructure.structure.list;

import cn.datastructure.structure.domain.Node;

/**
 * @author 悠一木碧
 * 快慢指针类, 用于解决链表的一些问题, 比如获取中间值, 判断是否含有环路
 * 规定快指针走的路程是慢指针的两倍
 * 判断是否含有环路: 快指针走的路程是慢指针的两倍, 如果没有环路, 那么快指针会走到末尾, 或者null
 * 如果有环路, 快指针都比满指针多一步, 所以最终肯定会相遇, 相遇即代表有环路
 */
public class FastSlowPointers<E> {

    /**
     * 获取中间结点的值----对非循环链表可用
     * @param head 此方法需要一个参数, 该参数为链表的头结点
     * @return 此方法会返回中间结点的值
     */
    public E getMid(Node<E> head){
        if(null == head || hasLoop(head)){
            return null;
        }
        Node<E> slow = head;
        Node<E> fast = head;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.value;
    }

    /**
     * 判断链表是否含有"环"
     * @param head 此方法需要一个参数, 该参数为链表的头结点
     * @return 返回含有环的真值
     */
    public boolean hasLoop(Node<E> head){
        if(null == head){
            return false;
        }
        Node<E> slow = head;
        Node<E> fast = head;

        while(null != fast && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    /**
     * 获取有环链表的入口结点
     * @param head 此方法需要一个参数, 该参数为链表的头结点
     * @return 如果有环, 返回环的入口结点, 否则返回null
     */
    public Node<E> getEntrance(Node<E> head){
        if(null == head){
            return null;
        }
        Node<E> slow = head;
        Node<E> fast = head;

        while(null != fast && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                Node<E> entrance = head;
                while(entrance != slow){
                    entrance = entrance.next;
                    slow = slow.next;
                }
                return entrance;
            }
        }
        return null;
    }
}
