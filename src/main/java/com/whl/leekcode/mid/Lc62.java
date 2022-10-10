package com.whl.leekcode.mid;

/**
 * 不同路径  7.25写
 * @author liaowenhui
 * @date 2022/7/19 15:50
 */
public class Lc62 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
    }

    /**
     * 方法一 动态规划
     * 时间复杂度：O(mn)O(mn)。
     * 1 <= m, n <= 100
     *
     * 步骤一: 定义数组元素的含义   dp[m][n]的含义为：当机器人从左上角走到(m, n) 这个位置时，一共有 dp[m][n] 种路径
     * 步骤二：找出关系数组元素间的关系式  dp[m][n] = dp[m-1][n] + dp[m][n-1]。
     * 步骤三：找出初始值  上面关系式中，如果m或者n有一个为 0，不成立
     *                      dp[0][0….n-1] = 1; // 相当于最上面一行，机器人只能一直往右走
     *                      dp[0…m-1] [0] = 1; // 相当于最左面一列，机器人只能一直往下走
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        //m相当于Y轴
        int[][] f = new int[m][n];

        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        //数组是从0开始的
        return f[m - 1][n - 1];
    }

}
