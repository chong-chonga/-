package cn.leetcode.clockIn.november;

import java.util.*;

/**
 * @author 悠一木碧
 * 题目编号: 127
 */
public class Solution5 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> stringQueue = new LinkedList<>();
        int ans = 0;
        stringQueue.add(beginWord);
        int len = stringQueue.size();
        Set<String> usedStrings = new HashSet<>();
        String s;
        while(0 != len){
            ++ans;
            for (int i = 0; i < len; i++) {
                s = stringQueue.remove();
                for (int j = 0; j < wordList.size(); j++) {
                    if(canBeConverted(s, wordList.get(j)) && !usedStrings.contains(wordList.get(j))){
                        usedStrings.add(wordList.get(j));
                        stringQueue.add(wordList.get(j));
                        if(endWord.equals(wordList.get(j))){
                            return ans;
                        } else if(canBeConverted(wordList.get(j), endWord)){
                            return ans + 1;
                        }
                    }
                }
            }
            len = stringQueue.size();
        }
        return 0;


    }

    private boolean canBeConverted(String original, String target){
        int count = 0;
        for (int i = 0; i < original.length(); i++) {
            if(original.charAt(i) != target.charAt(i)){
                ++count;
            }
        }
        System.out.println(original + "  " + target + "  " + count);
        return 1 == count;
    }
}
