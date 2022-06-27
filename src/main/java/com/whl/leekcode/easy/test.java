package com.whl.leekcode.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liaowenhui
 * @date 2022/6/27 16:25
 */
public class test {

    public static void main(String[] args) {

        Deque<Integer> deque  = new LinkedList<>();
        deque.add(0);
        deque.add(1);
        deque.add(2);
        //System.out.println(deque.poll());
        System.out.println(deque.pop());


        Deque<Integer> deque2  = new LinkedList<>();
        deque2.offer(1);
        deque2.offer(2);
        System.out.println(deque2.pop());

        Deque<Integer> deque3  = new LinkedList<>();
        deque3.push(1);
        deque3.push(2);
        System.out.println(deque3.pop());



    }

}
