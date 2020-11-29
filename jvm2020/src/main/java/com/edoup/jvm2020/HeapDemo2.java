package com.edoup.jvm2020;

import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/9/29 0:03
 */
public class HeapDemo2 {

    public static void main(String[] args) {

        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
