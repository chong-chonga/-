package cn.leetcode.array;

import org.junit.Test;

/**
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 *
 * 示例 1:
 *
 * 输入: 100
 * 输出: "202"
 * 示例 2:
 *
 * 输入: -7
 * 输出: "-10"
 * 注意: 输入范围是 [-1e7, 1e7] 。
 * 确定了输入范围, 寻找范围内最大的7的n次幂
 * 从最大的7^8次开始往下找, 确定好输入的num值最多大于7的几次方, 从这次开始(flag充当标记)
 * 往下走 如果都比7^n小, 那么就在字符串上加0, 或者加n, flag为false, 说明不能在字符串上加字符
 * 为了确保能够循环完成, 用temp存储7^8, 当temp = 1说明到了个位, 可以退出循环
 * 当num < 0的时候, temp乘上-1即可
 */
public class HexConversion {

    public String convertToBase7(int num) {
        if(isZero(num)){
            return "0";
        }
        int maxNumber = getMaxNumber(10000000);
        StringBuilder stringBuilder = new StringBuilder();
        isNegative(num, stringBuilder);

        boolean startFlag = false;
        int n = 0;
        while(maxNumber > 0){
            if(num >= maxNumber){
                startFlag = true;
            }
            n = num / maxNumber;
            num -= (n * maxNumber);
            if(startFlag){
                stringBuilder.append(n);
            }
            maxNumber /= 7;
        }
        return stringBuilder.toString();
    }

    @Test
    public void testMySolution(){
        int num = 0;
        System.out.println(num + "----转化为7进制后的字符串为----" + convertToBase7(num));
    }

    private int getMaxNumber(int upperNumber){
        int maxNumber = 1;
        while(maxNumber < upperNumber){
            maxNumber *= 7;
        }
        return maxNumber;
    }

    private void isNegative(int num, StringBuilder stringBuilder){
        if(num < 0){
            num *= -1;
            stringBuilder.append('-');
        }
    }


    private boolean isZero(int num){
        return 0 == num;
    }
}
