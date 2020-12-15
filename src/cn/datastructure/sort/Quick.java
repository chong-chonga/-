package cn.datastructure.sort;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.Random;


/**
 * @author 悠一木碧
 * 快速排序
 */
public class Quick {
    private int[] arr = null;
    private Random random = new Random();

    public void sort(int[] arr){
        if(null != arr){
            this.arr = arr;
            quickSort(0, arr.length - 1);
        }

    }
    private void quickSort(int lowerLimit, int upperLimit) {
        if(lowerLimit < upperLimit){

            int left, right;
            left = lowerLimit;
            right = upperLimit;

            int randomIndex = random.nextInt(upperLimit - lowerLimit) + lowerLimit + 1;
            int baseValue = arr[randomIndex];

            exchange(left, randomIndex);

            while(left < right){
                while((left < right) && arr[right] >= baseValue){
                    right--;
                }
                if(left < right){
                    arr[left++] = arr[right];
                }

                while(left < right && arr[left] <= baseValue){
                    left++;
                }
                if(left < right){
                    arr[right--] = arr[left];
                }
            }
            arr[left] = baseValue;
            quickSort(lowerLimit, right - 1);
            quickSort(right + 1, upperLimit);
        }

    }


    private void exchange(int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    @Test
    public void testQuickSort(){
        Random random = new Random();
        for(int i = 0; i < 100; i++){
            System.out.println(random.nextInt(1));
        }
    }


}