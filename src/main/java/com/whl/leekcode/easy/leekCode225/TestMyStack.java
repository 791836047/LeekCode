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
    Deque<Integer> deque2;

    /**
     * Initialize your data structure here.
     */
    public TestMyStack() {
        queue1  = new LinkedList<>();
        deque2  = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        deque2.offer(x);
        if (!queue1.isEmpty()){
            deque2.offer(queue1.poll());
        }
        Deque<Integer> temp;
        temp = queue1;
        queue1 = deque2;
        deque2 = temp;

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
