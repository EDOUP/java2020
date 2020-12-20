package com.edoup.base.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/12/11 0:32
 */
public class Test1 {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        try {
            reentrantLock.lock();
        } catch (Exception e) {
            e.printStackTrace();
        }
        reentrantLock.unlock();
    }
}
