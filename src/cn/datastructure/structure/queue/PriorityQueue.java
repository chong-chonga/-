package cn.datastructure.structure.queue;

/**
 * @author 悠一木碧
 * 最大堆实现优先队列
 */
public class PriorityQueue <T extends Comparable<T>>{
    private T[] items;
    private int len;

    public PriorityQueue(int capacity){
        items = (T[]) new Comparable[capacity + 1];
        this.len = 0;
    }

    public boolean empty(){
        return 0 == len;
    }

    public int size(){
        return len;
    }

    private boolean less(int index1, int index2){
        return items[index1].compareTo(items[index2]) < 0;
    }

    private void exchange(int index1, int index2){
        T temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    public void push(T item){
        if(this.len < this.items.length){
            items[++len] = item;
            swim(len);
        }
    }

    private void swim(int index) {
        int son = index;
        int father;
        while(son > 1){
            father = son / 2;
            if(less(son, father)){
                break;
            } else{
                exchange(son, father);
                son = father;
            }
        }
    }

    public T pop(){
        if(!empty()){
            T val = items[len];
            exchange(1, len);
            --len;
            sink(1);
            return val;
        } else{
            return null;
        }
    }

    private void sink(int i) {
        int max;
        while(i * 2 <= len){
            if(i * 2 + 1 <= len){
                if(less(i * 2, i * 2 + 1)){
                    max = i * 2 + 1;
                } else{
                    max = i * 2;
                }
            } else{
                max = i * 2;
            }
            if(less(max, i)){
                break;
            } else{
                exchange(max, i);
                i = max;
            }
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> myQueue = new PriorityQueue<>(100);
        myQueue.push(1);
        myQueue.push(6);
        myQueue.push(3);
        myQueue.push(9);
        myQueue.push(4);
        System.out.println(myQueue.pop());
    }
}
