package cn.datastructure.structure.domain;

/**
 * @author 悠一木碧
 * 结点类
 */
public class Node<T> {
    public T value;
    public Node<T> next;

    public Node(T value){
        this.value = value;
        this.next = null;
    }

    public Node(T value, Node<T> next){
        this.value = value;
        this.next = next;
    }
}
