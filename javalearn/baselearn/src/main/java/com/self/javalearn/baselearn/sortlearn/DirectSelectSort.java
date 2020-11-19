package com.self.javalearn.baselearn.sortlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName DirectSelectSort
 * @Author 51205
 * @Date 2020/11/19 21:22
 * @Version 1.0
 * @Description Class Function Description Here
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
