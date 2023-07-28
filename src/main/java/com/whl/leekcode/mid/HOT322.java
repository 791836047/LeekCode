package com.whl.leekcode.mid;

import java.util.Arrays;

/**
 * 零钱兑换 不懂
 * 腾讯2
 * @author liaowenhui
 * @date 2023/7/3 10:26
 */
public class HOT322 {

    public static void main(String[] args) {

        HOT322 hot322 = new HOT322();
        int i = hot322.coinChange(new int[]{1, 2, 5}, 11);
        System.out.println("result:" + i );

    }

    /**
     * 动态规划问题的一般形式就是求最值
     * 动态规划
     * 题目内条件amount>=0
     *
     * # 自底向上迭代的动态规划
     * # 初始化 base case
     * dp[0][0][...] = base case
     * # 进行状态转移
     * for 状态1 in 状态1的所有取值：
     *     for 状态2 in 状态2的所有取值：
     *         for ...
     *             dp[状态1][状态2][...] = 求最值(选择1，选择2...)
     *
     * 时间复杂度：O(Sn)，其中 S 是金额，n 是面额数。我们一共需要计算 O(S) 个状态，S 为题目所给的总金额。对于每个状态，
     * 每次需要枚举 n 个面额来转移状态，所以一共需要 O(Sn) 的时间复杂度。
     * 空间复杂度：O(S)。数组 dp 需要开长度为总金额 S的空间。
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        /**
         * 为啥 dp 数组中的值都初始化为 amount + 1 呢，因为凑成 amount 金额的硬币数最多只可能等于 amount（全用 1 元面值的硬币），
         * 所以初始化为 amount + 1 就相当于初始化为正无穷，便于后续取最小值。
         * 为啥不直接初始化为 int 型的最大值 Integer.MAX_VALUE 呢？因为后面有 dp[i - coin] + 1，这就会导致整型溢出。
         */
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        //必须将所有的dp赋最大值，因为要找最小值
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                    //定义 dp(i) 为组成金额 i所需最少的硬币数量，一开始dp[i]为amount+1
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        //正常都是dp[amount]比较小，大于amount说明兑换不成功
        return dp[amount] > amount ? -1 : dp[amount];
    }


}
