package com.edoup.base.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/12/14 23:31
 */
public class MyMethodInterceptor implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if ("sayHello".equals(method.getName())) {
            System.out.println("You said: " + Arrays.toString(args));
        }
        return methodProxy.invokeSuper(o, args);
    }

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloCreate.class);
        enhancer.setCallback(new MyMethodInterceptor());

        HelloCreate hello = (HelloCreate) enhancer.create();
        System.out.println(hello.sayHello("I love you!"));
    }
}
