package com.whl.leekcode.mid.tree;

import com.whl.leekcode.common.TreeNode;

import java.util.*;

/**
 * 二叉树的层序遍历
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/description/?favorite=2cktkvj&orderBy=most_votes
 * @author liaowenhui
 * @date 2023/4/6 9:31
 */
public class LC102 {
    /**
     * 记树上所有节点的个数为 n。
     * 时间复杂度：每个点进队出队各一次，故渐进时间复杂度为 O(n)。
     * 空间复杂度：队列中元素的个数不超过 n个，故渐进空间复杂度为 O(n)。
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            //!!注意queue.size()的位置,不能写在for循环里
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

    /**
     * 20230806 自写90%
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderTest(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> lever = new ArrayList<>();
            //!!
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();

                lever.add(node.val);
                if (null != node.left){
                    queue.offer(node.left);
                }
                if (null != node.right){
                    queue.offer(node.right);
                }
            }
            res.add(lever);
        }

        return res;
    }

    public static void main(String[] args) {
        //初始化 123321链表
        TreeNode head = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(17);
        head.left = node1;
        head.right = node2;
        node1.left = null;
        node1.right = null;
        node2.left = node3;
        node2.right = node4;

        System.out.println(levelOrder(head));
        System.out.println(levelOrderTest(head));

    }



}
