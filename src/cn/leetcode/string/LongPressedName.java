package cn.leetcode.string;

/**
 * @author 悠一木碧
 * 题目编号:
 */
public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        int index1, index2;
        int count1, count2;
        index1 = index2 = 0;
        char[] chars1 = name.toCharArray();
        char[] chars2 = typed.toCharArray();


        while(index1 < chars1.length){
            count1 = 1;
            count2 = 0;
            while (index1 + 1 < chars1.length && chars1[index1] == chars1[index1 + 1]) {
                count1++;
                index1++;
            }
            index1++;
            while (index2 < chars2.length && chars2[index2] == chars1[index1]) {
                count2++;
                index2++;
            }
            if (count1 > count2) {
                return false;
            }
            index1++;
        }
        return index2 == chars2.length;
    }
}
