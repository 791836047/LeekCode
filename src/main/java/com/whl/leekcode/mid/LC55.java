package com.whl.leekcode.mid;

/**
 *  跳跃游戏  搜狐  贪心算法
 * @author liaowenhui
 * @date 2022/7/28 15:04
 */
public class LC55 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 3, 1, 1, 4};
        System.out.println(canJumpTest(nums));
    }

    /**
     * 时间复杂度：O(n)，其中 n 为数组的大小。只需要访问 nums 数组一遍，共 n 个位置。
     * 空间复杂度：O(1)，不需要额外的空间开销。
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        //最远可到达位置(数组的下标)
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            //防止出现new int[]{2, 0,0, 3, 1, 1, 4};这种情况根本跳不到i=3的位置
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 30%
     * @param nums
     * @return
     */
    public static boolean canJumpTest(int[] nums) {
        int l = nums.length;
        int maxJump = 0;
        for (int i = 0; i < l; i++) {
            maxJump = i + nums[i];
            if (i < maxJump && maxJump > l) {
                return true;
            }
        }
        return false;
    }

}
