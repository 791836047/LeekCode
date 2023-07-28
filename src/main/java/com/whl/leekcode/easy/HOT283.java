package com.whl.leekcode.easy;

import java.util.Arrays;

/**
 * 移动零
 * @author liaowenhui
 * @date 2023/5/11 9:19
 */
public class HOT283 {

    /**
     * 双指针
     *
     * 思路及解法
     * 使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
     * 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
     * 注意到以下性质：
     * 左指针左边均为非零数；
     * 右指针左边直到左指针处均为零。
     * 因此每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变。
     *
     * 时间复杂度：O(n)，其中 n为序列长度。每个位置至多被遍历两次。
     * 空间复杂度：O(1)。只需要常数的空间存放若干变量。
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        HOT283 hot283 = new HOT283();
        int[] ints = {0, 1, 0, 3, 12};
        hot283.moveZeroes(ints);
        System.out.println("结果为：" + Arrays.toString(ints));

    }
}
