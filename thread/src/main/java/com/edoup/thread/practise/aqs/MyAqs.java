package com.edoup.thread.practise.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/12/19 23:56
 */
public class MyAqs extends AbstractQueuedSynchronizer {

    protected MyAqs() {
        super();
    }

    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        return super.tryReleaseShared(arg);
    }

    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }
}
