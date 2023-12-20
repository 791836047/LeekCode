package com.whl.leekcode.easy.tree;

import com.whl.leekcode.common.TreeNode;

/**
 *  二叉树的最大深度
 * @author liaowenhui
 * @date 2023/8/4 16:16
 */
public class LC104 {

    public static void main(String[] args) {
        //输入：root = [3,9,20,null,null,15,7]
        TreeNode head = new TreeNode(3);

        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        head.right = node2;
        head.left = node3;
        node3.left = node4;
        node3.right = node5;

        LC104 lc104 = new LC104();
        System.out.println("result：" + lc104.maxDepth(head));

    }

    /**
     * 时间复杂度：O(n)，其中 n为二叉树节点的个数。每个节点在递归中只被遍历一次。
     * 空间复杂度：O(height)，其中 height 表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度，因此空间复杂度等价于二叉树的高度。
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
