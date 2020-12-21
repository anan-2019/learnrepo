package com.self.javalearn.baselearn.sortlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName DirectInsertSort
 * @Author 51205
 * @Date 2020/11/19 20:38
 * @Version 1.0
 * @Description 直接插入排序，算法适用于少量数据的排序，时间复杂度为O(n^2)。是稳定的排序方法。
 */
public class DirectInsertSort {
    private static Logger logger = LoggerFactory.getLogger(DirectInsertSort.class);

    public static void main(String[] args) {
        int[] a = {49, 12, 48, 55, 12, 1, 0};

        System.out.println("排序之前");
        printMethod(a);

//        insertionSort(a);
//        sort2(a);
        selfSort(a);

        System.out.println();
        System.out.println("排序之后");
        printMethod(a);
    }

    /**
     * 自己实现一个插入排序算法
     *
     * @param a
     */
    private static void selfSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int tmp = a[i];
            int j = i;
            for (; j > 0 && a[j - 1] > tmp; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    /**
     * 原始的排序方式
     *
     * @param a
     */
    private static void sort2(int[] a) {
        //直接插入排序
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = temp;
        }
    }


    public static void insertionSort(int[] array) {
        int tmp;
        for (int i = 1; i < array.length; i++) {
            tmp = array[i];  //将当前位置的数给tmp
            int j = i;
            for (; j > 0 && array[j - 1] > tmp; j--) {
                    /*
                    往右移，腾出左边的位置,
                    array[j-1]>tmp:大于号是升序排列，小于号是降序排列
                   */
                array[j] = array[j - 1];
            }
            //将当前位置的数插入到合适的位置
            array[j] = tmp;
        }
    }

    /**
     * 打印数组内容
     *
     * @param a
     */
    private static void printMethod(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
