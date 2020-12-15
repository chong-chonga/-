package cn.leetcode.clockIn.november;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 悠一木碧
 */
public class Solution15 {
    public String removeKdigits(String num, int k) {
        Deque<Character> chars = new LinkedList<>();
        char c;
        int deletedCount = 0;
        for (int i = 0; i < num.length(); i++) {
            c = num.charAt(i);
            if (0 == chars.size()) {
                chars.offerLast(c);
            } else {
                if (c >= chars.peekLast()) {
                    chars.offerLast(c);
                } else {
                    while (k > deletedCount && 0 != chars.size() && chars.peekLast() > c) {
                        ++deletedCount;

                        chars.removeLast();
                    }
                    chars.offerLast(c);
                }
            }
        }


        while (k > deletedCount && 0 != chars.size()) {
            ++deletedCount;
            chars.removeLast();
        }

        while(0 != chars.size() && '0' == chars.peekFirst()){

            chars.removeFirst();
        }

        if(0 == chars.size()){
            return "0";
        } else{
            StringBuilder stringBuilder = new StringBuilder();
            for (Character aChar : chars) {
                stringBuilder.append(aChar);
            }
            return stringBuilder.toString();
        }


    }
}
