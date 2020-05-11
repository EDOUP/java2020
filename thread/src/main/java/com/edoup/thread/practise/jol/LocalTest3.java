package com.edoup.thread.practise.jol;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *    一般情况下 锁升级演示
 * </p>
 *
 * @author edoup
 * @date 2020/4/22 17:23
 */


public class LocalTest3 {

    static Object obj = new Object();

    public static void method() {
        for (int i = 0; i < 6; i++) {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + "进入同步代码块");
                System.out.println(ClassLayout.parseInstance(obj).toPrintable());
              /*  try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
            System.out.println(Thread.currentThread().getName() + "退出同步代码块");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程：" + ClassLayout.parseInstance(obj).toPrintable());
        new Thread(() -> {
            method();
        }, "t1").start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("主线程：" + ClassLayout.parseInstance(obj).toPrintable());
        new Thread(() -> {
            method();
        }, "t2").start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("主线程：" + ClassLayout.parseInstance(obj).toPrintable());
    }

}
