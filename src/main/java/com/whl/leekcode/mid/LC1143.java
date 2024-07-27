package com.whl.leekcode.mid;

/**
 * 最长公共子序列LCS
 * https://leetcode.cn/problems/longest-common-subsequence/solutions/696763/zui-chang-gong-gong-zi-xu-lie-by-leetcod-y7u0/
 * @author 79183
 * @date 2024/7/3 10:50
 */
public class LC1143 {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println("result:" + longestCommonSubsequence(text1, text2));
    }


    /**
     * * 最长公共子序列问题是典型的二维动态规划问题。
     *      * 时间复杂度：O(mn)，其中 m 和 n 分别是字符串 text1和 text2的长度。二维数组 dp 有 m+1 行和 n+1 列，需要对 dp 中的每个元素进行计算。
     *      * 空间复杂度：O(mn)，其中 m 和 n 分别是字符串 text1和 text2的长度。创建了 m+1 行 n+1 列的二维数组 dp。
     *
     * 动态规划问题的一般形式就是求最值
     * 动态规划
     * 题目内条件amount>=0
     * <p>
     * # 自底向上迭代的动态规划
     * # 初始化 base case
     * dp[0][0][...] = base case
     * # 进行状态转移
     * for 状态1 in 状态1的所有取值：
     * for 状态2 in 状态2的所有取值：
     * for ...
     * dp[状态1][状态2][...] = 求最值(选择1，选择2...)
     * <p>
     * 时间复杂度：O(Sn)，其中 S 是金额，n 是面额数。我们一共需要计算 O(S) 个状态，S 为题目所给的总金额。对于每个状态，
     * 每次需要枚举 n 个面额来转移状态，所以一共需要 O(Sn) 的时间复杂度。
     * 空间复杂度：O(S)。数组 dp 需要开长度为总金额 S的空间。
     *
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();

        //dp[i][j] 表示 text1​[0:i] 和 text2​[0:j] 的最长公共子序列的长度。
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
