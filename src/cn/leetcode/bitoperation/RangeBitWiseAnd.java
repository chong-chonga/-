package cn.leetcode.bitoperation;

/**
 * @author 悠一木碧
 */
public class RangeBitWiseAnd {
    /**
     * 编号: 201
     * 将m, n分别转换为2进制表示, 从最高位往最低位进行比较
     * 寻找到第一个不同的位, 从这个位到最后一位, 全部置换为0
     * 原因: 找到的第一个不同的最高位时, 以这一位为一个标志点, 从最低位到这个位, 会依次出现0/1变换
     * 所以对这些位, 只要出现一个0, 这个位运算中, 就必定是0
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int[] num1 = new int[32];
        int[] num2 = new int[32];
        int index1, index2;
        index2 = index1 = 31;

        int temp = m;
        while (temp > 0) {
            num1[index1--] = temp % 2;
            temp /= 2;
        }
        temp = n;
        while (temp > 0) {
            num2[index2--] = temp % 2;
            temp /= 2;
        }

        int flag = 32;
        for(int i = index2 + 1; i < 32; i++){
            if(num1[i] != num2[i]){
                flag = i;
                break;
            }
        }

        for(int i = flag; i < 32; i++){
            num2[i] = 0;
        }


        int ans = 0;
        for (int i = 31; i > index1; i--) {
            if (num2[i] != 0) {
                ans += Math.pow(2, 31 - i);
            }
        }
        return ans;
    }
}
