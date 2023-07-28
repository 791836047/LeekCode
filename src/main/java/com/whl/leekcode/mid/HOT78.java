package com.whl.leekcode.mid;

import java.util.ArrayList;
import java.util.List;

/**
 * https://labuladong.gitee.io/algo/
 *
 *
 * 子集 回溯
 * @author liaowenhui
 * @date 2023/4/23 9:36
 */
public class HOT78 {

    //用 t数组存放已经被选出的数字
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    /**
     * 时间复杂度：O(n×2^n),一共 2^n个状态，每种状态需要 O(n) 的时间来构造子集。
     * 空间复杂度：O(n)。临时数组 t 的空间代价是 O(n)，递归时栈空间的代价为 O(n)。
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    /**
     *  https://labuladong.gitee.io/algo/
     *
     *  回溯算法的框架：
     *  result = []
     *  def backtrack(路径, 选择列表):
     *      if 满足结束条件:
     *          result.add(路径)
     *          return
     *
     *      for 选择 in 选择列表:
     *          做选择
     *          backtrack(路径, 选择列表)
     *          撤销选择
     *
     *
     * 当前位置是 cur
     * @param cur
     * @param nums
     */
    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        HOT78 hot78 = new HOT78();
        List<List<Integer>> subsets = hot78.subsets(nums);
        System.out.println(subsets.toString());
    }

}
