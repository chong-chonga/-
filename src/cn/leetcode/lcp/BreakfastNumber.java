package cn.leetcode.lcp;

import java.util.*;

/**
 * @author 悠一木碧
 * 扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，
 * 一维整型数组 drinks 中记录了每种饮料的价格。小扣的计划选择一份主食和一款饮料，且花费不超过 x 元。
 * 请返回小扣共有多少种购买方案。
 * <p>
 * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模
 * 如：计算初始结果为：1000000008，请返回 1
 */
public class BreakfastNumber {
    public int breakfastNumber(int[] staple, int[] drinks, int x) {

        long totalCombinations = 0;
        long mod = 1000000007;
        Arrays.sort(staple);
        Arrays.sort(drinks);

        int availableCombinations = drinks.length;
        for (int num : staple) {
            while (availableCombinations >= 0 && num + drinks[availableCombinations - 1] > x) {
                availableCombinations--;
            }
            totalCombinations += availableCombinations;
        }
        return (int) (totalCombinations % mod);

    }

    public int minOperations(String[] logs) {
        int currentDepth = 0;
        for (String log : logs) {
            if (log.charAt(0) == '.') {
                if (log.charAt(1) == '.') {
                    currentDepth = currentDepth == 0 ? 0 : currentDepth - 1;

                }
            } else {
                currentDepth += 1;
            }

        }
        return currentDepth;
    }

    public boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<>();
        int temp = n;
        while(temp != 1){
            if(nums.contains(temp)){
                return false;
            }
            nums.add(temp);
            temp = getSumOf(temp);
        }
        return true;
    }

    private int getSumOf(int num){
        int sum = 0;
        while(num > 0){
            sum += Math.pow(num % 10, 2);
            num /= 10;
        }
        return sum;
    }


}
