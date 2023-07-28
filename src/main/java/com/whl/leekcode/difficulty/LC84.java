package com.whl.leekcode.difficulty;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 柱状图最大矩形
 * @author liaowenhui
 * @date 2023/6/27 9:58
 */
public class LC84 {

    public static void main(String[] args) {
        LC84 lc84 = new LC84();
        System.out.println("result:" + lc84.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    /**
     * 找到左右两侧最近的高度小于 h 的柱子，这样这两根柱子之间（不包括其本身）的所有柱子高度均不小于 h，并且就是 i 能够扩展到的最远范围。
     *
     * 单调栈 + 常数优化
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];

            Deque<Integer> monoStack = new LinkedList<>();
            for (int i = 0; i < n; ++i) {
                while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                    monoStack.pop();
                }
                left[i] = (monoStack.isEmpty() ? -1 : monoStack.peek());
                monoStack.push(i);
            }

            //移除monoStack所有元素
            monoStack.clear();
            for (int i = n - 1; i >= 0; --i) {
                while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]) {
                    monoStack.pop();
                }
                right[i] = (monoStack.isEmpty() ? n : monoStack.peek());
                monoStack.push(i);
            }

            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
            }
            return ans;
        }

}
