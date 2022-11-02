package com.whl.leekcode.easy;/**
 * @author liaowenhui
 * @date 2022/10/13 10:17
 */

/**
 * 只出现一次的数字 荣耀校招
 * @author liaowenhui
 * @date 2022/10/13 10:17
 */
public class LC136 {

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};

        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }


}
