package cn.leetcode.array;

/**
 * @author 悠一木碧
 */
public class SortArrayByParity {
    /**
     * 题目: 按奇偶排序数组
     * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        int frontPointer = 0;
        int rearPointer = A.length - 1;
        while (frontPointer < rearPointer) {
            if (A[frontPointer] % 2 == 1 && A[rearPointer] % 2 == 0) {
                exchangeArrayElement(A, frontPointer, rearPointer);
            }
            if (A[rearPointer] % 2 == 0) {
                frontPointer++;
            }
            if (A[rearPointer] % 2 == 1) {
                rearPointer--;
            }
        }
        return A;
    }

    private void exchangeArrayElement(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
