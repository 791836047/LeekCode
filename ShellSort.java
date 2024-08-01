package com.whl.leekcode.sort;

import java.util.Arrays;

/**
 * 希尔排序，也称递减增量排序算法，是插入排序的一种更高效的改进版本。但希尔排序是非稳定排序算法。
 * @author liaowenhui
 * @date 2022/1/3 16:11
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 2, 6, 1, 5};
        System.out.println("排序前为：" + Arrays.toString(arr));
        shellSort(arr);
        System.out.println("排序后结果为：" + Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                    System.out.println("i为" + i + "的while结果为：" + Arrays.toString(arr));
                }
                arr[j + step] = temp;
                System.out.println("i为" + i + "的for结果为：" + Arrays.toString(arr));
            }
            System.out.println("step为" + step + "的排序结果为：" + Arrays.toString(arr));
        }
    }
}
