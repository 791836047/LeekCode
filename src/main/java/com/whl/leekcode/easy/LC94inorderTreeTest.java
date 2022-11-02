package com.whl.leekcode.easy;

import com.whl.leekcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author liaowenhui
 * @date 2022/10/12 9:31
 */
public class LC94inorderTreeTest {
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

        System.out.println(inorderTraversal2(head));

    }

    /**
     * 递归
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        //递归
        inorder(root,result);

        return result;

    }

    public static void inorder(TreeNode root, List<Integer> result){
        if(null == root){
            return;
        }
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);

        return ;
    }


    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(null != root || !stack.isEmpty()){
            while (null != root){
                stack.push(root);
                root= root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;

        }

        return null;
    }






}
