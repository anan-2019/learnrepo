package com.self.javalearn.baselearn.sortlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName BubbleSort
 * @Author 51205
 * @Date 2020/11/19 21:30
 * @Version 1.0
 * @Description 冒泡排序主要的思想是交换，相邻交换
 */
public class BubbleSort {
    private static Logger logger = LoggerFactory.getLogger(BubbleSort.class);
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

    private static void sortMethod(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j <a.length-i-1;j++){
                if (a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

}
