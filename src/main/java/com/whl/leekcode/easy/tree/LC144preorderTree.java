package com.whl.leekcode.easy.tree;


import com.whl.leekcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * @author liaowenhui
 * @date 2022/7/21 9:54
 */
public class LC144preorderTree {

    public static void main(String[] args) {
        //输入：root = [1,null,2,3]
        TreeNode head = new TreeNode(1);
        TreeNode node1 = null;
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        head.left = node1;
        head.right = node2;
        node2.left = node3;

        System.out.println(preorderTraversal(head));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public static void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

}
