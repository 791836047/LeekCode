package com.whl.leekcode.easy;

/**
 * 53. 最大子数组和
 * 解题思路：https://leetcode.cn/problems/maximum-subarray/solutions/9058/dong-tai-gui-hua-fen-zhi-fa-python-dai-ma-java-dai/
 * 学习动态规划
 * @author liaowenhui
 * @date 2022/7/14 14:21
 */
public class LeekCode53 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 不空间优化的代码
     * 时间复杂度：O(N) ，这里 N是输入数组的长度。
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int len = nums.length;
        // dp[i] 表示：以 nums[i] 结尾的连续子数组的最大和
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        // 也可以在上面遍历的同时求出 res 的最大值，这里我们为了语义清晰分开写，大家可以自行选择
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 根据「状态转移方程」，dp[i] 的值只和 dp[i - 1] 有关，因此可以使用「滚动变量」的方式将代码进行优化。
     **
     * 时间复杂度 O(n)、空间复杂度 O(1)
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

}
