package com.edoup.base.proxy;

import java.lang.reflect.Proxy;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/12/14 23:18
 */
public class StaticProxiedHello implements IHello {

    private IHello hello = new HelloImpl();

    @Override
    public String sayHello(String msg) {
        System.out.println("you said");
        return hello.sayHello(msg);
    }


    public static void main(String[] args) {
        IHello o = (IHello) Proxy.newProxyInstance(StaticProxiedHello.class.getClassLoader(), new Class[]{IHello.class}, new LogInvocationHandler(new HelloImpl()));
        o.sayHello("word");
    }
}
