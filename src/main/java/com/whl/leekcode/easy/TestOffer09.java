package com.whl.leekcode.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liaowenhui
 * @date 2022/8/8 9:20
 */
public class TestOffer09 {

    public static void main(String[] args) {
        TestOffer09 queue = new TestOffer09();
        queue.appendTail(3);
        queue.appendTail(4);
        int i = queue.deleteHead();
        int i2 = queue.deleteHead();
        System.out.println("结果为：" + i + "," + i2);
    }

    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public TestOffer09() {
         stack1 = new LinkedList<>();
         stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()){
           return stack2.pop();
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
