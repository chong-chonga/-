package cn.leetcode.array;

import java.util.Arrays;

/**
 * @author 悠一木碧
 */
public class ArithmeticProgression {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if(d != (arr[i + 1] - arr[i])){
                return false;
            }
        }
        return true;
    }
}
