package com.whl.leekcode.mid;

import java.util.*;

/**
 * https://leetcode.cn/problems/combination-sum/solutions/14697/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/?orderBy=most_votes
 * 回溯算法 + 剪枝
 * @author liaowenhui
 * @date 2023/4/12 20:18
 */
public class HOT39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }

        Deque<Integer> path = new LinkedList<>();
        dfs(candidates, 0,  target, path, res);
        return res;
    }

    /**
     *
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
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    private static void dfs(int[] candidates, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < candidates.length; i++) {
            path.addLast(candidates[i]);

            // 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates, i, target - candidates[i], path, res);

            // 状态重置
            path.removeLast();
        }
    }

    public static void main(String[] args) {

        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
    }


}
