package cn.leetcode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 悠一木碧
 */
public class LongestWordInDictionary {
    /**
     * 题目: 词典中最长的单词
     * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。
     * 若其中有多个可行的答案，则返回答案中字典序最小的单词。
     * 1.要选择字符串, 先对字符串进行排序
     * 2.要进行排序, 就先确定好排序规则
     * 3.长度优先, 长度相同的情况下, 选择最小字典序的字符串, 根据以上信息, 我们先对字符串数组进行排序
     * 4.长度进行升序排序, 长度相同的情况下, 进行字典序降序排序
     * 5.这样从末尾开始往前选, 当HashSet中不存在所需的字符串时, 即不符合条件
     * @param words
     * @return
     */
    public String longestWord(String[] words) {
        Set<String> wordSet = new HashSet<>();
        int arrayLength = words.length;
        wordSet.addAll(Arrays.asList(words).subList(0, arrayLength));
        Arrays.sort(words, (string1, string2) -> {
            return string1.length() == string2.length() ? string1.compareTo(string2) :
                    string1.length() - string2.length();
        });

        boolean isSuitable = true;
        int wordLength = 0;
        for (int i = arrayLength - 1; i >= 0; i--) {
            wordLength = words[i].length();
            int s = 1;
            while (s < wordLength) {
                if (!wordSet.contains(words[i].substring(0, s))){
                    isSuitable = false;
                    break;
                }
                s++;
            }
            if (isSuitable) {
                return words[i];
            } else {
                isSuitable = true;
            }
        }
        return "";

    }
}
