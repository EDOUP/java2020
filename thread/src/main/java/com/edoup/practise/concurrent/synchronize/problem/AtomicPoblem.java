package com.edoup.practise.concurrent.synchronize.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 原子性问题 volatile不保证原子性
 * </p>
 *
 * @author edoup
 * @date 2020-3-30 17:00
 */
public class AtomicPoblem {

    static int i = 0;
    static Object obj = new Object();

    public static void testAtomicPoblem() {
        for (int j = 0; j < 10000; j++) {
            synchronized (obj) {
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            Thread thread = new Thread(() -> {
                testAtomicPoblem();
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("i = " + i);
    }
}
