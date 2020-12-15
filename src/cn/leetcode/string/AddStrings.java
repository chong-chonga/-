package cn.leetcode.string;

/**
 * @author 悠一木碧
 */
public class AddStrings {
    /**
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     * num1 和num2 的长度都小于 5100
     * num1 和num2 都只包含数字 0-9
     * num1 和num2 都不包含任何前导零
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int p1 = num1.length() - 1;
        int p2 = num2 .length() - 1;
        int sum;
        int more = 0;
        int number1, number2;
        while(p1 >= 0 || p2 >= 0 || more > 0){
            number1 = p1 >= 0 ? num1.charAt(p1--) - '0' : 0;
            number2 = p2 >= 0 ? num2.charAt(p2--) - '0' : 0;
            sum = number1 + number2 + more;
            more = sum / 10;
            result.append(sum % 10);
        }
        return result.reverse().toString();
    }
}
