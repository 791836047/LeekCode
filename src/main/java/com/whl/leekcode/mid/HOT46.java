package com.whl.leekcode.mid;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列   回溯
 * @author liaowenhui
 * @date 2023/4/23 10:20
 */
public class HOT46 {
    //result = []
    List<List<Integer>> res = new LinkedList<>();

    /**
     * 主函数，输入一组不重复的数字，返回它们的全排列
     * @param nums
     * @return
     */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        // 「路径」中的元素会被标记为 true，避免重复使用
        boolean[] used = new boolean[nums.length];

        backtrack(nums, track, used);
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
     * @param nums
     * @param track
     * @param used
     */
    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // 触发结束条件
        if (track.size() == nums.length) {
            /**
             * 注意
             * 在代码中，track是LinkedList类的实例，用于记录当前的排列路径。如果我们直接使用res.add(track)将track添加到res中，实际上是将对track列表的引用存储在res中。
             * 如果之后修改了track列表（例如，在回溯过程中删除元素），那么已经添加到res中的排列也会受到影响。这是因为res中存储的所有排列都引用同一个track列表。
             * 为了避免这个问题，确保res中的排列不受后续对track的修改影响，我们使用new LinkedList(track)创建一个新的LinkedList对象。这样就创建了一个新的LinkedList实例，其中包含与track相同的元素，但是作为一个独立的对象。因此，之后对track的任何修改都不会影响已经添加到res中的排列。
             * 因此，res.add(new LinkedList(track))将当前排列（存储在track中）的副本添加到res中，确保res中的排列不受对track的后续修改影响。
             */
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (used[i]) {
                // nums[i] 已经在 track 中，跳过
                continue;
            }
            // 做选择
            track.add(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 取消选择
            track.removeLast();
            used[i] = false;
        }
    }


    public static void main(String[] args) {
        HOT46 hot46 = new HOT46();
        List<List<Integer>> permute = hot46.permute(new int[]{1, 2, 3});
        System.out.println(permute.toString());
    }

}
