package com.whl.leekcode.easy.offer10;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * @author liaowenhui
 * @date 2022/7/19 9:50
 */
public class One {

    public static void main(String[] args) {
        System.out.println(fib(5));
    }

    /**
     * 滚动数组思想
     * @param n
     * @return
     */
    public static int fib(int n) {
        final int MOD = 1000000007;
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }


}
