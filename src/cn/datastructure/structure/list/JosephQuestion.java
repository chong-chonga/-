package cn.datastructure.structure.list;

import cn.datastructure.structure.domain.Node;

import java.security.InvalidParameterException;

/**
 * @author 悠一木碧
 */
public class JosephQuestion {
    /**
     * 创建指定长度大小的循环链表
     * @param len 参数len指定了循环链表的长度
     * @return 返回循环链表的头结点
     */
    public static Node<Integer> getHead(int len){
        if(len <= 0){
            throw new InvalidParameterException("长度不合适!");
        }
        Node<Integer> head = new Node<Integer>(1);
        Node<Integer> pre = head;
        Node<Integer> current = null;
        for(int i = 1; i <= len - 1; i++){
            current = new Node<>(i + 1);
            pre.next = current;
            pre = current;
        }
        if(current != null){
            current.next = head;
        } else{
            head.next = head;
        }
        return head;
    }

    /**
     * 进行约瑟夫问题的解决
     * @param head 循环链表的头结点
     * @param gap 间隔
     * @param len 循环链表的长度
     * @return 返回剩余结点
     */
    public static Node<Integer> getAlive(Node<Integer> head, int gap, int len){
        if(null == head){
            throw new NullPointerException("链表为空!");
        } else if (head.next == head || 1 == len){
            return head;
        } else if (gap <= 0){
            throw new InvalidParameterException("传入参数不合适");
        }
        Node<Integer> current = head;
        Node<Integer> pre = head;
        while(pre.next != current){
            pre = pre.next;
        }

        for(int i = 1; i <= len - 1; i++){
            for(int t = 1; t <= gap - 2; t++){
                current = current.next;
            }
            if(gap != 1){
                pre = current;
                current = current.next;
            }
            pre.next = current.next;
            current.next = null;
            current = pre.next;
        }
        current.next = null;
        return current;
    }

    public static void main(String[] args) {
        Node<Integer> head = getHead(12);
        Node<Integer> alive = getAlive(head, 1, 12);
        System.out.println(alive.value);
        System.out.println(alive.next);

    }

}
