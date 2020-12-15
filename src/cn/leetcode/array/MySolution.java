package cn.leetcode.array;

public class MySolution {
    public int firstMissingPositive(int[] nums) {
//        第一步, 先将数组中的值全部变成[1, n]范围外的正数, 值自定, 这里写n+1
        int n = nums.length;
        for(int i = 0; i < n; ++i){
            if(nums[i] <= 0){
                nums[i] = n + 1;
            }
        }

//        第二步, 进行标记, 将范围内的正数变换成数组的对应下标, 将对应的数组中的正值修改为负值
//        修改后, 不能影响修改后值的判定结果
        int absoluteValue;
        for(int i = 0; i < n; ++i){
            absoluteValue = Math.abs(nums[i]);
            if(absoluteValue <= n)
            {
                /*
                对应下标进行标记负号
                 */
                nums[absoluteValue - 1] = - 1 * Math.abs(nums[absoluteValue - 1]);
            }
        }
//        获取非负数的最小下标
        for(int i = 0; i < n; ++i){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return n + 1;


    }


}