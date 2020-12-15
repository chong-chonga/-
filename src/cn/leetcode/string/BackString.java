package cn.leetcode.string;

import org.junit.Test;

/**
 * @author 悠一木碧
 * 题目编号: 844
 */
public class BackString {

    public boolean backspaceCompare(String S, String T) {
        StringBuffer string1 = new StringBuffer();
        StringBuffer string2 = new StringBuffer();

        int index1, index2;
        index1 = index2 = 0;
        while(index1 < S.length() && index2 < T.length()){
            if(S.charAt(index1) == '#'){
                if(string1.length() != 0){
                    string1.delete(string1.length() - 1, string1.length());
                }
            } else {
                string1.append(S.charAt(index1));
            }
            if(T.charAt(index2) == '#'){
                if(string2.length() != 0){
                    string2.delete(string2.length() - 1, string2.length());
                }
            } else {
                string2.append(T.charAt(index2));
            }
            index1++;
            index2++;
        }
        for(int i = index1; i < S.length(); i++){
            if(S.charAt(i) == '#'){
                if(string1.length() != 0){
                    string1.delete(string1.length() - 1, string1.length());
                }
            } else {
                string1.append(S.charAt(i));
            }
        }

        for (int i = index2; i < T.length(); i++) {
            if(T.charAt(i) == '#'){
                if(string2.length() != 0){
                    string2.delete(string2.length() - 1, string2.length());
                }
            } else {
                string2.append(T.charAt(i));
            }
        }
        System.out.println(string1 + "" + string2);
        return string1.toString().equals(string2.toString());
    }

    @Test
    public void testSolution(){
        System.out.println(backspaceCompare("ab#c", "ad#c"));
    }
}
