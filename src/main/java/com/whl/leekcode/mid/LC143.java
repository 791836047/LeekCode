package com.whl.leekcode.mid;

import com.whl.leekcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 重排链表(美团1)
 * @author liaowenhui
 * @date 2022/7/29 15:59
 */
public class LC143 {
    public static void main(String[] args) {

        //初始化
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);

        reorderList(head);

        while (null != head) {
            System.out.print(head.getDate() + " ");
            head = head.getNext();
        }
    }

    /**
     * 方法一 线性表
     * 因为链表不支持下标访问，所以我们无法随机访问链表中任意位置的元素。
     * 因此比较容易想到的一个方法是，我们利用线性表存储该链表，然后利用线性表可以下标访问的特点，直接按顺序访问指定元素，重建该链表即可。
     *
     * 时间复杂度：O(N)，其中 N是链表中的节点数。
     * 空间复杂度：O(N)，其中 N 是链表中的节点数。主要为线性表的开销。
     * @param head
     */
    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

}
