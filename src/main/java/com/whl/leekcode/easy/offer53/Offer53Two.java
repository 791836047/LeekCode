package com.whl.leekcode.easy.offer53;

/**
 * https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/solution/0n-1zhong-que-shi-de-shu-zi-by-leetcode-0x0bf/
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * @author liaowenhui
 * @date 2022/7/5 10:08
 */
public class Offer53Two {

    public static void main(String[] args) {
        int[] testArray = new int[]{0,1,2,3,4,5,6,7,9};
        System.out.println("0～n-1中缺失的数字:" + missingNumber(testArray));
        System.out.println("0～n-1中缺失的数字:" + missingNumber2(testArray));
        System.out.println("0～n-1中缺失的数字:" + missingNumber3(testArray));


    }


    /**
     * 方法一 高斯求和公式
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int total = n * (n - 1) / 2;
        int arrSum = 0;
        for (int i = 0; i < n - 1; i++) {
            arrSum += nums[i];
        }
        return total - arrSum;
    }

    /**
     * 方法2 二分法
     * @param nums
     * @return
     */
    public static int missingNumber2(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    /**
     * 方法3
     * @param nums
     * @return
     */
    public static int missingNumber3(int[] nums) {
        if (nums[0] == 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }


}
