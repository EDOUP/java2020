package com.edoup.thread.practise.concurrent.synchronize.problem;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 可见性问题
 * </p>
 *
 * @author edoup
 * @date 2020-3-30 17:00
 */
public class VisibileProblem1 {

    static Boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (flag) {
                System.out.println();
            }
            System.out.println("运行结束");
        }).start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            flag = false;
        }).start();
        System.out.println("主线程运行结束");
    }
}


