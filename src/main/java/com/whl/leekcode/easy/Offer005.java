package com.whl.leekcode.easy;

/**
 * 剑指 Offer II 005. 单词长度的最大乘积
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

}
