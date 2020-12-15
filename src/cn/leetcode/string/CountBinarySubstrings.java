package cn.leetcode.string;

/**
 * @author 悠一木碧
 */
public class CountBinarySubstrings {
    /**
     * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。
     * 重复出现的子串要计算它们出现的次数。
     * s.length 在1到50,000之间。
     * s 只包含“0”或“1”字符。
     * 子字符串中, 要保证0和0挨在一起, 1和1挨在一起, 且0字符和1字符出现次数相同
     * 如01, 0011, 000111, 10, 1100, 111000等字符串
     * @param s 字符串
     * @return
     */
    public int countBinarySubstrings(String s) {
        int countOfOccurrencesOfFirstKindCharacter = 1;
        int countOfOccurrencesOfSecondKindCharacter = 0;
        int result = 0;
        int flag;
        char currentKindChar = s.charAt(0);
        /*
        以第一个字符为初始字符, 计算第一个字符重复出现的次数, 找到开始不同的下标flag
         */
        for(flag = 1; flag < s.length(); flag++){
            if(currentKindChar == s.charAt(flag)){
                countOfOccurrencesOfFirstKindCharacter++;
            } else{
                break;
            }
        }
        /*
        开始统计第二种字符重复出现的次数,将其次数与之前统计到的currentOccurrencesOfFirstKind进行比较
        能出现的满足条件的对称字符串最大值为两者取min, 使用Math类中的方法min()进行计算
        然后进行下一轮的循环, 将第二种字符出现的次数替换第一种, 再次开始统计类型不同的字符出现的次数
        直到迭代到字符串的末尾即算法结束
         */
        if(flag < s.length()){
            currentKindChar = s.charAt(flag);
            for(int i = flag; i < s.length(); i++){
                if(currentKindChar == s.charAt(i)){
                    countOfOccurrencesOfSecondKindCharacter++;
                } else{
                    result += Math.min(countOfOccurrencesOfFirstKindCharacter,
                            countOfOccurrencesOfSecondKindCharacter);
                    countOfOccurrencesOfFirstKindCharacter =
                            countOfOccurrencesOfSecondKindCharacter;
                    countOfOccurrencesOfSecondKindCharacter = 1;
                    currentKindChar = s.charAt(i);
                }
            }
        }
        /*
        当循环到字符串结尾的时候countOfOccurrencesOfSecondKindCharacter还在计算, 将其再次取最小值, 加入到result
         */
        result += Math.min(countOfOccurrencesOfFirstKindCharacter,
                countOfOccurrencesOfSecondKindCharacter);

        return result;

    }
}
