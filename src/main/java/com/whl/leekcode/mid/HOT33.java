package com.whl.leekcode.mid;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 搜索旋转排序数组
 *
 * @author 79183
 * @date 2024/8/6 10:43
 */
public class HOT33 {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};

        int search = search(nums, 0);
    }

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                //5670123
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
