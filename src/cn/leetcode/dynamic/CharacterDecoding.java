package cn.leetcode.dynamic;

/**
 * 动态规划问题:
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 示例 1:
 *
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 *
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 动态规划解法
 * if
 * 如果第一位就是0, 那么就没有解, 返回0
 * 从第二位开始, 如果当前字符为 0, 假设下标为i, 查看[i-1]字符, 如果为1或者2, 解码方法就是字符串[0~i-2]时的解法数量
 * 解读: 因为0字符前面不能是3~9, 或者00, 这样无解
 * else
 * 当前字符不是0字符时, 也就是1~9
 * 判断前一位字符, 因为编码范围是 1 ~ 26
 * 所以前面一个字符如果是1, 那么这两个字符范围是 11 ~ 19
 * 前面一个字符如果是2, 那么这两个字符范围是21 ~ 29
 * 对11 ~ 26的, 解法数量为字符串[0~i-1] + [0~i-2]时的解法数量和
 * 27 ~ 29的没有编码, 我们判定只有一种解码方式(也就是不增加编码方式)
 */
public class CharacterDecoding{

        public static int numDecodings(String s) {
            if(s.charAt(0) == '0') return 0;
            int currentSolutions = 1;
            int previousSolutions = 1;
            int pPreviousSolutions = 1;
            for (int i = 1; i < s.length(); i++) {
                if(s.charAt(i) == '0')
                {
                    if(s.charAt(i-1) == '1' || '2' == s.charAt(i-1))
                    { currentSolutions = pPreviousSolutions; }
                    else
                    { return 0; }
                }
                else if(s.charAt(i-1) == '1')
                {
                    currentSolutions = previousSolutions + pPreviousSolutions;
                }
                else if(s.charAt(i-1) == '2' && (s.charAt(i) >= '1' && s.charAt(i) <= '6' ))
                {
                    currentSolutions = previousSolutions + pPreviousSolutions;
                }
                pPreviousSolutions = previousSolutions;
                previousSolutions = currentSolutions;
            }
            return currentSolutions;
        }

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
}
