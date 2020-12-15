package cn.leetcode.clockIn.october;

/**
 * @author 悠一木碧
 * 题目编号: 1024
 */
public class Solution24 {
    public int videoStitching(int[][] clips, int T) {
        int s, e, count;
        count = s = e = 0;
        while(s < T){
            for (int[] clip : clips) {
                if(clip[0] <= s){
                    e = Math.max(clip[1], e);
                }
            }
            if(s == e){
                return -1;
            } else{
                s = e;
                count++;
            }
        }
        return count;

    }
}
