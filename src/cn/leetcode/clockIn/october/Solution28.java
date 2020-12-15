package cn.leetcode.clockIn.october;

import java.util.*;

/**
 * @author 悠一木碧
 * 题目编号: 1027
 *
 * 方法: 由于数字的大小有限制, 在-1000 ~ 1000之间, 所以可以通过数字索引, O(n)时间统计好数字的出现次数
 * 然后创建map, map中放置数字出现的次数, 如果有数字的出现次数和map中相同,
 * 判断key是否相同, 不相同----> false
 */
public class Solution28 {
    public boolean uniqueOccurrences(int[] arr) {
        int[] numCounts = new int[2001];
        for (int i : arr) {
            ++numCounts[i + 1000];
        }
        Map<Integer, Integer> map = new HashMap<>();

        int count;
        for (int i : arr) {
            count = numCounts[i + 1000];
            if(map.containsValue(count)){
                if(!map.containsKey(i + 1000)){
                    return false;
                }
            } else{
                map.put(i + 1000, count);
            }
        }
        return true;

    }
}
