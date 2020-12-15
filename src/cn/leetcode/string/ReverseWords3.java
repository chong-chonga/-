package cn.leetcode.string;

import org.junit.Test;

/**
 * @author 悠一木碧
 */
public class ReverseWords3 {
    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int ptr1 = 0;
        int ptr2 = 0;
        while(ptr2 < s.length()){
            while(ptr2 < s.length() && chars[ptr2] != ' '){
                ptr2++;
            }
            reverse(ptr1, ptr2 - 1, chars);
            ptr1 = ptr2 = ptr2 + 1;
        }


        return new String(chars);
    }

    private void reverse(int startIndex, int endIndex, char[] string){
        while(startIndex < endIndex){
            char temp = string[startIndex];
            string[startIndex] = string[endIndex];
            string[endIndex] = temp;
            ++startIndex;
            --endIndex;
        }
    }

    @Test
    public void testReverse(){
        reverseWords("Let's take LeetCode contest");
    }
}
