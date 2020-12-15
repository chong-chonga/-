package cn.datastructure.sort;


/**
 * @author 悠一木碧
 * 希尔排序类
 */
public class Shell {
    /**
     * 对数组内元素进行排序(升序)
     * @param a
     */
    public static void sort(Comparable[] a) {
        if(null == a){
            throw new NullPointerException("空指针数组!");
        }
//        1.通过数组的长度确定增长量initialIncrement的初始值, 初始化值为1, 通过循环条件(<len / 2)进行确定
//        2.确定初始值后, 确定循环条件, 由于increment需要逐渐减小, 变换方法为increment /= 2
//        3.初始下标为0 + increment, 1+increment, 2+increment.....区间[increment, len-1]内
//        4.数与数之间的间隔为increment, 从当前的数开始, 与前一个数进行比较(假设前面的数成有序列)
//        5.如果不符合期待的大小关系, 则进行交换, 否则退出循环(说明已经成有序列了)
        int len = a.length;
        int increment = 1;
        while (increment < len / 2) {
            increment = increment * 2 + 1;
        }
        while (increment > 0) {
            for (int i = increment; i < len; i++) {
                startSort(i, increment, a);
            }
            increment /= 2;
        }
    }

    private static void startSort(int startIndex, int increment, Comparable[] a) {
        while(startIndex >= increment && greater(a[startIndex - increment], a[startIndex])){
            exchange(a, startIndex - increment, startIndex);
            startIndex -= increment;
        }
    }

    /**
     * 判断x是否大于y
     *
     * @param x
     * @param y
     * @return
     */
    private static boolean greater(Comparable x, Comparable y) {
        return x.compareTo(y) > 0;
    }

    /**
     * 交换a数组中, i,j索引处的值
     *
     * @param a
     * @param i
     * @param j
     */
    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
