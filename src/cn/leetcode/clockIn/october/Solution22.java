package cn.leetcode.clockIn.october;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 悠一木碧
 * 题目编号: 763
 */
public class Solution22 {
    /**
     * 通过一次循环可以得到每个字符的终止索引
     * 然后从第一个字符开始寻找, 假设索引为m, 我们可以通过上一步得到的数组, 快速确定该字符的终止位置, 假设索引为n
     * 在(m,n)范围内寻找字符, 看其终止坐标x是否大于n, 如果大于n, 则将n更新为x, 然后继续寻找
     * 直到抵达end(最大为len - 1), 至此, 已经划分出一个结果, 值为end - start + 1
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        int[] ends = new int[26];
        for (int i = 0; i < S.length(); i++) {
            ends[S.charAt(i) - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int start, end;
        char c;
        end = start = 0;
        while(start < S.length()){
            c = S.charAt(start);
            end = ends[c - 'a'];
            for(int i = start + 1; i < end; i++){
                c = S.charAt(i);
                if(ends[c - 'a'] > end){
                    end = ends[c - 'a'];
                }
            }
            ans.add(end - start + 1);
            start = end + 1;
        }
        return ans;

    }
}
