package com.whl.leekcode.mid;

import java.util.Arrays;

/**
 * 颜色分类
 * @author liaowenhui
 * @date 2023/3/31 10:21
 */
public class LC75 {

    /**
     * 方法一：单指针
     * 时间复杂度：O(n)，其中 n 是数组 nums的长度。
     * 空间复杂度：O(1)。
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                //!! ++
                ++ptr;
            }
        }
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }

    /**
     * 方法二双指针
     * 时间复杂度：O(n)，其中 n 是数组 nums 的长度。
     * 空间复杂度：O(1)。
     * @param nums
     */
    public static void sortColors2(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            //!!注意是while不是if，可能P2位置就是2，然后换了后还是2
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            //!!注意是if
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums =  new int[]{2,0,2,1,1,2};
        sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
