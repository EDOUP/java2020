package com.edoup.practise.jol;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * 无锁直接升级为轻量级锁，偏向锁去哪了？
 * ----
 * 当一个对象已经计算过identity hash code，它就无法进入偏向锁状态；
 * 当一个对象当前正处于偏向锁状态，并且需要计算其identity hash code的话，则它的偏向锁会被撤销，并且锁会膨胀为重量级锁
 */
public class LockTest2 {

    public static void main(String[] args) throws InterruptedException {
        //偏向锁延时
        //TimeUnit.SECONDS.sleep(5);
        // 注释：无锁->轻量级锁->计算hashcode -> 重量级锁->释放
        //取消注释 无锁->偏向锁->计算hashcode -> 重量级锁->释放
        Object one = new Object();
        //System.out.println(Integer.toHexString(one.hashCode()));
        //取消注释：无锁->计算hashcode->轻量级->释放 不会成为重量锁
        System.out.println((ClassLayout.parseInstance(one).toPrintable()));
        //锁对象
        synchronized (one) {
            System.out.println("- 进入同步代码块--");
            System.out.println((ClassLayout.parseInstance(one).toPrintable()));
            System.out.println(Integer.toHexString(one.hashCode()));
            System.out.println((ClassLayout.parseInstance(one).toPrintable()));
        }
        System.out.println("释放锁");
        System.out.println((ClassLayout.parseInstance(one).toPrintable()));
        //释放锁需要时间，延时确保已释放
        TimeUnit.SECONDS.sleep(5);
        System.out.println((ClassLayout.parseInstance(one).toPrintable()));
    }
}
