package com.edoup.thread.practise.concurrent.synchronize.reentrant;

/**
 * <p>
 *     synchronized -- 可重入锁
 * </p>
 *
 * @author edoup
 * @date 2020/4/19 15:06
 */
public class ReentrantDemo2 {

    public static void main(String[] args) {
        new Thread(()->{doSomething();}).start();
        new Thread(()->{doSomething();}).start();
    }

    private static synchronized void doSomething() {

        System.out.println("doSomething()" + Thread.currentThread().getName());
    }
}

