package com.whl.leekcode.easy.leekCode232;


import java.util.Stack;

/**
 * 用栈实现队列
 * https://leetcode.cn/problems/implement-queue-using-stacks/solution/yong-zhan-shi-xian-dui-lie-by-leetcode/
 * 方法二 用Stack实现
 * @author liaowenhui
 * @date 2022/6/23 14:30
 */
public class MyQueue2 {
     Stack<Integer> inStack;
     Stack<Integer> outStack;

    public MyQueue2() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    // Push element x to the back of queue.
    public void push(int x) {
        inStack.push(x);
    }

    // Removes the element from in front of queue.
    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // Get the front element.
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public static void main(String[] args) {
        MyQueue2 myQueue = new MyQueue2();
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
