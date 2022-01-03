package com.whl.leekcode.sort;

import java.util.Arrays;

/**
 * 插入排序
 * @author liaowenhui
 * @date 2022/1/3 16:01
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 2, 6, 1, 5};
        insert_sort(arr,arr.length);
        System.out.println("排序后结果为：" + Arrays.toString(arr));
    }

    public static void  insert_sort(int[] array, int lenth){
        int temp;
        for(int i=0;i<lenth-1;i++){
            for(int j=i+1;j>0;j--){
                if(array[j] < array[j-1]){
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }else{
                    break;
                }
            }
        }
    }
}
