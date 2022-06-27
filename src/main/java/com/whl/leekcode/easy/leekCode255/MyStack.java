package com.whl.leekcode.easy.leekCode255;

import com.whl.leekcode.easy.leekCode232.MyQueue2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现栈
 * 面
 * @author liaowenhui
 * @date 2022/6/27 14:34
 */
public class MyStack {
    Deque<Integer> queue1;
    Deque<Integer> queue2;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }

        Deque<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     *  移除并返回栈顶元素。
     */
    public int pop() {
        return queue1.poll();
    }

    /**
     * Get the top element.
     *  返回栈顶元素
     */
    public int top() {
        return queue1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        // 返回 2
        System.out.println(myStack.top());
        // 返回 2
        System.out.println(myStack.pop());
        // 返回 False
        System.out.println(myStack.empty());
    }

}
