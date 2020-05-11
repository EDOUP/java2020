package com.edoup.thread.practise.automic;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author a
 * juc  atomic包解决原子性问题
 */
public class AutomicTest {

    static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int j = 0; j < 10; j++) {
            Thread thread = new Thread(() -> {
                for (int k = 0; k < 10000; k++) {
                    atomicInteger.getAndIncrement();
                }
            });
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("i = " + atomicInteger.get());
    }
}
