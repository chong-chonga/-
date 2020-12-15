package cn.datastructure.structure;

import org.junit.Test;

import java.util.LinkedList;

//    所有的值都在 [0, 1000000]的范围内。
//    操作的总数目在[1, 10000]范围内。
public class MyHashSet {
    static class MyList {
        private LinkedList<Integer> list;

        public MyList() {
            this.list = new LinkedList<>();
        }

        public void delete(Integer key){
            list.remove(key);
        }

        /**
         * 之所以不使用add()方法, 是因为add()相当于addLast()方法,将元素插入至链表的末尾
         * @param key
         */
        public void insert(Integer key){
            int index = this.list.indexOf(key);
            if (index == -1) {
                this.list.addFirst(key);
            }
        }

        public boolean hasKey(Integer key){
            return -1 != list.indexOf(key);
        }
    }

    private int arraySize;
    private MyList[] lists;

    /**
     * Initialize your data.txt structure here.
     */
    public MyHashSet() {
        this.arraySize = 769;
        lists = new MyList[this.arraySize];
        for (int i = 0; i < this.arraySize; i++) {
            lists[i] = new MyList();
        }
    }

    public void add(int key) {
        int code = getHashCode(key);
        lists[code].insert(key);
    }

    public int getHashCode(int key){
        return key % this.arraySize;
    }

    public void remove(int key) {
        int code = getHashCode(key);
        lists[code].delete(key);

    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int code = getHashCode(key);
        return lists[code].hasKey(key);
    }

    @Test
    public void testMyHashSet() {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));
        hashSet.add(2);
        System.out.println(hashSet.contains(2));
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));

    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */



