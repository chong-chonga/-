package cn.leetcode.array;

public class SumOfLargestSubarray2 {
    static class Helper {
        /*
        从上至下
         表示 [l, r]内以 l 为左端点的最大子段和
         表示 [l, r]内以 r 为右端点的最大子段和
         表示 [l, r]内的最大子段和
         表示 [l, r]的区间和
         */
        public int leftMaxSum;
        public int rightMaxSum;
        public int MaxSum;
        public int totalSum;

        public Helper(int leftMaxSum, int rightMaxSum, int maxSum, int totalSum) {
            this.leftMaxSum = leftMaxSum;
            this.rightMaxSum = rightMaxSum;
            MaxSum = maxSum;
            this.totalSum = totalSum;
        }

        public Helper() {
        }

    }
    /**
     * 查询 array 序列 [l, r][l,r] 区间内的最大子段和
     * 首先最好维护的是 iSum，区间 [l, r][l,r] 的 iSum 就等于「左子区间」的 iSum 加上「右子区间」的 iSum。
     * 这里用到了递归, 将原本的start~end区间, 分成了许多个小区间,直至小区间上下限重合
     * @param start
     * @param end
     * @param array
     * @return
     */
    public Helper get(int start, int end, int[] array){
        if(start == end) { return new Helper(array[start], array[start], array[start], array[start]); }
        int m = (start + end) / 2;
//        将左/右区间分别整合为一个对象
        Helper left = get(start, m, array);
        Helper right = get(m + 1, end, array);
//        返回start ~ end区间的Helper对象
        return push(left, right);
    }
    /**
     * 对于 [l, r]的 leftMaxSum，存在两种可能，它要么等于「左子区间」的 leftMaxSum，
     * 要么等于「左子区间」的 totalSum 加上「右子区间」的 leftMaxSum，二者取大。
     * 对于 [l, r]的 rightMaxSum，同理，它要么等于「右子区间」的 rightMaxSum，
     * 要么等于「右子区间」的 totalSum 加上「左子区间」的 rightMaxSum，二者取大。
     * 当计算好上面的三个量之后，就很好计算 [l, r][l,r] 的 MaxSum 了。
     * 我们可以考虑 [l, r] 的 MaxSum 对应的区间是否跨越 m—它可能不跨越 m，
     * 也就是说 [l, r]的 MaxSum 可能是「左子区间」的 MaxSum 和 「
     * 右子区间」的 MaxSum 中的一个；它也可能跨越 m，可能是「左子区间」的 rightMaxSum 和 「右子区间」的 leftMaxSum 求和。
     * 三者取大
     */
    public Helper push(Helper left, Helper right){
        Helper helper = new Helper();
        helper.leftMaxSum = Math.max(left.leftMaxSum, (left.totalSum + right.leftMaxSum));
        helper.rightMaxSum = Math.max(right.rightMaxSum, left.rightMaxSum + right.totalSum);
        helper.totalSum = left.totalSum + right.totalSum;
        helper.MaxSum = Math.max(Math.max((left.rightMaxSum + right.leftMaxSum), right.MaxSum), left.MaxSum);
        return helper;
    }

    public int maxSubArray(int[] nums) {
        return get(0, nums.length - 1, nums).MaxSum;
    }



}
