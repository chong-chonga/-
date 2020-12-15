package cn.leetcode.array;

/**
 * @author 悠一木碧
 * 给定一个整数数组 A，返回 A 中最长等差子序列的长度。
 *
 * 回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中 0 <= i_1 < i_2 < ... < i_k <= A.length - 1。
 * 并且如果 B[i+1] - B[i]( 0 <= i < B.length - 1) 的值都相同，那么序列 B 是等差的。
 * 2 <= A.length <= 2000
 * 0 <= A[i] <= 10000
 */
public class LongestArithSeqLength {
    public int longestArithSeqLength(int[] A) {
        int longestLength = 2;
        int startIndex = 0;
        for(; startIndex < A.length - 1; startIndex++){
            if(longestLength >= A.length - startIndex){
                return longestLength;
            }
            for(int i = startIndex + 1; i < A.length; i++){
                int tolerance = A[i] - A[startIndex];
                int temp = A[i];
                int count = 2;
                for(int j = i + 1; j < A.length; j++){
                    if(A[j] - temp == tolerance){
                        count++;
                        temp = A[j];
                    }
                }
                if(count >= longestLength){
                    longestLength = count;
                }
            }
        }
        return longestLength;
    }
}
