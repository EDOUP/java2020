package com.edoup.practise.concurrent.synchronize.problem;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 可见性问题
 * </p>
 *
 * @author edoup
 * @date 2020-3-30 17:00
 */
public class VisibileProblem2 {

    static Object obj = new Object();
    static int a, b, c = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (obj) {
                a = 1;
                b = 2;
            }
            c = 3;
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            synchronized (obj) {
                System.out.println(a);
                System.out.println(b);
                System.out.println(c);
            }
        }).start();
        System.out.println("主线程运行结束");
    }
}


