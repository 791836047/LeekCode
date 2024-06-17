package com.whl.leekcode.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 220808、20220909写
 * 剑指 Offer 09. 用两个栈实现队列
 * @author liaowenhui
 * @date 2022/2/8 14:43
 */
public class Offer09 {
    public static void main(String[] args) {
        Offer09 queue = new Offer09();
        queue.appendTail(3);
        queue.appendTail(4);
        int i = queue.deleteHead();
        int i2 = queue.deleteHead();
        System.out.println("结果为：" + i + "," + i2);
    }

    /**
     * Deque表示双端队列。双端队列是在两端都可以进行插入和删除的队列。Deque是一个比Stack和Queue功能更强大的接口，它同时实现了栈和队列的功能。ArrayDeque和LinkeList实现了Deque接口。
     * 注意：Deque既可以用作后进先出的栈，也可以用作先进先出的队列。
     */
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public Offer09() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        //push() ：在堆栈的顶部加入一个元素。
        stack1.push(value);
    }

    public int deleteHead() {
        // 如果第二个栈为空
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                //pop() ：删除并返回此双端队列的第一个元素(栈顶)。
                stack2.push(stack1.pop());
            }
        }
        //!! 没有考虑到返回 -1
        if (stack2.isEmpty()) {
            return -1;
        } else {
            return stack2.pop();
        }
    }


}
