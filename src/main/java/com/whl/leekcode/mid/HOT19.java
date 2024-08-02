package com.whl.leekcode.mid;

import com.whl.leekcode.common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 删除链表的倒数第 N 个结点
 *
 * @author 79183
 * @date 2024/8/2 11:33
 */
public class HOT19 {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        ListNode listNode = removeNthFromEnd(node1, 2);
        while (null != listNode) {
            System.out.print(listNode.getDate() + " ");
            listNode = listNode.getNext();
        }

    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        /**
         * 在对链表进行操作时，一种常用的技巧是添加一个哑节点（dummy node），
         * 它的 next 指针指向链表的头节点。这样一来，我们就不需要对头节点进行特殊的判断了。
         */
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

}
