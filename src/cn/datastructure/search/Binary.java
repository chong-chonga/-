package cn.datastructure.search;

/**
 * @author 悠一木碧
 */
public class Binary {
    public static boolean contains(int[] array, int value){
        if(null == array){
            throw new NullPointerException("数组为null!");
        }
        int len = array.length;
        if(0 == len){
            return false;
        }
        int left, mid, right;
        left = 0;
        right = len - 1;

        while(left < right){
            mid = (left + right) / 2;
            if(value > array[mid]){
                left = mid + 1;
            } else{
                right = mid;
            }
        }
        return array[left] == value;
    }
}
