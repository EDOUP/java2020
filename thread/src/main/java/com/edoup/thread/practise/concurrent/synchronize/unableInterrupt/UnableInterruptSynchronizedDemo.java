package com.edoup.thread.practise.concurrent.synchronize.unableInterrupt;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * synchronized 不可中断性
 * </p>
 *
 * @author edoup
 * @date 2020/4/16 23:37
 */
public class UnableInterruptSynchronizedDemo {

    private static synchronized void method1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "进入同步代码块");
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + "未被中断,退出同步代码块");
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable run = () -> {
            System.out.println(Thread.currentThread().getName() + "线程开始执行,状态:" + Thread.currentThread().getState());
            try {
                method1();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被中断，状态:" + Thread.currentThread().getState());
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName() + "线程执行完毕,状态:" + Thread.currentThread().getState());
        };
        Thread t1 = new Thread(run, "t1");
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        Thread t2 = new Thread(run, "t2");
        t2.start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("主线程检测 t1 状态" + t1.getState());
        System.out.println("主线程检测 t1 状态" + t2.getState());
        System.out.println("------中断t2线程------");
        t2.interrupt();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("主线程检测 t1 状态" + t1.getState());
        while (true) {
            TimeUnit.MILLISECONDS.sleep(200);
            System.out.println("主线程检测 t2 状态:" + t2.getState());
            if (Thread.State.TERMINATED == t2.getState()) {
                break;
            }
        }
    }
}
