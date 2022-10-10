package com.whl.leekcode.easy.offer10;

/**
 * 解答见leekCode70
 * https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/solution/mian-shi-ti-10-ii-qing-wa-tiao-tai-jie-wen-ti-dong/
 * @author liaowenhui
 * @date 2022/7/19 9:51
 */
public class Two {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    /**
     * 方法一 滚动数组思想
     * 用「滚动数组思想」把空间复杂度优化成 O(1)O(1)
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }


}
