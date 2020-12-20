package com.edoup.base.netty;

import io.netty.util.HashedWheelTimer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/12/20 10:50
 */
public class HashedWheelTimerTest {


    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        //定义一个HashedWheelTimer，有16个格的轮子，每一秒走一个一个格子
        HashedWheelTimer timer = new HashedWheelTimer(1, TimeUnit.SECONDS, 16);
        //把任务加到HashedWheelTimer里，到了延迟的时间就会自动执行
        timer.newTimeout((timeout) -> {
            System.out.println(("task1 execute"));
            countDownLatch.countDown();
        }, 500, TimeUnit.MILLISECONDS);
        timer.newTimeout((timeout) -> {
            System.out.println(("task2 execute"));
            countDownLatch.countDown();
        }, 2, TimeUnit.SECONDS);
        countDownLatch.await();
        timer.stop();
    }
}
