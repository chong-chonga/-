package cn.leetcode.string;

/**
 * @author 悠一木碧
 * 房间中有 n 个灯泡，编号从 0 到 n-1 ，自左向右排成一行。最开始的时候，所有的灯泡都是 关 着的。
 *
 * 请你设法使得灯泡的开关状态和 target 描述的状态一致，其中 target[i] 等于 1 第 i 个灯泡是开着的，等于 0 意味着第 i 个灯是关着的。
 *
 * 有一个开关可以用于翻转灯泡的状态，翻转操作定义如下：
 *
 * 选择当前配置下的任意一个灯泡（下标为 i ）
 * 翻转下标从 i 到 n-1 的每个灯泡
 * 翻转时，如果灯泡的状态为 0 就变为 1，为 1 就变为 0 。
 *
 * 返回达成 target 描述的状态所需的 最少 翻转次数。
 *
 */
public class LightbulbSwitch4 {
    /**
     * isLighted表示从i ~ n - 1范围内灯泡的状态
     * count用于计算反转的次数
     *
     * @param target
     * @return
     */
    public int minFlips(String target) {
        char[] chars = target.toCharArray();
        int count = 0;
        int s = 0;
        for (char c : chars) {
            if(s != c - '0'){
                ++count;
                s = s == 0 ? 1 : 0;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        String s = "55545556555";
        System.out.println(s.indexOf("5555555", 2));
    }

}
