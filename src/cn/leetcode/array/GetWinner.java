package cn.leetcode.array;

/**
 * @author 悠一木碧
 * 给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。
 *
 * 每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。比较 arr[0] 与 arr[1] 的大小，较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。
 *
 * 返回赢得比赛的整数。
 * 2 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^6
 * arr 所含的整数 各不相同 。
 * 1 <= k <= 10^9
 * 题目数据 保证 游戏存在赢家。
 */
public class GetWinner {
    public int getWinner(int[] arr, int k) {
        int theNumberOfNumbersToBeCompared;
        for (int i = 0; i < arr.length; i++) {
            theNumberOfNumbersToBeCompared = i == 0 ? k : k - 1;
            if(isWinner(i, arr, theNumberOfNumbersToBeCompared)){
                return arr[i];
            }
        }
        return 0;
    }

    private boolean isWinner(int indexOfCandidate, int[] arr, int times) {
        int index;
        if(times > arr.length){
            times = arr.length;
        }
        for(int i = 1; i <= times; i++){
            index = ((indexOfCandidate + i) % arr.length);
            if(isLess(arr[indexOfCandidate], arr[index])){
                return false;
            }
        }
        return true;
    }

    private boolean isLess(int num1, int num2){
        return num1 < num2;
    }
}
