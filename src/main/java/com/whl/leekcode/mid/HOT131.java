package com.whl.leekcode.mid;

import java.util.*;

/**
 * 看不懂
 * @author liaowenhui
 * @date 2023/4/24 10:25
 */
public class HOT131 {

    public static int slen = 0;

    public List<List<String>> partition(String s) {
        int len = s.length();
        slen = len;
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // Stack 这个类 Java 的文档里推荐写成 Deque<Integer> stack = new ArrayDeque<Integer>();
        // 注意：只使用 stack 相关的接口
        Deque<String> stack = new LinkedList<>();
        char[] charArray = s.toCharArray();
        dfs(charArray, 0, stack, res);
        return res;
    }

    /**
     *   回溯算法的框架：
     *    result = []
     *     def backtrack(选择列表,路径):
     *         if 满足结束条件:
     *             result.add(路径)
     *             return
     *
     *           for 选择 in 选择列表:
     *             做选择
     *             backtrack(选择列表,路径)
     *             撤销选择
     *
     * @param charArray
     * @param index     起始字符的索引
     * @param path      记录从根结点到叶子结点的路径
     * @param res       记录所有的结果
     */
    private void dfs(char[] charArray, int index, Deque<String> path, List<List<String>> res) {
        if (index == slen) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < slen; i++) {
            // 因为截取字符串是消耗性能的，因此，采用传子串下标的方式判断一个子串是否是回文子串
            if (!checkPalindrome(charArray, index, i)) {
                continue;
            }
            path.addLast(new String(charArray, index, i + 1 - index));
            dfs(charArray, i + 1, path, res);
            path.removeLast();
        }
    }

    /**
     * 这一步的时间复杂度是 O(N)，优化的解法是，先采用动态规划，把回文子串的结果记录在一个表格里
     *
     * @param charArray
     * @param left      子串的左边界，可以取到
     * @param right     子串的右边界，可以取到
     * @return
     */
    private boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        HOT131 hot131 = new HOT131();
        System.out.println(hot131.partition("aab").toString());
    }

}
