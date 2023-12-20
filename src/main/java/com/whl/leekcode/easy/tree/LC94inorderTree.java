package com.whl.leekcode.easy.tree;

import com.whl.leekcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 字节1面:递归和迭代实现二叉树中序遍历(10.11，11.1看)
 * 二叉树的中序遍历：先遍历左节点,再遍历根节点,最后遍历右节点
 *
 * @author liaowenhui
 * @date 2022/7/21 10:00
 */
public class LC94inorderTree {

    public static void main(String[] args) {
        //输入：root = [1,null,2,3]
        TreeNode head = new TreeNode(1);
        //TreeNode node1 = null;
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        //head.left = node1;
        head.right = node2;
        node2.left = node3;

        System.out.println(inorderTraversal(head));

        System.out.println(inorderTraversal2(head));

    }

    /**
     * 递归的方法
     * 第一要素：明确你这个函数想要干什么
     * 第二要素：寻找递归结束条件
     * 第三要素：找出函数的等价关系式
     * 时间复杂度：O(n)，其中n为二叉树节点的个数。二叉树的遍历中每个节点会被访问一次且只会被访问一次。
     * 空间复杂度：O(n)，空间复杂度取决于递归的栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n)的级别。
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    /**
     * 递归函数
     * @param root
     * @param res
     */
    public static void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    /**
     * 迭代的方法
     * 时间复杂度：O(n)，其中 n 为二叉树节点的个数。二叉树的遍历中每个节点会被访问一次且只会被访问一次。
     * 空间复杂度：O(n)。空间复杂度取决于栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n) 的级别。
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //栈,注意存的是树节点！！
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            // 将当前节点及其所有左子节点都压入栈，直到没有左子节点为止。
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            // 弹出栈顶节点，该节点的值是当前子树中最左侧的节点，加入结果列表。
            root = stk.pop();
            res.add(root.val);

            // 处理当前节点的右子树，如果右子节点不为空，继续遍历右子树的左子节点。
            root = root.right;
        }
        return res;
    }


}
