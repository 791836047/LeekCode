package com.whl.leekcode.easy.leekCode225;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liaowenhui
 * @date 2022/8/8 9:40
 */
public class TestMyStack {

    public static void main(String[] args) {
        TestMyStack myStack = new TestMyStack();
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
    public TestMyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     * 将元素 x 压入栈顶
     */
    public void push(int x) {
        queue1.offer(x);
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }

        Deque<Integer> temp;
        temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     * 移除并返回栈顶元素。
     */
    public int pop() {
        if (!queue2.isEmpty()) {
            return queue2.poll();
        }
        return -1;
    }

    /**
     * Get the top element.
     * 返回栈顶元素
     */
    public int top() {
        if (!queue2.isEmpty()) {
            return queue2.peek();
        }
        return -1;
    }

    /**
     * Returns whether the stack is empty.
     * 如果栈是空的，返回 true ；否则，返回 false
     */
    public boolean empty() {
        return queue2.isEmpty();
    }

}
