package com.edoup.base.cutils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/12/10 22:59
 */
public class Test1 {

    public static void main(String[] args) {
        List<Object> objectList = new ArrayList<>();
        objectList.add(new Object());
        objectList.add(new Object());
        objectList.add(new Object());
        for (Object o : objectList) {
            objectList.remove(o);
        }
        Iterator<Object> iterator = objectList.iterator();
        boolean b = iterator.hasNext();
    }
}
