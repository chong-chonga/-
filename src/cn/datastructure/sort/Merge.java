package cn.datastructure.sort;

import org.junit.Test;

import java.io.*;
import java.util.Random;

/**
 * @author 悠一木碧
 * 归并排序
 */
public class Merge {
//    辅助数组
    private static Comparable[] assitArray;
    /**
     * 对数组内的元素进行排序
     * @param array
     */
    public static void sort(Comparable[] array){
        if(null == array){
            throw new NullPointerException("空指针数组!");
        }
        int len = array.length;
        assitArray = new Comparable[len];
        sort(array, 0, len-1);
    }

    /**
     * 对区间[staIndex, endIndex]中的数组元素进行排序
     * 递归至 staIndex == endIndex停止
     * 在staIndex = endIndex - 1的时候开始调用merge进行归并
     * @param array
     * @param staIndex
     * @param endIndex
     */
    private static void sort(Comparable[] array, int staIndex, int endIndex){
        if(staIndex < endIndex){
            int mid = (staIndex + endIndex) / 2;
            sort(array, staIndex, mid);
            sort(array, mid + 1, endIndex);
            merge(array, staIndex, mid, endIndex);
        }
    }

    /**
     * [left, mid], [mid + 1, right]两个子组进行有序组合
     * 1. 定义辅助数组的初始指针, 定义原数组的两个区间的初始指针
     * 2. 依次移动两个区间的指针, 比较他们指向元素的大小, 按大小放入至辅助数组中
     * 3. 将排好序的辅助数组中的元素复制到原数组中
     * 两个区间的指针必定会有一个提前走完, 剩下没走完的指针, 将其剩余的元素放到辅助数组中即可
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(Comparable[] array, int left, int mid, int right){
        int i = left;
        int index1 = left;
        int index2 = mid + 1;
        while(index1 <= mid && right >= index2){
            if(bigger(array[index1], array[index2])){
                assitArray[i++] = array[index2++];
            } else{
                assitArray[i++] = array[index1++];
            }
        }
        while(index1 <= mid){
            assitArray[i++] = array[index1++];
        }
        while(index2 <= right){
            assitArray[i++] = array[index2++];
        }
//        以left索引为起始点, 从assitArray数组上复制元素到到array数组上, 以left索引为起始点开始存放
//        长度为 right + 1 - left
        if (right - left + 1 >= 0)
            System.arraycopy(assitArray, left, array, left, right + 1 - left);
    }

    /**
     * 判断a > b
     * @param a
     * @param b
     * @return
     */
    private static boolean bigger(Comparable a, Comparable b){
        return a.compareTo(b) > 0;
    }

    @Test
    public void testMySort() throws IOException {
        File file = new File("D:\\Code\\IdeaProjects\\算法\\src\\data.txt");
        OutputStream outputStream = new FileOutputStream(file);
        Random random = new Random();
        for(int i = 0; i < 3000; i++){
            outputStream.write(random.nextInt());
        }
        outputStream.close();

        InputStream inputStream = new FileInputStream(file);
        for(int i = 0; i < 3000; i++){
            System.out.println(inputStream.read());
        }



    }
}
