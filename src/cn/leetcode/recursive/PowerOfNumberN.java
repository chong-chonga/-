package cn.leetcode.recursive;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 迭代乘法会消耗大量时间, 如果拆分下来, 可以简化
 * n只能被2整除或者余1, 1/2 在Java中取0, 那么就可以一直递归下去, 将n一次一次除2
 * 余1的话,就再乘上x, 否则就直接拆分
 */

public class PowerOfNumberN{
    public  double pow1(double x, int n){
        if(0 == n){
            return 1.0;
        }
        double y = pow1(x, n/2);
        if(n % 2 == 0){
            return y * y;
        }
        else{
            return y * y * x;
        }
    }
    public double myPow(double x, int n) {
        double temp = pow1(x, n);
        if(n < 0){
            return 1.0/temp;
        }
        else{
            return temp;
        }
    }
}
