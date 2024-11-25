package com.whl.leekcode.easy.leekCode225;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 220808、220909写
 * 两个队列实现栈
 * 面
 * @author liaowenhui
 * @date 2022/6/27 14:34
 */
public class MyStack {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        // 返回 2
        System.out.println(myStack.top());
        // 返回 2
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
        // 返回 False
        System.out.println(myStack.empty());
    }

    Deque<Integer> queue1;
    Deque<Integer> queue2;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        //queue1存先进的
        queue1 = new LinkedList<>();
        //存后进的
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

}
