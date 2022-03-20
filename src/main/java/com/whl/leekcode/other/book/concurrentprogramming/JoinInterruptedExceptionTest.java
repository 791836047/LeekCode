package com.whl.leekcode.other.book.concurrentprogramming;

/**
 * @author liaowenhui
 * @date 2022/2/14 20:17
 */
public class JoinInterruptedExceptionTest {
    public static void main(String[] args) throws InterruptedException {

        //线程 One
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadOne begin run!");
                for (; ; ) {
                }
            }
        });

        //获取主线程
        final Thread mainThread = Thread.currentThread();

        //线程 two
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //中断主线程
                mainThread.interrupt();
            }
        });

        //启动子线程
        threadOne.start();

        //延迟 1s 启动线程
        threadTwo.start();

        //主线程调用threadOne的join方法阻塞自己，等待线程 One 执行结束
        try {
            threadOne.join();
        } catch (InterruptedException e) {
            System.out.println("main thread:" + e);
        }

    }
}
