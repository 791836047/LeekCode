package com.whl.leekcode.easy;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * @author liaowenhui
 * @date 2022/2/9 13:36
 */
public class Offer30 {
    public static void main(String[] args) {
        Offer30 offer30 = new Offer30();
        offer30.push(-2);
        offer30.push(0);
        offer30.push(-3);
        // 返回 -3.
        int min = offer30.min();
        offer30.pop();
        // 返回 0.
        int top = offer30.top();
        // 返回 -2.
        int min1 = offer30.min();
        System.out.println("min:" + min);
        System.out.println("top:" + top);
        System.out.println("min1:" + min1);

    }

    Stack<Integer> A, B;

    public Offer30() {
        A = new Stack<>();
        B = new Stack<>();
    }

    /**
     * peek():查看该堆栈顶部的对象，而不将其从堆栈中删除
     * @param x
     */
    public void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x) {
            B.add(x);
        }
    }

    /**
     * pop():移除该堆栈顶部的对象，并将该对象作为该函数的值返回
     */
    public void pop() {
        if (A.pop().equals(B.peek())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
