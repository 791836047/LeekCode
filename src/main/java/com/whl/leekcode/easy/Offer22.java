package com.whl.leekcode.easy;

import com.whl.leekcode.common.ListNode;


/**
 *  链表中倒数第k个节点(字节)
 * @author liaowenhui
 * @date 2022/12/9 9:54
 */
public class Offer22 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        System.out.println("链表中倒数第k个节点:" + getKthFromEnd(head,2).getDate());
    }

    /**
     * 顺序查找
     * 当前链表的长度为 n，则我们知道链表的倒数第 k 个节点即为正数第 n−k 个节点
     * 时间复杂度：O(n)，其中 n为链表的长度。需要两次遍历。
     * 空间复杂度：O(1)。
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        int n = 0;
        ListNode node;
        //计算链表的长度n
        for (node = head; node != null; node = node.next) {
            n++;
        }
        for (node = head; n > k; n--) {
            node = node.next;
        }

        return node;
    }

    /**
     * 方法2 双指针
     * 时间复杂度：O(n)，其中 n 为链表的长度。我们使用快慢指针，只需要一次遍历即可，复杂度为 O(n)。
     * 空间复杂度：O(1)。
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }


}
