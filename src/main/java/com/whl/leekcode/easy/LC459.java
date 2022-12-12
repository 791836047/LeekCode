package com.whl.leekcode.easy;/**

/**
 *https://leetcode.cn/problems/repeated-substring-pattern/
 *  重复的子字符串(10.11看)
 * @author liaowenhui
 * @date 2022/10/11 10:24
 */
public class LC459 {
    public static void main(String[] args) {
        String s = "abcabcabcabc";
        System.out.println(repeatedSubstringPattern(s));
    }

    /**
     * 方法一 枚举
     * 如果一个长度为 nnn 的字符串 s 可以由它的一个长度为 n′的子串 s′重复多次构成，那么：
     * n一定是 n′的倍数；
     * s′一定是s的前缀；
     *
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        //(1)因为子串至少需要重复一次，所以 n'不会大于 n 的一半
        for (int i = 1; i * 2 <= n; ++i) {
            //(2)n 一定是 n' 的倍数
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    //(3) s[i]=s[i−n′]
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

}
