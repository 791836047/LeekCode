package com.whl.leekcode.easy.tree;

import com.whl.leekcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 先、中、后就表示根节点的遍历处于哪个位置
 * 二叉树的后序遍历：先遍历左节点,再遍历右节点,最后遍历根节点
 *
 * @author liaowenhui
 * @date 2022/7/21 10:00
 */
public class LC145postorderTree {

    public static void main(String[] args) {
        //输入：root = [1,null,2,3]
        TreeNode head = new TreeNode(1);
        TreeNode node1 = null;
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        head.left = node1;
        head.right = node2;
        node2.left = node3;

        System.out.println(postorderTraversal(head));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public static void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }


}
