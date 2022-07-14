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

    }
}
