package com.self.javalearn.baselearn.sortlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName DirectSelectSort
 * @Author 51205
 * @Date 2020/11/19 21:22
 * @Version 1.0
 * @Description 每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。
 * 选择排序是不稳定的排序方法。时间复杂度 O(n^2)。
 */
public class DirectSelectSort {
    private static Logger logger = LoggerFactory.getLogger(DirectSelectSort.class);

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
     * 新晋网上算法
     * @param array
     */
    public static void selectSort(int[] array){
        for(int i = 0;i<array.length-1;i++){
            int min = array[i];
            int minindex = i;
            for(int j = i;j<array.length;j++){
                if(array[j]<min){  //选择当前最小的数
                    min = array[j];
                    minindex = j;
                }
            }
            if(i != minindex){ //若i不是当前元素最小的，则和找到的那个元素交换
                array[minindex] = array[i];
                array[i] = min;
            }
        }
    }

    /**
     * 原始算法
     * @param a
     */
    private static void sortMethod(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int n = i;
            for (int j = i+1; j<a.length;j++){
                if (a[j]<min){
                    min=a[j];
                    n = j;
                }
            }
            a[n] = a[i];
            a[i] = min;
        }
    }
}
