package com.whl.leekcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 找到字符串中所有字母异位词
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked
 * @author liaowenhui
 * @date 2023/6/21 16:52
 */
public class HOT438 {

    public static void main(String[] args) {
        System.out.println("结果为：" + findAnagrams("cbaebabacd", "abc"));
    }

    /**
     * 评论中热门解法
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        // 一般都用26容量的数组，但这样的话每个字母作下标时都要 c-'a'，写起来比较繁琐，
        // 因为128也好，26也好，都是常数级空间，没必要太省，
        // 直接ASCII码128个作为数组长度，这样统计每个字符时就直接用c作下标，刚好是0-127，
        // 如此一来，不光是英文字母的串，任何可打印字符都能装进去
        int[] cnt = new int[128];
        for (char c : p.toCharArray()) {
            cnt[c]++;
        }
        //low为子串的起始索引  high
        int lo = 0, hi = 0;
        List<Integer> res = new ArrayList<>();
        while (hi < s.length()) {
            //如果遇到没有的字符，high原地等待；low++遍历到这个字符后（即low比high多1后），下一次high也会消耗掉这个没有的字符
            if (cnt[s.charAt(hi)] > 0) {
                //！！理解int i = 0; int a = i++; // a的值为0，i的值为1
                cnt[s.charAt(hi++)]--;
                if (hi - lo == p.length()) {
                    res.add(lo);
                }
            } else {
                //右移左边界lo、复位计数器，直到这个条件（子集条件）再次满足
                cnt[s.charAt(lo++)]++;
            }
        }
        return res;
    }
}
