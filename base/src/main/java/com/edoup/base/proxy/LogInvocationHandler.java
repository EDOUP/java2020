package com.edoup.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/12/14 23:22
 */
public class LogInvocationHandler implements InvocationHandler {

    private IHello hello;


    public LogInvocationHandler(IHello hello) {
        this.hello = hello;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("sayHello".equals(method.getName())) {
            System.out.println("You said: " + Arrays.toString(args));
        }
        return method.invoke(hello, args);
    }
}
