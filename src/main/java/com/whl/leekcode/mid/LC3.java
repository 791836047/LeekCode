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
        String str = "pwwkew";
        int result = lengthOfLongestSubstring2(str);
        System.out.println("最长字串为:" + result);
    }

    /**
     * 滑动窗口
     * 时间复杂度：O(N)，其中 N 是字符串的长度。左指针和右指针分别会遍历整个字符串一次。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> charSet = new HashSet<>();
        //6
        int n = s.length();
        // 右指针rk，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        //mlStrSize为最长字符的大小
        int rk = -1, mlStrSize = 0;
        //左指针i
        for (int lk = 0; lk < n; ++lk) {
            //!!注意理解,不是rk！=-1
            if (lk != 0) {
                // 左指针向右移动一格，移除一个字符
                //!!不是rk
                charSet.remove(s.charAt(lk - 1));
            }
            //pwwkew
            while (rk + 1 < n && !charSet.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                charSet.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            //occ.size()用rk - i + 1替代也行
            mlStrSize = Math.max(mlStrSize, charSet.size());
        }
        return mlStrSize;
    }

    /**
     * 滑动窗口 优化版 推荐
     * 你使用 i 和 j 两个指针来表示窗口的左边界和右边界。
     * 当窗口内的字符没有重复时，你将右边界 j 向右移动，扩大窗口。
     * 当窗口内的字符出现重复时，你将左边界 i 向右移动，缩小窗口。
     * 测试  pwwkew
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                ans = Math.max(ans, j - i + 1);
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }


}
