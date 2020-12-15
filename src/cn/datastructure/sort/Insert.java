package cn.datastructure.sort;

/**
 * @author 悠一木碧
 * 插入排序类
 */
public class Insert {
    /**
     * 升序排序
     * @param a
     */
    public static void sort(Comparable[] a) {
        if (null == a) {
            throw new NullPointerException("空指针数组!");
        }
        int len = a.length;
//        1. 从第二个元素开始进行排序
//        2. 用temp记录当前索引位置, 索引必须 > 0(当索引为0的时候不需要再往前比较了)
//        3.如果满足条件, 则进行交换, 同时将索引前移一位----temp--
        for (int i = 1; i < a.length; i++) {
            int temp = i;
            while (temp > 0 && bigger(a[temp - 1], a[temp])) {
                exchange(a, temp - 1, temp);
                temp--;
            }
        }
    }

    /**
     * 判断a 是否大于 b
     * @param a
     * @param b
     * @return
     */
    private static boolean bigger(Comparable a, Comparable b) {
        return a.compareTo(b) > 0;
    }

    /**
     * 交换索引index1, index2位置的元素
     * @param a
     * @param index1
     * @param index2
     */
    private static void exchange(Comparable[] a, int index1, int index2) {
        Comparable comparable = a[index1];
        a[index1] = a[index2];
        a[index2] = comparable;
    }
}
