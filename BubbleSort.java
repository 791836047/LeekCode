package com.whl.leekcode.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author liaowenhui
 * @date 2021/12/23 13:57
 */
public class BubbleSort {
    public static final int SIZE = 10;

    public static void main(String[] args) {
        int[] datas = new int[SIZE];
        int i;
        //初始化数组值
        for (i = 0; i < SIZE; i++) {
            //Math.random()是令系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 值
            datas[i] = (int) (100 + Math.random() * (100 + 1));
        }

        System.out.print("排序前的数组为：\n");
        for (i = 0; i < SIZE; i++) {
            System.out.print(datas[i] + " ");
        }

        System.out.print("\n");
        //冒泡排序
        bubbleSort(datas);

        System.out.print("排序后的数组为：\n");
        for (i = 0; i < SIZE; i++) {
            System.out.print(datas[i] + " ");
        }
    }

    public static void bubbleSort(int[] datas) {
        int temp;
        //是否交换的标志，即：这一轮没有发生交换，说明数据的顺序已经排好，没有必要继续进行下去。
        boolean flag ;
        //外面的循环是排序趟数，总共进行N-1趟排序
        for (int i = 1; i < datas.length; i++) {
            // 每次遍历标志位都要先置为false，才能判断后面的元素是否发生了交换
            flag = false;

            //里面的循环是相邻的比较
            for (int j = 0; j < datas.length - 1; j++) {
                if (datas[j] > datas[j + 1]) {
                    temp = datas[j];
                    datas[j] = datas[j + 1];
                    datas[j + 1] = temp;
                    //只要有发生了交换，flag就置为true
                    flag = true;
                }
            }
            System.out.print("第" + i + "步排序结果为：");
            for (int k = 0; k < datas.length; k++) {
                System.out.print(" " + datas[k]);
            }
            System.out.print("\n");
            // 判断标志位是否为false，如果为false，说明后面的元素已经有序，就直接return
            if (!flag) {
                break;
            }
        }
    }

}
