package com.whl.leekcode.other.synchronizedtest;

/**
 * 对syncTest进行修改后
 * dd()方法虽然也使用synchronized关键字修饰了，
 * 但是因为两次new syncTest()操作建立的是两个不同的对象，
 * 也就是说存在两个不同的对象锁，线程t1和t2使用的是不同的对象锁，所以不能保证线程安全。
 * @author liaowenhui
 */
public class SyncTest2 implements Runnable{
    /**
     * 共享资源
     */
    private static int i = 0;

    /**
     * 修饰非静态(实例)方法时,是取调用该方法的对象实例作为线程要持有的锁。
     */
    private synchronized void add() {
        i++;
    }
    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            add();
        }
    }
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new SyncTest2());
        Thread t2 = new Thread(new SyncTest2());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
