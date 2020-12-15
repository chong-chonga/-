package cn.leetcode.string;

import org.junit.Test;

import java.util.Currency;

/**
 * @author 悠一木碧
 */
public class OrganizeStrings {
    public String makeGood(String s) {
        if("".equals(s)){
            return s;
        }
        int length = s.length();
        StringBuilder stringBuilder = new StringBuilder(s);
        boolean flag = false;
        while(true){
            for(int i = 0; i < stringBuilder.length() - 1; i++){
                if(Math.abs(stringBuilder.charAt(i) - stringBuilder.charAt(i + 1)) == 32){
                    stringBuilder.delete(i, i + 2);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                break;
            } else{
                flag = false;
            }
        }
        return stringBuilder.toString();
    }


    /**
     * 将字符串展开, 通过获取前一个字符串来将当前需要拼接的字符串
     * @param n
     * @param k
     * @return
     */
    public char findKthBit(int n, int k) {
        StringBuilder before = new StringBuilder("0");
        StringBuilder current = new StringBuilder(before);
        before = current;
        for(int i = 1; i < n; i++){
            current = new StringBuilder(before);
            current.append('1');
            current.append(getChangedString(before));
            before = current;
        }
        return current.charAt(k - 1);
    }

    private StringBuilder getChangedString(StringBuilder stringNeedsToBeChanged){
        for (int i = 0; i < stringNeedsToBeChanged.length(); i++) {
           if(stringNeedsToBeChanged.charAt(i) == '1'){
               stringNeedsToBeChanged.setCharAt(i, '0');
           } else{
               stringNeedsToBeChanged.setCharAt(i, '1');
           }
        }
        return stringNeedsToBeChanged.reverse();
    }
    @Test
    public void testMakeGood(){
        System.out.println(makeGood("skm"));
    }

    @Test
    public void testGetString(){
        System.out.println(findKthBit(2, 3));
    }
}
