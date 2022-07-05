package com.whl.leekcode.easy.LeekCode141;

import com.whl.leekcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * bigo1，网易1
 * 哈希表
 * @author liaowenhui
 * @date 2022/7/4 10:11
 */
public class method1 {
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            //如果set重复的数据，会返回false
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }


    public static void main(String[] args) {
        //初始化 123321链表
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node1);

        System.out.println("链表中是否有环:" + hasCycle(head));
    }

}



