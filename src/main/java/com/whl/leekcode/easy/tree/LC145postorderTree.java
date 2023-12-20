package com.whl.leekcode.easy.tree;

import com.whl.leekcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
        System.out.println(postorderTraversal2(head));

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


    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        if (root == null) {
            return res;
        }

        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            // 与前序遍历相反，后序遍历需要将节点值插入到结果列表的首部。
            res.add(0, node.val);

            // 注意先将左子节点压入栈，再将右子节点压入栈，这样弹出时就是右子节点先出栈，符合后序遍历顺序。
            if (node.left != null) {
                stk.push(node.left);
            }
            if (node.right != null) {
                stk.push(node.right);
            }
        }

        return res;
    }

}
