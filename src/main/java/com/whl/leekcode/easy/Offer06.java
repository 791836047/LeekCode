package com.whl.leekcode.easy;

import com.whl.leekcode.common.ListNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表  跟offer24和leekcode206类似
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * @author liaowenhui
 * @date 2022/2/9 14:21
 */
public class Offer06 {

    public static void main(String[] args) {
        //初始化
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.setNext(node1);
        node1.setNext(node2);

        int[] reversePrint = reversePrint(head);
        System.out.println("打印结果为："  +Arrays.toString(reversePrint));

    }


    /**
     * 栈的特点是后进先出，即最后压入栈的元素最先弹出。考虑到栈的这一特点，使用栈将链表元素顺序倒置。从链表的头节点开始，依次将每个节点压入栈内，然后依次弹出栈内的元素并存储到数组中。
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            //pop() ：删除并返回此双端队列的第一个元素(栈顶)。
            print[i] = stack.pop().date;
        }
        return print;
    }

}
