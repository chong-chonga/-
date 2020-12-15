package cn.datastructure.structure.list.test;

import cn.datastructure.structure.domain.Node;
import cn.datastructure.structure.list.FastSlowPointers;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 悠一木碧
 */
public class ListTest {
    private Node<Integer> head;

    @Before
    public void init(){
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> fourth = new Node<>(4);
        Node<Integer> fifth = new Node<>(5);
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = first;
        head = first;
    }

    @Test
    public void testGetMid(){
        FastSlowPointers<Integer> fastSlowPointers = new FastSlowPointers<>();
        System.out.println(fastSlowPointers.getMid(head));
    }

    @Test
    public void testHasLoop(){
        FastSlowPointers<Integer> fastSlowPointers = new FastSlowPointers<>();
        System.out.println(fastSlowPointers.hasLoop(head));
    }

    @Test
    public void testGetEntrance(){
        FastSlowPointers<Integer> fastSlowPointers = new FastSlowPointers<>();
        System.out.println("环的入口结点是" + fastSlowPointers.getEntrance(head).value);
    }
}
