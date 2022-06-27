package com.whl.leekcode.easy.leekCode232;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 面
 * 用栈实现队列
 * 方法一 用Deque实现
 * @author liaowenhui
 * @date 2022/6/23 14:30
 */
public class MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        // queue is: [1]
        myQueue.push(1);
        // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.push(2);
        // return 1
        System.out.println(myQueue.peek());
        // return 1, queue is [2]
        System.out.println(myQueue.pop());
        // return false
        System.out.println(myQueue.empty());
        // return 2, queue is []
        System.out.println(myQueue.pop());
        // return true
        System.out.println(myQueue.empty());
    }

}
