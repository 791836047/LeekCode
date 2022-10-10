package com.whl.leekcode.easy;

import com.whl.leekcode.common.ListNode;
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

    public static int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

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
