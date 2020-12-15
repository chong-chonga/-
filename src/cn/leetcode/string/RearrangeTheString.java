package cn.leetcode.string;

/**
 * @author 悠一木碧
 * 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
 *
 * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 *
 * 返回重新排列后的字符串。
 *s.length == indices.length == n
 * 1 <= n <= 100
 * s 仅包含小写英文字母。
 * 0 <= indices[i] < n
 * indices 的所有的值都是唯一的（也就是说，indices 是整数 0 到 n - 1 形成的一组排列）。
 */
public class RearrangeTheString {
    public String restoreString(String s, int[] indices) {
        int len = s.length();
        StringBuilder result = new StringBuilder(s);
        for(int i = 0; i < len; i++){
            result.setCharAt(indices[i], s.charAt(i));
        }
        return  result.toString();
    }
}

