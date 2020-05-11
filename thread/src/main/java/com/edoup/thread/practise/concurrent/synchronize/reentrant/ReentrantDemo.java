package com.edoup.thread.practise.concurrent.synchronize.reentrant;

/**
 * <p>
 *     synchronized -- 是可重入锁
 * </p>
 *
 * @author edoup
 * @date 2020/4/19 15:06
 */
public class ReentrantDemo extends SuperXttblog {

    public static void main(String[] args) {
        ReentrantDemo child = new ReentrantDemo();
        child.doSomething();
    }

    public synchronized void doSomething() {
        System.out.println("child.doSomething()" + Thread.currentThread().getName());
        doAnotherThing(); // 调用自己类中其他的synchronized方法
    }

    private synchronized void doAnotherThing() {
        super.doSomething(); // 调用父类的synchronized方法
        System.out.println("child.doAnotherThing()" + Thread.currentThread().getName());
    }
}

class SuperXttblog {
    public synchronized void doSomething() {
        System.out.println("father.doSomething()" + Thread.currentThread().getName());
    }
}
