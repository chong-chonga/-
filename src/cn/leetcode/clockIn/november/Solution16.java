package cn.leetcode.clockIn.november;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 悠一木碧
 */
public class Solution16 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o2[0] - o1[0];
                } else{
                    return o1[1] - o2[1];
                }
            }
        });
        for (int[] person : people) {
            System.out.println(person[0] + "  " + person[1]);
        }
        return null;
    }
}
