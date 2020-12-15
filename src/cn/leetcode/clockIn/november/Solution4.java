package cn.leetcode.clockIn.november;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 悠一木碧
 * 题目编号: 57
 * 两个区间没有重叠元素, 只有当left1 > right2 || right1 < left2
 */
public class Solution4 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ansGroup = new ArrayList<>();
        int insertLeft = newInterval[0];
        int insertRight = newInterval[1];
        int left, right;
        boolean hasAddeed = false;
        for (int i = 0; i < intervals.length; i++) {
            left = intervals[i][0];
            right = intervals[i][1];
            if (left > insertRight && !hasAddeed) {
                ansGroup.add(newInterval);
                hasAddeed = true;
            }

            if (right < insertLeft || left > insertRight) {
                ansGroup.add(intervals[i]);
            } else {
                if (!hasAddeed) {
                    insertLeft = newInterval[0] = Math.min(insertLeft, left);
                    insertRight = newInterval[1] = Math.max(insertRight, right);
                }
            }

        }
        if (!hasAddeed) {
            ansGroup.add(newInterval);
        }
        int[][] ans = new int[ansGroup.size()][2];
        for (int i = 0; i < ansGroup.size(); i++) {
            ans[i] = ansGroup.get(i);
        }
        return ans;
    }



}
