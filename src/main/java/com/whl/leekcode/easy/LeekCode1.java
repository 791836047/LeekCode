package com.whl.leekcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * ali
 * https://leetcode.cn/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
 * @author liaowenhui
 * @date 2022/7/13 10:34
 */
public class LeekCode1 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int taget = 9;
        System.out.println(Arrays.toString(twoSum(nums, taget)));
    }

    /**
     * 方法一：暴力枚举
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 方法二：哈希表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }


}
