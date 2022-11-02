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


    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        //因为子串至少需要重复一次，所以 n'不会大于 n 的一半
        for (int i = 1; i * 2 <= n; ++i) {
            //n 一定是 n' 的倍数
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
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
