package com.edoup.practise.concurrent.synchronize.unableInterrupt;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * join()可被中断
 * --线程 sleep() wait() join() 等待状态可被中断
 * </p>
 *
 * @author edoup
 * @date 2020/4/16 23:37
 */


public class InterruptJoinDemo {


    public static void main(String[] args) throws InterruptedException {
        Runnable run = () -> {
            System.out.println(Thread.currentThread().getName() + "开始执行" + Thread.currentThread().getState());
            try {
                //自己等待自己线程不会停止
                Thread.currentThread().join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName() + "执行完毕，状态：" + Thread.currentThread().getState());
        };

        Thread t1 = new Thread(run, "t1");
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        Thread t2 = new Thread(run, "t2");
        t2.start();
        TimeUnit.SECONDS.sleep(1);

        System.out.println("主线程检测 t1 状态" + t1.getState());
        System.out.println("主线程检测 t2 状态" + t2.getState());
        System.out.println("------中断t2线程------");
        t2.interrupt();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("主线程检测 t1 状态" + t1.getState());
        System.out.println("主线程检测 t2 状态" + t2.getState());

    }
}
