package com.whl.leekcode.sort;

import java.util.Arrays;

/**
 * 菜鸟--https://www.runoob.com/w3cnote/sort-algorithm-summary.html
 * 归并排序是建立在归并操作上的一种有效的排序算法。将2个有序数列合并，只要从比较2个数列的第一个数，谁小就先取谁，取了后就在对应数列中删除这个数。然后再进行比较，如果有数列为空，那直接将另一个数列的数据依次取出即可。
 * 平均时间复杂度：O(NlogN)
 * 归并排序的效率是比较高的，设数列长为N，将数列分开成小数列一共要logN步，每步都是一个合并有序数列的过程，时间复杂度可以记为O(N)，故一共为O(N*logN)
 * @author liaowenhui
 * @date 2021/12/28 10:57
 */
public class MergeSort {
    public static final int SIZE = 10;
    public static void main(String[] args) {
        int[] temp = new int[SIZE];
        /*int[] datas = new int[SIZE];

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
        merge_sort(datas, 0, datas.length - 1, temp);

        System.out.print("排序后的数组为：\n");
        for (i = 0; i < SIZE; i++) {
            System.out.print(datas[i] + " ");
        }*/

        int[] testArray = new int[]{36,20,17,13,28,14,23,25};
        merge_sort(testArray, 0, testArray.length - 1, temp);
        System.out.print("结果为:" + Arrays.toString(testArray));
    }

    public static void merge_sort(int[] a, int first, int last, int[] temp) {

        if (first < last) {
            int middle = (first + last) / 2;
            //左半部分排好序
            merge_sort(a, first, middle, temp);
            //右半部分排好序
            merge_sort(a, middle + 1, last, temp);
            //合并左右部分
            mergeArray(a, first, middle, last, temp);
        }
    }

    /**
     * 合并 ：将两个序列a[first-middle],a[middle+1-end]合并
     * @param a
     * @param first
     * @param middle
     * @param end
     * @param temp
     */
    public static void mergeArray(int a[],int first,int middle,int end,int temp[]){
        int i = first;
        int m = middle;
        int j = middle+1;
        int n = end;
        int k = 0;
        while(i<=m && j<=n){
            if(a[i] <= a[j]){
                temp[k] = a[i];
                k++;
                i++;
            }else{
                temp[k] = a[j];
                k++;
                j++;
            }
        }
        while(i<=m){
            temp[k] = a[i];
            k++;
            i++;
        }
        while(j<=n){
            temp[k] = a[j];
            k++;
            j++;
        }

        for(int ii=0;ii<k;ii++){
            a[first + ii] = temp[ii];
        }
    }

}
