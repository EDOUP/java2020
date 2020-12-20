package com.edoup.base.memory;

/**
 * <p>
 * 伪共享demo
 * </p>
 *
 * @author edoup
 * @date 2020/12/20 12:05
 */
public class FalseShareTest {

    final static long iteration = 1000000;
    static long totalTime = 0L;
    static VolatileLong volatileLong = new VolatileLong();

    public static void main(final String[] args) throws InterruptedException {
        //运行十次
        for (int j = 0; j < 10; j++) {
            final long start = System.nanoTime();
            runSys();
            final long end = System.nanoTime();
            totalTime += end - start;
            System.out.println(j + " : " + (end - start));
        }
        System.out.println("平均耗时：" + totalTime / 10);
    }

    public static void runSys() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < iteration; i++) {
                volatileLong.value1++;
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int j = 0; j < iteration; j++) {
                volatileLong.value2++;
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    // @Contended
    static class VolatileLong {
        public volatile long value1;
        //public long p1, p2, p3, p4, p5, p6, p7,p8;
        public volatile long value2;
    }

}
