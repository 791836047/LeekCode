package com.whl.leekcode.mid;/**
 * @author liaowenhui
 * @date 2022/9/23 10:57
 */

import java.util.*;

/**
 *  三数之和  字节1
 * @author liaowenhui
 * @date 2022/9/23 10:57
 */
public class LC15 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists.toString());
    }

    /**
     * 热门解法  https://leetcode.cn/problems/3sum/solutions/12307/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
     * 双指针
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(len < 3) {
            return ans;
        }
        // 排序  -4，-1，-1，0，1，2
        Arrays.sort(nums);
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) {
                // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]) {
                continue; // 去重
            }
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    //!!
                    while (L<R && nums[L] == nums[L+1]) {
                        L++; // 去重
                    }
                    while (L<R && nums[R] == nums[R-1]) {
                        R--; // 去重
                    }
                    //!!同时
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return ans;
    }

    }
