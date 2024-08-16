package com.whl.leekcode.mid;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 最长有效括号
 *
 * @author 79183
 * @date 2024/8/6 10:43
 */
public class HOT32 {

    public static void main(String[] args) {

        System.out.println("result:" + longestValidParentheses("))()())"));

    }

    /**
     * 具体做法是我们始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」，
     * 这样的做法主要是考虑了边界条件的处理，栈里其他元素维护左括号的下标：
     *
     * 对于遇到的每个 ‘(’ ，我们将它的下标放入栈中
     * 对于遇到的每个 ‘)’ ，我们先弹出栈顶元素表示匹配了当前右括号：
     * 如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
     * 如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
     * 我们从前往后遍历字符串并更新答案即可。
     *
     * 需要注意的是，如果一开始栈为空，第一个字符为左括号的时候我们会将其放入栈中，
     * 这样就不满足提及的「最后一个没有被匹配的右括号的下标」，为了保持统一，我们在一开始的时候往栈中放入一个值为 −1 的元素。
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        //s.length() = 6
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }




}
