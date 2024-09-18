package com.whl.leekcode.mid;

/**
 * 最小路径和  7.25写失败
 * @author liaowenhui
 * @date 2022/7/21 9:05
 */
public class LC64 {


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
     *
     * 步骤一: 定义数组元素的含义   dp[i][j] 表示从左上角出发到 (i,j) 位置的最小路径和。
     * 步骤二：找出关系数组元素间的关系式    dp[i][j]=min(dp[i−1][j],dp[i][j−1])+grid[i][j]
     * 步骤三：找出初始值
     *          dp[0][0] = grid[0][0];
     *          dp[0] [j] =  dp[0] [j-1] + grid[0][j]; // 相当于最上面一行，机器人只能一直往右走
     *          dp[i][0]=    dp[i−1][0]+  grid[i][0]；  // 相当于最左面一列，机器人只能一直往下走
     *
     * 时间复杂度：O(mn)O(mn)，其中 mm 和 nn 分别是网格的行数和列数。需要对整个网格遍历一次，计算 \textit{dp}dp 的每个元素的值。
     * 空间复杂度：O(mn)O(mn)，其中 mm 和 nn 分别是网格的行数和列数。创建一个二维数组 \textit{dp}dp，和网格大小相同。
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        //grid.length 行 本例中为3  !!
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;

        //rows相当于Y轴，第几行  columns相当于X轴，第几列
        int[][] dp = new int[rows][columns];
        //!!
        dp[0][0] = grid[0][0];

        //相当于最左下角的点
        for (int i = 1; i < rows; i++) {
            //!!
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //相当于最右上角的点
        for (int j = 1; j < columns; j++) {
            //!!
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }

}
