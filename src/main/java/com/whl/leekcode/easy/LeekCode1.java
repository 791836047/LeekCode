package com.whl.leekcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和  阿里
 *
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
     * 时间复杂度O(n^2),其中N 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次
     * 空间复杂度O(1)
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
     * 时间和空间复杂度都是O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        //!泛型不支持基本数据类型
        Map<Integer, Integer> hashtable = new HashMap<>();
        //!注意是分号不是逗号
        for (int i = 0; i < nums.length; ++i) {
            //!注意是containsKey
            if (hashtable.containsKey(target - nums[i])) {
                //！注意怎么返回
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
    }
