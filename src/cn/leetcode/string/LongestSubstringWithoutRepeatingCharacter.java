package cn.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 悠一木碧
 * 题目编号: 3
 */
public class LongestSubstringWithoutRepeatingCharacter {
    private Map<Character, Integer> oneMap;

    public int lengthOfLongestSubstring(String s) {
        oneMap = new HashMap<>();
        char[] chars = s.toCharArray();
        int maxLength = 0;
        int currentLength = 0;
        for(int i = 0; i < chars.length; i++){
            if(oneMap.containsKey(chars[i])){
                if(currentLength > maxLength){
                    maxLength = currentLength;
                }
                int index = oneMap.get(chars[i]);
                removeFrontKeys(i - currentLength, i, chars);
                currentLength = i - index;
                oneMap.replace(chars[i], i);
            } else{
                currentLength++;
                oneMap.put(chars[i], i);
            }
        }
        if(currentLength > maxLength){
            maxLength = currentLength;
        }

        return maxLength;
    }

    /**
     * 用于找到重复的字符时, 将子串开始字符到第一个重复字符之间
     */
    private void removeFrontKeys(int start, int end, char[] keys){
        for(int j = start; j < end; j++){
            oneMap.remove(keys[j]);
        }
    }

}
