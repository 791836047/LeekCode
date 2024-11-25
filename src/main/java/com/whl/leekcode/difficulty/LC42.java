package com.whl.leekcode.difficulty;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.cn/problems/trapping-rain-water/description/
 *  接雨水
 * @author liaowenhui
 * @date 2023/3/30 10:09
 */
class LC42 {

    /**
     * 方法一： 单调栈 （推荐）
     * 时间复杂度：O(n)，其中 n 是数组 height 的长度。从 0到 n−1 的每个下标最多只会入栈和出栈各一次。
     * 空间复杂度：O(n)，其中 n 是数组 height 的长度。空间复杂度主要取决于栈空间，栈的大小不会超过 n。
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int ans = 0;
        //!!注意存的是下标
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            //！！ 注意是while 处理1002这样的情况
            //注意此时i还没入栈
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                //!! 处理第一个值为0的问题
                if (stack.isEmpty()) {
                    break;
                }
                //height[left] 大于或者等于top
                int left = stack.peek();
                int currWidth = i - left - 1;
                //!!注意高度的计算
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * 栈的方法自写  suc-100%
     * @param height
     * @return
     */
    public static int trap1Test(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int length = height.length;
        int ans = 0;

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                Integer top = stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                Integer left = stack.peek();
                int wide = i - left -1;
                int heigh = Math.min(height[i],height[left]) - height[top];

                ans +=  heigh * wide;
            }

            stack.push(i);
        }

        return ans;
    }


        /**
         * 理解思路
         * 方法2 双指针
         * 时间复杂度：O(n)，其中 n是数组 height 的长度。两个指针的移动总次数不超过 n。
         * 空间复杂度：O(1)。只需要使用常数的额外空间。
         * @param height
         * @return
         */
    public static int trap2(int[] height) {
        //{0,2,0,1,0,3}
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            //注意理解如果 height[left]<height[right]，则必有 leftMax<rightMax
            if (height[left] < height[right]) {
                //!!注意不是直接 ans += height[left]
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }

    /**
     * 23.6.8 suc-100%
     * @param height
     * @return
     */
    public static int trap2Test(int[] height) {
        int right = height.length - 1;
        int left = 0;
        int ans = 0;
        int maxLeft = 0;
        int maxright = 0;

        while (left < right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxright = Math.max(maxright, height[right]);

            if (height[left] < height[right]) {
                ans += height[left];

                left++;
            } else if (height[left] > height[right]) {
                ans += height[right];

                right++;
            }

        }

        return ans;
    }


    public static void main(String[] args) {
        int[] multiplePeakArray = {0,2,0,1,0,3};
        //int[] multiplePeakArray = {0,1,0,0,2};
        System.out.println("结果为："+ LC42.trap2(multiplePeakArray));
    }

}
