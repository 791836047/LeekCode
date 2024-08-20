package com.whl.leekcode.mid;

import java.util.Arrays;

/**
 * 旋转图像
 * @author 79183
 * @date 2024/8/16 10:08
 */
public class HOT48 {


    /**
     * 用翻转代替旋转
     * https://leetcode.cn/problems/rotate-image/solutions/526980/xuan-zhuan-tu-xiang-by-leetcode-solution-vu3m/
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        //几行   几列的话是matrix[0].length
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }



    public static void main(String[] args) {
      /*  1 2 3     7 4 1
          4 5 6     8 5 2
          7 8 9     9 6 3
      */
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }
}
