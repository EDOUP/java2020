package com.edoup.thread.practise.concurrent.problem;

/**
 * <p>
 * volatile禁止禁止指令重排，synchronized不会禁止
 * </p>
 *
 * @author edoup
 * @date 2020/4/13 22:38
 */
public class Singleton {

    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
              //  Thread.yield();
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
