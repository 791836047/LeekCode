package com.whl.leekcode.easy;

import com.whl.leekcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author liaowenhui
 * @date 2022/7/4 14:42
 */
public class LeekCode142 {

        public static ListNode detectCycle(ListNode head) {
            ListNode pos = head;
            Set<ListNode> visited = new HashSet<>();
            while (pos != null) {
                if (visited.contains(pos)) {
                    return pos;
                } else {
                    visited.add(pos);
                }
                pos = pos.next;
            }
            return null;
        }

    public static void main(String[] args) {
        //初始化
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node1);

        System.out.println("返回链表开始入环的第一个节点:" + detectCycle(head).getDate());
    }

}
