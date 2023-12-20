package com.whl.leekcode.easy;

import com.whl.leekcode.common.ListNode;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
 * 合并两个有序链表
 * @author liaowenhui
 * @date 2022/7/14 14:43
 */
public class LeekCode21 {

    public static void main(String[] args) {
        //初始化
        ListNode l1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        l1.setNext(node1);
        node1.setNext(node2);

        //初始化
        ListNode l2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        l2.setNext(node3);
        node3.setNext(node4);

        ListNode listNode = mergeTwoLists(l1, l2);
        //ListNode listNode = mergeTwoLists2(l1, l2);

        while (null != listNode) {
            System.out.print(listNode.getDate() + " ");
            listNode = listNode.getNext();
        }

    }

    /**
     * 方法一 -- 递归
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.date < l2.date) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 推荐
     * 方法2 -- 迭代法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.date <= l2.date) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }


}
