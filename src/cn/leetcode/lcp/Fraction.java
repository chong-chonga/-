package cn.leetcode.lcp;

/**
 * @author 悠一木碧
 */
public class Fraction {

    public int[] fraction(int[] cont) {
        int[] result = new int[2];
        if(cont.length == 1){
            result[0] = cont[0];
            result[1] = 1;
            return result;
        }
        int denominator = cont[cont.length - 1];
        int molecular = 1;
        for(int i = cont.length - 2; i >= 0; i--){
            molecular = cont[i] * denominator + molecular;
            if(i > 0){
                int temp = denominator;
                denominator = molecular;
                molecular = temp;
            }
            int mod = getGreatestCommonDivisor(denominator, molecular);
            denominator /= mod;
            molecular /= mod;
        }
        result[0] = molecular;
        result[1] = denominator;
        return result;
    }

    /**
     * 获取最大公约数
     * @param n
     * @param m
     * @return
     */
    public int getGreatestCommonDivisor(int n, int m){
        int r;
        while(n != 0){
            r = m % n;
            m = n;
            n = r;
        }
        return m;
    }
}
