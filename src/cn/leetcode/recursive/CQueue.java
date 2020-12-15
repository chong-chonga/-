package cn.leetcode.recursive;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 */
public class CQueue {
    private Stack<Integer> addingStack;
    private Stack<Integer> deletingStack;

    public CQueue() {
        addingStack = new Stack<>();
        deletingStack = new Stack<>();
    }

    public void appendTail(int value) {
        addingStack.add(value);
    }

    /**
     * 使用两个栈实现队列, 队列是先进先出,要删除的时候, 将原栈中的数据依次加入到另外一个栈中
     * 使得最先放入的数据重新回到栈顶上, 这样remove()之后, 就能实现先进先出了
     * @return
     */
    public int deleteHead() {
        if(deletingStack.empty())
        {
            int size = addingStack.size();
            if(0 == size)
            {
                return -1;
            }
            else
            {
                Integer integer;
                for(int i = 0; i < size; i++){
                    integer = addingStack.pop();
                    deletingStack.push(integer);
                }
            }
        }
        return deletingStack.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
