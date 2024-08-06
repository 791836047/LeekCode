package com.whl.leekcode.mid;

import java.util.Arrays;

/**
 * 下一个排列
 *
 * @author 79183
 * @date 2024/8/6 10:43
 */
public class HOT31 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3};
        nextPermutation(nums);
        //1,3,2,4,
        System.out.println("result:" + Arrays.toString(nums));
    }


    /**
     * 时间复杂度：O(N)，其中 N 为给定序列的长度。我们至多只需要扫描两次序列，以及进行一次反转操作。
     * 空间复杂度：O(1)，只需要常数的空间存放若干变量。
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //先比较最后两位
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

}
