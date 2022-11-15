package com.whl.leekcode.easy.leekCode232;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 面bigo1
 * 用栈实现队列
 * 方法一 用Deque实现
 * @author liaowenhui
 * @date 2022/6/23 14:30
 */
public class MyQueueTest {

    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public MyQueueTest() {
         stack1 = new LinkedList<>();
         stack2 = new LinkedList<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
       return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        if (stack1.isEmpty() && stack2.isEmpty() ){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        MyQueueTest myQueue = new MyQueueTest();
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
