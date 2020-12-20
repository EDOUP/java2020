package com.edoup.base.proxy;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/12/14 23:17
 */
public class HelloImpl implements IHello {
    @Override
    public String sayHello(String msg) {
        return "hello";
    }
}
