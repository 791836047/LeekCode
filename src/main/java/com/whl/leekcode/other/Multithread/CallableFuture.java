package com.whl.leekcode.other.Multithread;

import java.util.concurrent.*;

/**
 * Future示例
 * @author JustJavait
 * @date 2022/1/12 17:55
 */
public class CallableFuture {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        //不需要额外控制任务状态的场景。
        //使用 Future：适合简单提交任务并获取结果的场景，代码更简洁。
        Future<Integer> result = executor.submit(task);
        //关闭线程池，拒绝新的任务提交。但已提交的任务仍会继续执行。
        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            //result.get() 方法阻塞主线程，直到 Task 任务完成并返回结果。然后打印 Task 任务的运行结果。
            // 如果任务执行过程中出现异常，会抛出 InterruptedException 或 ExecutionException。
            System.out.println("task运行结果" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }
}

class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}
