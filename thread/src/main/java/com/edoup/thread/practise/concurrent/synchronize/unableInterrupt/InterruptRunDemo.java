package com.edoup.thread.practise.concurrent.synchronize.unableInterrupt;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 一般情况下正常运行线程 不可被中断
 * --线程 sleep() wait() join() 等待状态可被中断
 * </p>
 *
 * @author edoup
 * @date 2020/4/16 23:37
 */


public class InterruptRunDemo {


    public static void main(String[] args) throws InterruptedException {
        Runnable run = () -> {
            System.out.println(Thread.currentThread().getName() + "开始执行" + Thread.currentThread().getState());
            while (true) {
               /* if (Thread.currentThread().isInterrupted()) {
                   //可通过检测中断标志位，结束运行
                    break;
                }*/
            }
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
