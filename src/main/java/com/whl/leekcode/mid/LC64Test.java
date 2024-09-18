package com.whl.leekcode.mid;

/**
 * 最小路径和 HOT64
 * @author liaowenhui
 * @date 2022/7/21 9:05
 */
public class LC64Test {

    public static void main(String[] args) {
        int[][] grid = {
                new int[]{1,3,1},
                new int[]{1,5,1},
                new int[]{4,2,1}
        };

        System.out.println(minPathSum(grid));
    }

    /**
     * 1 <= m, n <= 200
     * 步骤一: 定义数组元素的含义 dp[i][j]表示到ij的最小路径和
     * 步骤二：找出关系数组元素间的关系式 dp[i][j] = max(dp[i-1][j]，dp[i][j-1]) + grid[i][j]
     * 步骤三：找出初始值 i或者j=0
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int columns = grid[0].length;

        int[][] f = new int[row][columns];
        f[0][0] = grid[0][0];

        for (int i = 1; i < row; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < columns; i++) {
            f[0][i] = f[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < columns; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }
        return f[row - 1][columns - 1];
    }


}
