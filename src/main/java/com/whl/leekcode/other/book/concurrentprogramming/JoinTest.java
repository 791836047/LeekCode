package com.whl.leekcode.other.book.concurrentprogramming;

/**
 * 等待线程执行终止的join方法 Page32
 * @author liaowenhui
 * @date 2022/2/14 20:09
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child threadOne over!");
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child threadTwo over!");
            }
        });

        //启动线程
        threadOne.start();
        threadTwo.start();

        System.out.println("wait all child thread over!");

        //等待子线程执行完毕,返回
        threadTwo.join();
        threadOne.join();

        System.out.println("all child thread over!");
    }
}