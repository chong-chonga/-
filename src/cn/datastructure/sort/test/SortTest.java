package cn.datastructure.sort.test;

import cn.datastructure.sort.Merge;
import cn.datastructure.sort.Quick;
import cn.datastructure.sort.Shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author 悠一木碧
 */
public class SortTest {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        InputStream inputStream  = SortTest.class.getClassLoader().getResourceAsStream("data" +
                ".txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = null;
        while((line = bufferedReader.readLine())!= null)
        {
            int i = Integer.parseInt(line);
            arrayList.add(i);
        }
        bufferedReader.close();
        Integer[] array = new Integer[arrayList.size()];
        arrayList.toArray(array);

        long l = System.currentTimeMillis();
        System.out.println("希尔排序: ");
        Shell.sort(array);
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l + "毫秒");

/*        long l = System.currentTimeMillis();
        System.out.println("插入排序: ");
        Insert.sort(array);
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l + "毫秒");*/
/*        long l = System.currentTimeMillis();
        System.out.println("归并排序: ");
        Merge.sort(array);
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l + "毫秒");
        for (Integer integer : array) {
            System.out.println(integer);
        }*/

/*        long l = System.currentTimeMillis();
        System.out.println("快速排序: ");
        Quick.sort(array);
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l + "毫秒");
        for (Integer integer : array) {
            System.out.println(integer);
        }*/
    }
}
