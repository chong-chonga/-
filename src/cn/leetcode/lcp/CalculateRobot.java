package cn.leetcode.lcp;

/**
 * @author 悠一木碧
 */
public class CalculateRobot {
    public int calculate(String s) {
        int x = 1;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            if('A' == s.charAt(i)){
                x = x * 2 + y;
            } else{
                y = y* 2 + x;
            }
        }
        return x + y;
    }
}
