package com.whl.leekcode.mid;

/**
 * @author liaowenhui
 * @date 2023/6/15 9:54
 */
public class HOT45 {

    public static void main(String[] args) {
        System.out.println("最小跳跃次数:" + jump( new int[]{2,3,1,1,4}));
    }

    /**
     * 时间复杂度：O(n)，其中 n 是数组长度。
     * 空间复杂度：O(1)。
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int length = nums.length;
        //当前能够到达的最大下标位置，记为边界。
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                //到达边界时，更新边界并将跳跃次数增加 1
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    /**
     * 90% ok
     * @param nums
     * @return
     */
    public static int jumpTest(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        int end = 0;
        int jumptime = 0;
        //!!
        for (int i = 0; i < n; i++) {
            rightmost = Math.max(rightmost, i + nums[i]);
            if (i == end) {
                end = rightmost;
                jumptime++;
            }
        }
        return jumptime;

    }


}
