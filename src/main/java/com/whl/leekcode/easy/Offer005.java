package com.whl.leekcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 剑指 Offer II 005. 单词长度的最大乘积
 * 方法2不懂
 *
 * @author liaowenhui
 * @date 2022/2/9 17:21
 */
public class Offer005 {
    public static void main(String[] args) {
        String[] words = new String[]{"abcw","baz","foo","bar","fxyz","abcdef"};
        int result = maxProduct(words);
        System.out.println("result：" + result);
    }

    /**
     * 暴力解法
     * m 表示单词的平均长度，n 表示单词的个数
     * 时间复杂度：O(n^2 * m)
     * 空间复杂度：O(1)
     * @param words
     * @return
     */
    public static int maxProduct(String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            String word1 = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String word2 = words[j];
                // 每个单词的 bitMask 会重复计算很多次
                if (!hasSameChar(word1, word2)) {
                    ans = Math.max(ans, word1.length() * word2.length());
                }
            }
        }
        return ans;
    }

    /**
     * 是否有相似字符
     * true说明有
     * O(m^2)
     * @param word1
     * @param word2
     * @return
     */
    public static boolean hasSameChar(String word1, String word2) {
        for (char c : word1.toCharArray()) {
            //如果此字符串中没有出现这样的字符返回-1，即
            if (word2.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 时间复杂度：O(L + n^2),其中 L 是数组 words 中的全部单词长度之和，n是数组 words的长度。
     *空间复杂度：O(n)，其中 n 是数组 words 的长度。需要创建哈希表记录每个位掩码对应的最大单词长度，哈希表中的记录数量不会超过 n。
     * @param words
     * @return
     */
    public int maxProduct2(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = words.length;
        for (int i = 0; i < length; i++) {
            int mask = 0;
            String word = words[i];
            int wordLength = word.length();
            for (int j = 0; j < wordLength; j++) {
                //|为位或运算，<<为左移运算
                mask |= 1 << (word.charAt(j) - 'a');
            }
            if (wordLength > map.getOrDefault(mask, 0)) {
                map.put(mask, wordLength);
            }
        }
        int maxProd = 0;
        Set<Integer> maskSet = map.keySet();
        for (int mask1 : maskSet) {
            int wordLength1 = map.get(mask1);
            for (int mask2 : maskSet) {
                if ((mask1 & mask2) == 0) {
                    int wordLength2 = map.get(mask2);
                    maxProd = Math.max(maxProd, wordLength1 * wordLength2);
                }
            }
        }
        return maxProd;
    }


}
