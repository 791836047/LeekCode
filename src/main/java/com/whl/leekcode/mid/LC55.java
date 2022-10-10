package com.whl.leekcode.mid;

/**
 *  跳跃游戏  搜狐  贪心算法
 * @author liaowenhui
 * @date 2022/7/28 15:04
 */
public class LC55 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        //最远可到达位置(数组的下标)
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            //防止出现new int[]{2, 0,0, 3, 1, 1, 4};这种情况
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
