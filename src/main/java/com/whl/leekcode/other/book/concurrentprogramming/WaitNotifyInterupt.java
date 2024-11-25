package com.whl.leekcode.other.book.concurrentprogramming;

/**
 * Page27
 * 当一个线程调用共享对象的wait（）方法被阻塞挂起后，如果其他线程中断了该线程，则该线程会抛出InterruptedException异常并返回
 * @author liaowenhui
 * @date 2022/2/14 13:51
 */
public class WaitNotifyInterupt {
    static Object obj = new Object();

    /**
     * 主线程启动后，创建了 thread，并调用其 start() 方法。
     * thread 执行其 run() 方法，进入同步块并打印 "-----begin-----------"。
     * thread 调用 obj.wait()，进入等待状态并释放锁。
     * 主线程休眠 1 秒后调用 thread.interrupt()，中断等待中的 thread。
     * thread 抛出 InterruptedException，跳出 wait()，执行 catch 块中的逻辑。
     * thread 的 catch 块捕获异常并打印堆栈信息。
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (obj) {
                    try {
                        System.out.println("-----begin-----------");
                        obj.wait();
                        System.out.println("-----end----------");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        //虽然看起来像是 thread 对象的实例方法，但因为 sleep() 是静态方法，实际执行的是 Thread.sleep(1000);。
        //因此，暂停的是调用这一行代码的线程，也就是主线程 (main 线程)。
        Thread.sleep(1000);
        System.out.println("thread_Interrupt start...");
        thread.interrupt();
        System.out.println("thread_Interrupt end...");
    }
}
