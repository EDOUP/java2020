package com.edoup.thread.practise.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * 无锁直接升级为轻量级锁，偏向锁去哪了？
 * ----
 * 偏向锁在Java 6之后是默认启用的，但在应用程序启动几秒钟之后（测试5s）才激活，
 * 可以使用 -XX:BiasedLockingStartupDelay=0 参数关闭延迟，如果确定应用程序中所有锁通常情况下处于竞争状态，可以通过 XX:-UseBiasedLocking=false 参数关闭偏向锁
 */
public class LockTest {


    public static void main(String[] args) throws InterruptedException {
        //偏向锁延时
        // TimeUnit.SECONDS.sleep(5);
        //取消注释时 无锁->轻量级锁
        Object one = new Object();
        // System.out.println(Integer.toHexString(one.hashCode()));
        System.out.println((ClassLayout.parseInstance(one).toPrintable()));
        //锁对象 循环 锁的级别 没有改变
        for (int i = 0; i < 3; i++) {
            synchronized (one) {
                System.out.println("- 进入同步代码块--");
                System.out.println((ClassLayout.parseInstance(one).toPrintable()));
            }
        /*    System.out.println("释放锁");
            System.out.println((ClassLayout.parseInstance(one).toPrintable()));*/
        }
        System.out.println("释放锁");
        System.out.println((ClassLayout.parseInstance(one).toPrintable()));
    }
}
