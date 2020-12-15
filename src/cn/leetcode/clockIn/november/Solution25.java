package cn.leetcode.clockIn.november;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 悠一木碧
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 *
 */
public class Solution25 {
//    public String sortString(String s) {
//        StringBuilder stringBuilder = new StringBuilder();
//        int[] charsCount = new int[256];
//        Set<Character> set = new HashSet<>();
//
//        for (int i = 0; i < s.length(); i++){
//            ++charsCount[s.charAt(i)];
//            if(!set.contains(s.charAt(i))){
//                set.add(s.charAt(i));
//            }
//        }
//        Character[] chars = (Character[]) set.toArray();
//        for (int i = 0; i < chars.length; i++) {
//
//        }
//    }
}
