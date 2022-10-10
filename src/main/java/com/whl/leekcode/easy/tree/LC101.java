package com.whl.leekcode.easy.tree;

import com.whl.leekcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树(蓝湖2)
 * @author liaowenhui
 * @date 2022/7/28 14:07
 */
public class LC101 {

    public static void main(String[] args) {
        //初始化 root = [1,2,2,3,4,4,3] true
        TreeNode head = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);

        head.left = node1;
        head.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        System.out.println("递归：" + isSymmetric(head));
        System.out.println("迭代：" + isSymmetric2(head));
    }


    /**
     * 方法一递归
     * 第一要素：明确你这个函数想要干什么
     * 第二要素：寻找递归结束条件
     * 第三要素：找出函数的等价关系式
     * 时间复杂度为 O(n)
     * 空间复杂度：这里的空间复杂度和递归使用的栈空间有关，这里递归层数不超过 n，故渐进空间复杂度为 O(n)
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }


    /**
     * 迭代
     * 时间复杂度：O(n)，同「方法一」。
     * 空间复杂度：这里需要用一个队列来维护节点，每个节点最多进队一次，出队一次，队列中最多不会超过 n 个点，故渐进空间复杂度为 O(n)。
     * @param root
     * @return
     */
    public static boolean isSymmetric2(TreeNode root) {
        return check2(root, root);
    }

    public static boolean check2(TreeNode u, TreeNode v) {
        //队列
        Queue<TreeNode> q = new LinkedList<>();
        //添加到队列中，如果添加成功则返回true
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            //返回和删除队列头部元素，如果队列为空返回null
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }


}
