package com.whl.leekcode.mid;

/**
 * 最长回文子串
 * @author liaowenhui
 * @date 2022/7/25 11:23
 */
public class LC5 {
    public static void main(String[] args) {

        System.out.println(longestPalindrome("babad"));
    }

    /**
     * 步骤一: 定义数组元素的含义  用 P(i,j)表示字符串 s 的第 i到 j 个字母组成的串（下文表示成 s[i:j]）是否为回文串
     * 步骤二：找出关系数组元素间的关系式  P(i,j)=P(i+1,j−1)∧(S1==S2)   "∧" 表示"与" 只有 s[i+1:j-1]是回文串，并且 s的第 i和 j个字母相同时，s[i:j]才会是回文串。
     * 步骤三：找出初始值 对于长度为 11 的子串，它显然是个回文串；对于长度为 22 的子串，只要它的两个字母相同，它就是一个回文串
     *          P(i,i)=true
     *          P(i,i+1)=(Si==Si+1)
     * ​
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        //对于长度为 1 的子串，它显然是个回文串；对于长度为 2 的子串，只要它的两个字母相同，它就是一个回文串
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度,从长度较短的字符串向长度较长的字符串进行转移
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

}
