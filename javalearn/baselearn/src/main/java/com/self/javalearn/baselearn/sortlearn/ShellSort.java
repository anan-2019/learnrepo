package com.self.javalearn.baselearn.sortlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName ShellSort
 * @Author 51205
 * @Date 2020/11/19 21:05
 * @Version 1.0
 * @Description
 * 基本思想：先取一个小于n的整数d1作为第一个增量，把文件的全部记录分组。
 * 所有距离为d1的倍数的记录放在同一个组中。先在各组内进行直接插入排序；
 * 然后，取第二个增量d2<d1重复上述的分组和排序，
 * 直至所取的增量dt=1(dt<dt-1…<d2<d1)，即所有记录放在同一组中进行直接插入排序为止。
 * 希尔排序不稳定，时间复杂度 平均时间 O(nlogn) 最差时间O(n^2)
 */
public class ShellSort {
    private static Logger logger = LoggerFactory.getLogger(ShellSort.class);

    public static void main(String[] args) {
        int[] a = {49, 12, 48, 55, 12, 1, 0};
        System.out.println("排序之前");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }


        sortMethod(a);
        System.out.println();
        System.out.println("排序之后");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }


    /**
     * 新晋方法
     * @param array
     */
    public static void shellSort(int[] array){
        int j;
        for(int gap = array.length/2; gap>0; gap /= 2){
            //定义一个增长序列，即分割数组的增量,d1=N/2   dk=(d(k-1))/2
            for(int i = gap; i<array.length;i++){
                int tmp = array[i];
                for( j =i; j>=gap&&tmp<array[j-gap]; j -= gap){
                    //将相距为Dk的元素进行排序
                    array[j] = array[j-gap];
                }
                array[j] = tmp;
            }
        }
    }

    /**
     * 原始方法
     * @param a
     */
    private static void sortMethod(int[] a) {
        int d = a.length;
        while (true) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < a.length; i = i + d) {
                    int temp = a[i];
                    int j;
                    for (j = i - d; j >= 0 && a[j] > temp; j = j - d) {
                        a[j + d] = a[j];
                    }
                    a[j + d] = temp;
                }
            }
            if (d == 1) {
                break;
            }
        }
    }
}
