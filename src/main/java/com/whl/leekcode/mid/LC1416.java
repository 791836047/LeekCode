package com.whl.leekcode.mid;

/**
 *  分割等和子集
 *  此题等价于：是否可以从输入数组中挑选出一些正整数，使得这些数的和 等于 整个数组元素的和的一半。容易知道：数组的和一定得是偶数。
 *  解题思路：https://leetcode.cn/problems/partition-equal-subset-sum/solutions/13059/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/
 * @author liaowenhui
 * @date 2023/7/10 9:45
 */
public class LC1416 {
    public static void main(String[] args) {

        LC1416 lc1416 = new LC1416();
        boolean b = lc1416.canPartition(new int[]{1, 5, 11, 5});
        System.out.println("result:" + b);

    }

    /**
     * 转为背包问题
     * @param nums
     * @return
     */
    boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 和为奇数时，不可能划分成两个和相等的集合
        if (sum % 2 != 0) {
            return false;
        }
        int n = nums.length;
        sum = sum / 2;

        /**
         * 状态定义：dp[i][j]表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和恰好等于 j
         * dp[i][j] = x 表示，对于前 i 个物品（i 从 1 开始计数），当前背包的容量为 j 时，若 x 为 true，则说明可以恰好将背包装满，若 x 为 false，则说明不能恰好将背包装满。
         */
        boolean[][] dp = new boolean[n + 1][sum + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    // 背包容量不足，不能装入第 i 个物品，那得看上次
                    dp[i][j] = dp[i - 1][j];
                } else {
                    /**
                     * 不装入背包或装入
                     * 不选择 nums[i]，如果在 [0, i - 1] 这个子区间内已经有一部分元素，使得它们的和为 j ，那么 dp[i][j] = true；
                     * 选择 nums[i]，如果在 [0, i - 1] 这个子区间内就得找到一部分元素，使得它们的和为 j - nums[i]。
                     *
                     * 由于 dp 数组定义中的 i 是从 1 开始计数，而数组索引是从 0 开始的，所以第 i 个物品的重量应该是 nums[i-1]，这一点不要搞混。
                     */
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    /**
     * 20230713自写  70%
     * @param nums
     * @return
     */
    boolean canPartitionTest(int[] nums){

        int sum =0;
        for (int num : nums) {
            sum+= num;
        }
        if (sum % 2 !=0){
            return false;
        }
        //背包容量
        sum = sum / 2;
        int n = nums.length;
        //dp[i][j]
        Boolean[][] dp = new Boolean[n+1][sum+1];
        //!!
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i-1] < 0){
                    //!!
                    dp[i][j] = dp[i-1][j- nums[i-1]];
                }else {
                    //!!
                    dp[i][j] = dp[i-1][j- nums[i-1]] || dp[i][j];
                }

            }
        }
        return dp[n+1][sum+1];
    }


    /**
     * 进一步优化   注意到 dp[i][j] 都是通过上一行 dp[i-1][..] 转移过来的，之前的数据都不会再使用了。
     * @param nums
     * @return
     */
    boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 和为奇数时，不可能划分成两个和相等的集合
        if (sum % 2 != 0) {
            return false;
        }
        int n = nums.length;
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];

        // base case
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= 0; j--) {
                //背包装的下
                if (j - nums[i] >= 0) {
                    //不装入背包或装入

                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }

}
