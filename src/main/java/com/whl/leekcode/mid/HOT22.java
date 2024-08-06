package com.whl.leekcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成  字节
 * @author liaowenhui
 * @date 2023/4/14 10:15
 */
public class HOT22 {

    /**
     * 回溯算法（深度优先遍历） + 减枝
     * https://leetcode.cn/problems/generate-parentheses/solutions/35947/hui-su-suan-fa-by-liweiwei1419/
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    /**
     * 因为每一次尝试，都使用新的字符串变量，所以无需回溯,在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
     *
     * 回溯算法的框架：
     *        result = []
     *        def backtrack(路径, 选择列表):
     *            if 满足结束条件:
     *                result.add(路径)
     *                return
     *
     *            for 选择 in 选择列表:
     *                做选择
     *                backtrack(路径, 选择列表)
     *                撤销选择
     *
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private static void dfs(String curStr, int left, int right, List<String> res) {

        //在左边和右边剩余的括号数都等于 0 的时候结算。
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，好比第一个肯定是左括号）
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3).toString());
    }


}
