package com.whl.leekcode.easy;

import java.util.Arrays;

/**
 * 螺旋矩阵 II  类比54  offer29
 * @author liaowenhui
 * @date 2022/6/29 11:29
 */
public class LeekCode59 {

    public static int[][] generateMatrix(int n) {
        int l = 0, t = 0, r = n - 1, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++) {
                // left to right.
                mat[t][i] = num++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                // top to bottom.
                mat[i][r] = num++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                // right to left.
                mat[b][i] = num++;
            }
            b--;
            for (int i = b; i >= t; i--) {
                // bottom to top.
                mat[i][l] = num++;
            }
            l++;
        }
        return mat;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }



}
