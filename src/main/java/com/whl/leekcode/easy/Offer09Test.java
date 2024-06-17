package com.whl.leekcode.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 220808写
 * 剑指 Offer 09. 用两个栈实现队列
 * @author liaowenhui
 * @date 2022/2/8 14:43
 */
public class Offer09Test {
    public static void main(String[] args) {
        Offer09Test queue = new Offer09Test();
        queue.appendTail(3);
        queue.appendTail(4);
        int i = queue.deleteHead();
        int i2 = queue.deleteHead();
        System.out.println("结果为：" + i + "," + i2);
    }

    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public Offer09Test() {
        stack1 =  new LinkedList<>();
        stack2 =  new LinkedList<>();
    }

    /**
     * 插入队尾
     * @param value
     */
    public void appendTail(int value) {
        stack1.push(value);
    }

    /**
     * 删除队列头部整数
     * @return
     */
    public int deleteHead() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()){
            return -1;
        }

        return stack2.pop();
    }


}
