package com.whl.leekcode.mid;/**
 * @author liaowenhui
 * @date 2022/12/8 11:22
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串(字节，高频)
 * @author liaowenhui
 * @date 2022/12/8 11:22
 */
public class LC3 {

    public static void main(String[] args) {
        String str = "abcabcbb";
        int result = lengthOfLongestSubstring(str);
        System.out.println("最长字串为:" + result);
    }

    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            //occ.size()用rk - i + 1替代也行
            ans = Math.max(ans,occ.size());
        }
        return ans;
    }

}
