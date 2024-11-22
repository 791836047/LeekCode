package com.whl.leekcode.mid;

/**
 * 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/?favorite=2cktkvj
 * @author liaowenhui
 * @date 2023/4/7 9:24
 */
public class LC10 {

    /**
     * 时间复杂度：O(N)，双指针总计最多遍历整个数组一次。
     * 空间复杂度：O(1)，只需要额外的常数级别的空间。
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            //注意长是r-l
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }

    /**
     * 100%
     * @param height
     * @return
     */
    public int maxAreaTest(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r) {
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println("result：" + maxArea(height));

    }


}
