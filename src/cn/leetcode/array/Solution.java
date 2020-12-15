package cn.leetcode.array;

/**
 * @author 悠一木碧
 * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
 * 1 <= arr.length <= 10^5
 * length不可能为0
 * 1 <= arr[i] <= 10^4
 * 1 <= k <= arr.length
 * 0 <= threshold <= 10^4
 *
 * 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
 */
public class Solution {
/*    *//**
     * 暴力解法
     * @param arr
     * @param k
     * @param threshold
     * @return
     *//*
    public int numOfSubarrays(int[] arr, int k, int threshold) {

//        平均数大于等于threshold, 也就是总和大于k*threshold的子数组和
//        k = length, 一次循环, k = length - 1 两次循环

        int nums = 0;
        int sum = 0;
        final int summary = k * threshold;
        for(int i = 0; i <= arr.length - k; i++){
            for (int j = 0; j < k; j++){
                sum += arr[i + j];
                if(sum >= summary){
                    nums++;
                    break;
                }
            }
            sum = 0;
        }
        return nums;
    }*/

    public int numOfSubarrays(int[] arr, int k, int threshold) {

//        平均数大于等于threshold, 也就是总和大于k*threshold的子数组和
//        k = length, 一次循环, k = length - 1 两次循环
//        使用S[]数组存储前n项和, 通过对S数组进行相减进行操作
        int nums = 0;
        final int summary = k * threshold;
        int[] S = new int[arr.length];
        S[0] = arr[0];

        for(int i = 1; i < arr.length; i++){
            S[i] = S[i - 1] + arr[i];
        }

        if(S[k - 1] >= summary ){
            nums++;
        }
//        取k项和进行比较
        for (int i = 1; i <= arr.length - k; i++) {
            if(S[k + i - 1] - S[i-1] >= summary){
                nums++;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
//        int[] arr = {
//                2,2,2,2,5,5,5,8};
//        numOfSubarrays(arr, 3, 4);
    }
}
