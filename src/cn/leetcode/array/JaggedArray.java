package cn.leetcode.array;

/**
 * @author 悠一木碧
 * 给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。
 * 如果符合下列情况之一，则数组 A 就是 锯齿数组：
 * <p>
 * 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组 nums 转换为锯齿数组所需的最小操作次数
 * 1 <= nums.length <= 1000
 */
public class JaggedArray {
    /**
     * 确保每个奇数索引位置的数小于左右两侧的数字(第一种方式)
     * 或者每个偶数索引位置的数小于左右两侧的数字(第二种方式)
     * 两种方式产生的操作次数, 选取最少的次数并返回
     * 为了好听点, 下面就用---第一种方式---第二种方式称呼
     * @param nums
     * @return
     */
    public int movesToMakeZigzag(int[] nums) {
        int len = nums.length;
        if (1 == len) {
            return 0;
        }
        /*
        定义timesForOdd用于存储第一种方式(奇数)所需的次数, timesForEven用于存储第二种方式所需的次数
        isEven用于判定数组长度是否为偶数
         */
        int timesForOdd = 0;
        int timesForEven = 0;
        boolean isEven = len % 2 == 0;
/*      (第二种方式)偶数索引位置的特殊情况, 即0索引位置处的数字只有右侧有数字, 左侧没有
        这个情况在任何长度的数组中都会出现, 所以需要先执行这个*/
        if (nums[0] >= nums[1]) {
            timesForEven += (nums[0] - nums[1] + 1);
        }

        /*
        使用迭代, 用于判断当前数字最少需要操作几次, 并将次数添加到对应的times变量上
        这里的迭代, 指的是-----当前数字的左右两侧都有数字
        像0索引和len-1索引就是特殊位置, 不能使用上述的通用迭代去解决, 我们当成特殊情况处理
        flag1, flag2分别规定了第一种, 第二种方式通用迭代的上限
        1.当数组长度len为偶数的时候, len-1索引就是奇数
        假如使用for(int i = 1; i < len; i++) 索引最终会走到len- 1, 而这是特殊情况, 我们需要特殊处理
        所以应该将上限下降为len - 2--------for(int i = 1; i < len - 2; i++)
        2.当数组长度len为奇数的时候, len - 1索引是偶数
        同理, 偶数迭代也会到特殊情况上, 我们也需要特殊处理
        如此一来, flag的作用就清晰了
         */
        int flag1, flag2;
        if(isEven){
            flag1 = len - 2;
            flag2 = len;
        } else{
            flag1 = len;
            flag2 = len - 2;
        }
        /*
        计算每个奇数索引位置的数小于左右两侧的数字所需要操作的次数
        */
        for (int i = 1; i < flag1; i += 2) {
            if (nums[i + 1] <= nums[i] || nums[i] >= nums[i - 1]) {
                timesForOdd += (nums[i] - Math.min(nums[i - 1], nums[i + 1]) + 1);
            }
        }
        /*
        计算每个偶数索引位置的数小于左右两侧的数字所需要操作的次数
         */
        for (int i = 2; i < flag2; i += 2) {

            if (nums[i + 1] <= nums[i] || nums[i] >= nums[i - 1]) {
                timesForEven += (nums[i] - Math.min(nums[i - 1], nums[i + 1]) + 1);
            }
        }

        /*
        特殊情况处理站, 处理完后, 就得到了两种方式所需的次数
        返回最小的那个即可
         */
        if (isEven) {
            if (nums[len - 1] >= nums[len - 2]) {
                timesForOdd += (nums[len - 1] - nums[len - 2] + 1);
            }
        } else {
            if (nums[len - 1] >= nums[len - 2]) {
                timesForEven += (nums[len - 1] - nums[len - 2] + 1);
            }
        }

        return Math.min(timesForOdd, timesForEven);
    }
}
