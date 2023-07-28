package com.whl.leekcode.mid;

/**
 * 打家劫舍
 * https://leetcode.cn/problems/house-robber/solution/da-jia-jie-she-by-leetcode-solution/
 * @author liaowenhui
 * @date 2022/7/22 10:26
 */
public class LC198 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(rob(nums));
    }

    /**
     * 方法一: 动态规划
     *
     * 步骤一: 定义数组元素的含义 用dp[i]表示前i间房屋能偷窃到的最高总金额
     *
     * 步骤二：找出关系数组元素间的关系式  dp[i]=max(dp[i−2]+nums[i],dp[i−1])
     *  对于第 k (k>2)间房屋，有两个选项：
     * （1）偷窃第 k 间房屋，那么就不能偷窃第 k−1间房屋，偷窃总金额为前 k−2 间房屋的最高总金额与第 k 间房屋的金额之和。
     * （2）不偷窃第 k间房屋，偷窃总金额为前 k−1 间房屋的最高总金额。
     * 在两个选项中选择偷窃总金额较大的选项，该选项对应的偷窃总金额即为前 k间房屋能偷窃到的最高总金额。
     *
     * 步骤三：找出初始值
     *          dp[0] = nums[0]  只有一间房屋，则偷窃该房屋
     *          dp[1] = max(nums[0],nums[1]) 只有两间房屋，选择其中金额较高的房屋进行偷窃
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }


    /**
     * 方法2：滚动数组
     * 考虑到每间房屋的最高总金额只和该房屋的前两间房屋的最高总金额相关，因此可以使用滚动数组，在每个时刻只需要存储前两间房屋的最高总金额。
     *
     * 时间复杂度：O(n)，其中 n 是数组长度。只需要对数组遍历一次。
     * 空间复杂度：O(1)。使用滚动数组，可以只存储前两间房屋的最高总金额，而不需要存储整个数组的结果，因此空间复杂度是 O(1)。
     *
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }



}
