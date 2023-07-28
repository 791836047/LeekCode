package com.whl.leekcode.mid;

import java.util.Arrays;

/**
 * 最长递增子序列
 *
 * https://labuladong.gitee.io/algo/di-er-zhan-a01c6/dong-tai-g-a223e/dong-tai-g-6ea57/
 * @author liaowenhui
 * @date 2023/7/6 10:48
 */
public class LC300 {

    public static void main(String[] args) {
        LC300 lc300 = new LC300();
        System.out.println("result:" + lc300.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    int lengthOfLIS(int[] nums) {
        // 定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // base case：dp 数组全都初始化为 1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 寻找 nums[0..j-1] 中比 nums[i] 小的元素
                if (nums[i] > nums[j]) {
                    // 把 nums[i] 接在后面，即可形成长度为 dp[j] + 1，
                    // 且以 nums[i] 为结尾的递增子序列
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
        }

        int res = 0;
        for (int value : dp) {
            res = Math.max(res, value);
        }
        return res;
    }
}
