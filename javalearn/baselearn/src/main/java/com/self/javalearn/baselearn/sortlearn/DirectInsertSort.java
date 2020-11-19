package com.self.javalearn.baselearn.sortlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName DirectInsertSort
 * @Author 51205
 * @Date 2020/11/19 20:38
 * @Version 1.0
 * @Description 直接插入排序
 */
public class DirectInsertSort {
    private static Logger logger = LoggerFactory.getLogger(DirectInsertSort.class);

    public static void main(String[] args) {
        int[] a = {49, 12, 48, 55, 12, 1, 0};
        System.out.println("排序之前");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

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
        System.out.println();
        System.out.println("排序之后");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
