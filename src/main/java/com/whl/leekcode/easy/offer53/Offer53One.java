package com.whl.leekcode.easy.offer53;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * @author liaowenhui
 * @date 2022/7/5 10:08
 */
public class Offer53One {
    public static int search(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return rightIdx - leftIdx + 1;
        }
        return 0;
    }

    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            //mid =2
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{5,7,7,8,8,10};
        System.out.println("在排序数组中查找数字:" + search(testArray,8));
    }

}
