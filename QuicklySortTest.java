package com.whl.leekcode.sort;

import java.util.Arrays;

public class QuicklySortTest {
    public static void main(String[] args) {
        int[] s = new int[]{72, 6, 57, 88, 60, 42, 83, 6, 73, 48, 85};
        int r = s.length - 1;
        int l = 0;
        System.out.println("排序前" + Arrays.toString(s));
        quickSort(s, l, r);
        System.out.println("排序后" + Arrays.toString(s));
    }

    static void quickSort(int[] s, int l, int r) {
        if (l < r) {
            int i = l,j=r,x = s[l];
            while (i < j){
                while (i < j && s[j] > x) {
                    j--;
                }
                while(i<j){
                    //!!
                    s[i++] = s[j];
                }

                while(i < j && s[i] < x){
                    i++;
                }
                while (i<j){
                    s[j++] = s[i];
                }

            }
            //!!
            s[i] = x;
            //!!
            quickSort(s,l,i-1);
            quickSort(s,i+1,r);
        }
    }
}
