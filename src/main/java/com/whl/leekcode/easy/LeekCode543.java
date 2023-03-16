package com.whl.leekcode.easy;

import com.whl.leekcode.common.TreeNode;

/**
 * 拼多多1
 * @author liaowenhui
 * @date 2022/6/29 18:28
 */
public class LeekCode543 {
    //经过节点数的最大值
     static int ans;

    public static void main(String[] args) {
        //初始化 123321链表
        TreeNode head = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        head.left = node1;
        head.right = node2;
        node1.left = node3;
        node1.right = node4;

        System.out.println(diameterOfBinaryTree(head));
    }

    /**
     * 时间复杂度：O(N)，其中 N 为二叉树的节点数，即遍历一棵二叉树的时间复杂度，每个结点只被访问一次。
     * 空间复杂度：O(Height)，其中 Height 为二叉树的高度。
     * 由于递归函数在递归过程中需要为每一层递归函数分配栈空间，所以这里需要额外的空间且该空间取决于递归的深度，
     * 而递归的深度显然为二叉树的高度，并且每次递归调用的函数里又只用了常数个变量，所以所需空间复杂度为 O(Height)
     * @param root
     * @return
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        //计算出经过节点数的最大值ans
        depth(root);
        //一条路径的长度为该路径经过的节点数减一
        return ans - 1;
    }

     /**
      * 深度优先搜索
      * 递归：
      *第一要素，明确递归函数功能: 子树的深度
      *第二要素，寻找递归结束条件
      *第三要素：找出函数的等价关系式
      */
    public static int depth(TreeNode node) {
        if (node == null) {
            // 访问到空节点了，返回0
            return 0;
        }
        // 左儿子为根的子树的深度
        int L = depth(node.left);
        // 右儿子为根的子树的深度
        int R = depth(node.right);
        // 计算d_node即L+R+1 并更新ans
        ans = Math.max(ans, L + R + 1);
        // 返回该节点为根的子树的深度
        return Math.max(L, R) + 1;
    }


}
