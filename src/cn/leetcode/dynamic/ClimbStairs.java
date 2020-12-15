package cn.leetcode.dynamic;

import org.junit.Test;

/**
 * @author 悠一木碧
 */
public class ClimbStairs {
    private int numberOfSolutions = 1;
    /**
     * 每次可以走1层, 也可以走两层, 走不同的路, 会对楼梯层数产生不同的影响
     * 每次走到的层数可以看成一个新的起点, 这样子走1层/2层, 将目标层数-1/-2, 这样的话, 就相当于求解更低楼层的答案
     * 自顶向下看, 走到n层楼梯只有两种方法---从n-1/n-2层走到, 那么走到n-1/n-2的方法总数, 就是走到n层方法总数
     * 由于递归拆分计算需要的时间比较长, 我们可以直接将其转化为迭代计算, fn = fn-1 + fn-2
     * 走到2层, 有2种方法, 走到1层只有1种方法, 走到第三层 = 走到2层 + 走到1层
     * 走到4层= 走到3层 + 走到2层, 走到5层= 走到4层 + 走到3层.......
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        } else if(2 == n){
            return 2;
        } else {
            int n1 = 1;
            int n2 = 2;
            int current = 0;
            for (int i = 0; i < n - 2; i++) {
                current = n1 + n2;
                n1 = n2;
                n2 = current;
            }
            return current;
        }
    }

    /**
     *
     * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
     * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
     * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯
     * 倒数两个阶梯的最优消耗就是它们本身, 因为通过这两个阶梯可以直接上到最顶层, 不需要其他阶梯
     * 从倒数第三个阶梯开始, 选择后面两个阶梯中消耗最少的那个, 然后将消耗量与自身消耗量相加得到当前阶梯的最优消耗
     * 后面的阶梯重复这个选择的步骤, 然后最优的消耗就是索引为0,1的数值最小的那个
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        for (int i = cost.length - 3; i >= 0; i--){
            cost[i] = cost[i] + Math.min(cost[i + 1], cost[i +2]);
        }
        return Math.min(cost[0], cost[1]);
    }

    /**
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     *
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 0 ≤ N ≤ 30
     * @param N
     * @return
     */
    public int fib(int N) {
        if(0 == N){
            return 0;
        } else if(1 == N){
            return 1;
        } else{
            int f1 = 0;
            int f2 = 1;
            int fn = 0;
            for(int n = 2; n <= N; n++){
                fn = f1 + f2;
                f1 = f2;
                f2 = fn;
            }
            return fn;
        }
    }

    @Test
    public void testClimbStairs(){
        System.out.println(climbStairs(44));
    }
}
