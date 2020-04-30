package com.edoup.practise.concurrent.problem;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 有序性问题
 *
 * </p>
 *
 * @author edoup
 * @date 2020-3-30 17:44
 */
public class OrderProblem {

    static int i = 0;
    static int num = 0;
    static boolean flag = false;


    public static void main(String[] args) throws InterruptedException {
        OrderProblem consistentProblem = new OrderProblem();
        new Thread(() -> {
            consistentProblem.method1();
        }).start();
        new Thread(() -> {
            consistentProblem.method2();
        }).start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(i);
    }

    public void method1() {
        if (flag) {
            i = num + num;
        } else {
            i = 1;
        }
    }

    public void method2() {
        num = 2;
        flag = true;
    }
}
