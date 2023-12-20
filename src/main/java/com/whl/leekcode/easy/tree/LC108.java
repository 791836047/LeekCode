package com.whl.leekcode.easy.tree;

import com.whl.leekcode.common.TreeNode;

/**
 *
 * 将有序数组转换为二叉搜索树
 * @author liaowenhui
 * @date 2023/8/7 9:17
 */
public class LC108 {

    public static void main(String[] args) {
        LC108 lc108 = new LC108();
        TreeNode node = lc108.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(node.val);

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

}
