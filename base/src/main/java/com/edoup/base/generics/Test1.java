package com.edoup.base.generics;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/12/13 12:30
 */
public class Test1 {

    public static void main(String[] args) throws Exception {
        Class<?> cClass;

        List<Object> list = new ArrayList<>();
        list.add(1);
        Class<? extends List> aClass = list.getClass();
        Method add = aClass.getDeclaredMethod("add", Object.class);
        add.invoke(list, 2);
        System.out.println(list);
    }
}
