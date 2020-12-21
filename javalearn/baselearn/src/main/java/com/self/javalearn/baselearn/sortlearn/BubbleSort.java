package com.self.javalearn.baselearn.sortlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName BubbleSort
 * @Author 51205
 * @Date 2020/11/19 21:30
 * @Version 1.0
 * @Description 冒泡排序主要的思想是交换，相邻交换,
 * 基本思想：持续比较相邻的元素。如果第一个比第二个大，就交换他们两个。直到没有任何一对数字需要比较。
 * 冒泡排序最好的时间复杂度为O(n)。冒泡排序的最坏时间复杂度为O(n^2)。因此冒泡排序总的平均时间复杂度为O(n^2)。
 * 算法适用于少量数据的排序，是稳定的排序方法。
 */
public class BubbleSort {
    private static Logger logger = LoggerFactory.getLogger(BubbleSort.class);
    public static void main(String[] args) {
        int[] a = {49, 12, 48, 55, 12, 1, 0};
        System.out.println("排序之前");
        printArray(a);

        sortMethod(a);



        System.out.println();
        System.out.println("排序之后");
        printArray(a);
    }

    private static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * 改进的网上的排序方式
     * @param array
     */
    public static void bubbleSort(int[] array){
        int tmp;
        boolean flag = false;  //设置是否发生交换的标志
        for(int i = array.length-1;i >= 0;i--){
            for(int j=0;j<i;j++){          //每一轮都找到一个最大的数放在右边
                if(array[j]>array[j+1]){
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flag = true;   //发生了交换
                }
            }
            if(!flag) {
                break;   //这一轮循环没有发生交换，说明排序已经完成，退出循环
            }
        }
    }

    /**
     * 之前的排序方式
     * @param a
     */
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
