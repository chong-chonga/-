package cn.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 */

public class TraverseRectangle{

    /**
     * 走完一行/列, 判断当前计数是否是刚好与所有个数相等
     * 在赋值col前, 要进行row的判断
     * 获取二维数组的行数, 直接用数组名.length, 获取列数用 数组名[0].length
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int row = matrix.length;
        int col = 0;
        if(row <= 0)
        {
            return answer;
        }
        else
        {
            col = matrix[0].length;
        }
        int count = 0;
        int total = row * col;
        int startRow = 0;
        int endRow = row;
        int startCol = 0;
        int endCol = col;
        while(true)
        {
            for(int c = startCol; c < endCol; c++)
            {
                answer.add(matrix[startRow][c]);
                ++count;
            }
            if(count == total)
            {
                return answer;
            }
            for(int r = startRow + 1; r < endRow; r++){
                answer.add(matrix[r][endCol - 1]);
                ++count;
            }
            if(count == total)
            {
                return answer;
            }
            for(int c = endCol - 2; c >= startCol; c--){
                answer.add(matrix[endRow - 1][c]);
                ++count;
            }
            if(count == total)
            {
                return answer;
            }
            for(int r = endRow - 2; r > startRow; r--){
                answer.add(matrix[r][startCol]);
                ++count;
            }
            if(count == total)
            {
                return answer;
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

    }

    public static void main(String[] args) {
        int[][] array = new int[3][0];
        System.out.println(array.length);
        System.out.println(array[0].length);
    }
}
