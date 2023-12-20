package com.whl.leekcode.easy.tree;

import com.whl.leekcode.common.TreeNode;

/**
 * 翻转二叉树
 * @author liaowenhui
 * @date 2023/8/4 17:23
 */
public class LC226 {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(N)，其中 N为二叉树节点的数目。我们会遍历二叉树中的每一个节点，对每个节点而言，我们在常数时间内交换其两棵子树。
     * 空间复杂度：O(N)。使用的空间由递归栈的深度决定，它等于当前节点在二叉树中的高度。在平均情况下，二叉树的高度与节点个数为对数关系，即 O(logN)。而在最坏情况下，树形成链状，空间复杂度为 O(N)。
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


}
