package com.edoup.practise.threadpool;

import java.util.concurrent.*;


public class ThreadPoolDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Object> callable = Executors.callable(() -> {
            System.out.println("1");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },1);
        FutureTask<Object> objectFutureTask = new FutureTask<>(callable);
        objectFutureTask.run();
        System.out.println(objectFutureTask.get());
        System.out.println("1111111111111111111");

 
    }

}
