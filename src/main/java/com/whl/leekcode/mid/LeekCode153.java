package com.whl.leekcode.mid;

/**
 * 快手
 * 153. 寻找旋转排序数组中的最小值
 * @author liaowenhui
 * @date 2022/7/4 10:54
 */
public class LeekCode153 {
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] testArray = new int[]{4,5,6,7,0,1,2};
        System.out.println("最小值:" +  findMin(testArray));
    }

}
