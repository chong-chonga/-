package cn.leetcode.dynamic;

import org.junit.Test;

import java.lang.annotation.Target;

/**
 * @author 悠一木碧
 */
public class MinimumOperations {


    /**
     * 小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves，
     * 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
     * 出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。
     * 每部分树叶数量可以不相等，但均需大于等于 1。
     * 每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕
     *
     * 3 <= leaves.length <= 10^5
     * leaves 中只包含字符 'r' 和字符 'y'
     *
     * @param leaves
     * @return
     */
    public int minimumOperations(String leaves) {
        int[][] array = new int[3][leaves.length()];

        for(int i = 0; i < leaves.length(); i++){
            if(0 == i){
                array[0][i] = (leaves.charAt(0) == 'r' ? 0 : 1);
            } else{
                array[0][i] = array[0][i - 1] + (leaves.charAt(i) == 'r' ? 0 : 1);
            }

            if(i < 1){
                array[1][i] = array[0][i];
            } else{
                array[1][i] = Math.min(array[1][i - 1], array[0][i - 1]) + (leaves.charAt(i) == 'y' ? 0 : 1);
            }

            if(i < 2){
                array[2][i] = array[1][i];
            } else{
                array[2][i] =
                        Math.min(array[2][i - 1], array[1][i - 1]) + (leaves.charAt(i) == 'r' ? 0 : 1);
            }

        }
        return array[2][leaves.length() - 1];

    }



    @Test
    public void testMinimumOperations(){
        minimumOperations("yry");
    }


}
