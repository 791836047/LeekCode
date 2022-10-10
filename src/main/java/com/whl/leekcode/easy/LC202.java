package com.whl.leekcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/happy-number/solution/kuai-le-shu-by-leetcode-solution/ 看分析
 * 快乐数   19
 * @author liaowenhui
 * @date 2022/7/27 16:16
 */
public class LC202 {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    /**
     * 方法一 用哈希集合检测循环
     * @param n
     * @return
     */
    private static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

}
