package com.whl.leekcode.easy;/*
 *  @(#)testReverseList.java 1.0 2021-06-20
 *
 *             Copyright (c) 2017, YUNXI. All rights reserved.
 *             YUNXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import com.whl.leekcode.common.ListNode;

/**
 * leekcode206单链表反转   同剑指 Offer 06跟offer24
 * [head->1->2->3->4->null] -> [head->4->3->2->1->null]
 *
 * @author liaowenhui
 * @date 2021/6/20 16:28
 */
public class leekcode206 {

    /**
     * 方法2 递归反转
     * 第一要素，明确递归函数功能:递归反转子链表
     * 第二要素，寻找递归结束条件
     * 第三要素：找出函数的等价关系式
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        //第二要素，寻找递归结束条件
        if (head == null || head.next == null) {
            return head;
        }
        // 第一要素，明确递归函数功能:递归反转子链表
        ListNode newHead = reverseList(head.next);

        /**
         *第三要素：找出函数的等价关系式
         * 假设来到递归的最后一步我们已经把 2->3 递归成 3->2，1这个节点还没有去碰它，所以 1 的 next 节点仍然是2，1没有上一个节点。
         * head->1->2->3->4->null   ->   4->3->2<-1<-head
         */
        // 通过head.next获取节点2,让2的next指向1
        ListNode node = head.next;
        // 让2的next指向1
        node.next = head;
        // 1的next指向null.
        head.next = null;
        // 返回把调整之后的链表
        return newHead;
    }


    /**
     *  方法1 迭代
     *  1->2->3->null
     * 第一步 1->null  2->3->null
     * 第二步 2->1->null 3->null
     * 第三步 3->2->1->null
     * 最终 3->2->1->null
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        //上一个节点
        ListNode prev = null;
        //当前节点
        ListNode curr = head;
        while (curr != null) {
            //原先1的下一个节点是2 原先2的下一个节点是3 原先3的下一个节点是null
            ListNode next = curr.next;

            //把1的下一个节点置为null  把2的下一个节点置为1 把3的下一个节点置为2
            curr.next = prev;

            /**
             * 把当前节点设置为上一个节点
             * 1为上一个节点 2为上一个节点 3为上一个节点
             */
            prev = curr;

            /**
             * 把原先的下一个节点设置为当前节点
             * 2为当前节点 3为当前节点 null为下一个节点
             */
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        //初始化
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        //方法1 迭代
        //ListNode listNode = reverseList2(head);
        //方法2 递归反转
        ListNode listNode = reverseList(head);

        //打印
        while (null != listNode) {
            System.out.print(listNode.getDate() + " ");
            listNode = listNode.getNext();
        }
    }

}

