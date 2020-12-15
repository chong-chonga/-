package cn.leetcode.string;

import java.util.Arrays;

/**
 * @author 悠一木碧
 * 题目编号: 1624
 */
public class SubStringInTwoChars {

    public int maxLengthBetweenEqualCharacters(String s) {
        int[] count = new int[256];
        int[] flags = new int[256];
        boolean flag = false;
        char[] chars = s.toCharArray();
        char c;

        for(int i = 0; i < chars.length; i++){
            c = chars[i];
            if(count[c] == 0){
                count[c] = i + 1;
            }
        }

        for(int i = chars.length - 1; i >= 0; i--){
            c = chars[i];
            if(flags[c] == 0){
                if(i + 1 != count[c]){
                    flag = true;
                }
                count[c] = i - count[c];
                flags[c] = 1;
            }
        }
        Arrays.sort(count);

        if(flag){
            return count[255];
        }else{
            return -1;
        }
    }
}
