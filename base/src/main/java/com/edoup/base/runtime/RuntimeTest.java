package com.edoup.base.runtime;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/8/26 1:43
 */
public class RuntimeTest {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().totalMemory() /1024/1024);
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
    }
}
