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

    /**
     * 任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a
     * 任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
     * 异或运算满足交换律和结合律，即 a⊕b⊕a = b⊕a⊕a = b⊕(a⊕a) = b⊕0=b

     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single = single ^ num;
        }
        return single;
    }


}
