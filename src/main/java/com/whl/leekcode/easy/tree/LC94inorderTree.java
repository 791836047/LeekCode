package com.whl.leekcode.easy.tree;

import com.whl.leekcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * @author liaowenhui
 * @date 2022/7/21 10:00
 */
public class LC94inorderTree {

    public static void main(String[] args) {
        //输入：root = [1,null,2,3]
        TreeNode head = new TreeNode(1);
        TreeNode node1 = null;
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        head.left = node1;
        head.right = node2;
        node2.left = node3;

        System.out.println(inorderTraversal(head));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }


}
