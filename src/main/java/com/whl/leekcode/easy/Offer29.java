package com.whl.leekcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/
 * 和LeekCode54一样
 * @author liaowenhui
 * @date 2022/6/29 15:42
 */
public class Offer29 {

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        //ｒ是多少列，ｂ是多少行
        int l = 0, t = 0, r = matrix[0].length - 1, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) {
                // left to right.
                res[x++] = matrix[t][i];
            }
            if (++t > b) {
                break;
            }
            for (int i = t; i <= b; i++) {
                // top to bottom.
                res[x++] = matrix[i][r];
            }
            if (l > --r) {
                break;
            }
            for (int i = r; i >= l; i--) {
                // right to left.
                res[x++] = matrix[b][i];
            }
            if (t > --b) {
                break;
            }
            for (int i = b; i >= t; i--) {
                // bottom to top.
                res[x++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
       /* int[][] matrix = new int[][]{
                new int[]{1,2,3},
                new int[]{4,5,6},
                new int[]{7,8,9}
        };*/

        int[][] matrix = {
                new int[]{1,2,3,4},
                new int[]{5,6,7,8},
                new int[]{9,10,11,12}
        };
        //列的长度
        System.out.println(matrix[0].length - 1);
        //行的长度
        System.out.println(matrix.length - 1);


        int[] ints = spiralOrder(matrix);
        System.out.println(Arrays.toString(ints));
    }

}
