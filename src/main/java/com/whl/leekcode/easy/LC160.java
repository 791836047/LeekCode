package com.whl.leekcode.easy;

import com.whl.leekcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liaowenhui
 * @date 2023/7/23 8:08
 */
public class LC160 {
    public static void main(String[] args) {
        //初始化
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(5);

        ListNode node1 = new ListNode(1);
        ListNode node11 = new ListNode(1);
        ListNode node8 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        //初始化l1
        l1.setNext(node1);
        node1.setNext(node8);
        node8.setNext(node4);
        node4.setNext(node5);

        //初始化l2
        l2.setNext(node6);
        node6.setNext(node11);
        node11.setNext(node8);
        node8.setNext(node4);
        node4.setNext(node5);


        LC160 lc160 = new LC160();
        ListNode intersectionNode = lc160.getIntersectionNode(l1, l2);

        while (null != intersectionNode) {
            System.out.print(intersectionNode.getDate() + " ");
            intersectionNode = intersectionNode.getNext();
        }

    }

    /**
     * listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

}
