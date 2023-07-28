package com.whl.leekcode.mid;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 每日温度  下一个更高温度出现在几天后
 * 解法跟42接雨水和84柱状图最大矩形类似
 *
 * 这题考的基础模型其实就是：在一维数组中对每一个数找到第一个比自己小(或大)的元素。这类“在一维数组中找第一个满足某种条件的数”的场景就是典型的单调栈应用场景。
 * @author liaowenhui
 * @date 2023/6/26 16:35
 */
public class HOT739 {

    public static void main(String[] args) {
        HOT739 hot739 = new HOT739();
        System.out.println("result:" + Arrays.toString(hot739.dailyTemperaturesTest(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));

    }

    /**
     * 单调栈
     * 时间复杂度：O(n)，其中n 是温度列表的长度。正向遍历温度列表一遍，对于温度列表中的每个下标，最多有一次进栈和出栈的操作。
     * 空间复杂度：O(n)，其中n 是温度列表的长度。需要维护一个单调栈存储温度列表中的下标。
     *。
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * 自写100%
     * @param temperatures
     * @return
     */
    public int[] dailyTemperaturesTest(int[] temperatures){
        //8
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]){
                //!!命名注意下
                Integer pop = stack.pop();
                ans[pop] = i - pop;
            }
            stack.push(i);
        }
        return ans;
    }


}
