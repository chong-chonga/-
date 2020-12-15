package cn.leetcode.string;

import static cn.leetcode.string.AddStrings.addStrings;

/**
 * @author 悠一木碧
 */
public class Multipy {

    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        String result = "0";
        int more = 0;
        int product = 0;
        for(int i = num1.length() - 1; i >= 0; i--){
            int number1 = num1.charAt(i) - '0';
            if(0 != number1){
                int number2;
                StringBuilder addend = new StringBuilder();
                more = 0;
                int j = num2.length() - 1;
                while(j >= 0 || more > 0){
                    number2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
                    product = number1 * number2 + more;
                    more = product / 10;
                    addend.append(product % 10);
                }
                addend.reverse();
                addend.append("0".repeat(num1.length() - 1- i));
                result = addStrings(result, addend.toString());
            }
        }
        return result;
    }
}
