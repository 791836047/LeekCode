package com.whl.leekcode.other.java8new.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CompletableFuture指定的线程池来执行异步任务。
 * @author liaowenhui
 * @date 2023/7/28 14:18
 */
public class CompletableFutureCustomThreadPoolExample {

    public static void main(String[] args) {
        // 创建一个自定义线程池，使用固定大小的线程池
        ExecutorService customThreadPool = Executors.newFixedThreadPool(4);

        // 异步执行任务，并指定自定义线程池
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("异步任务在线程: " + Thread.currentThread().getName());
            return "任务执行结果";
        }, customThreadPool);

        // 使用get()方法等待任务完成并获取结果
        try {
            String result = future.get();
            System.out.println("任务执行完成，结果为: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 关闭自定义线程池
        customThreadPool.shutdown();
    }
}
