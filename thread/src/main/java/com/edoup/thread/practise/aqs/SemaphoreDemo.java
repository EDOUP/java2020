package com.edoup.thread.practise.aqs;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/12/19 23:32
 */
public class SemaphoreDemo {

    static Semaphore sp = new Semaphore(3);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "准备");
                    sp.acquire();
                    System.out.println(Thread.currentThread().getName() + "开始执行");
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    sp.release();
                    System.out.println(Thread.currentThread().getName() + "结束");
                }
            }, i + "").start();
        }
    }


}

