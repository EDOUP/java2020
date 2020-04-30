package com.edoup.practise.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SyncDemo {

    public  void test(){
        System.out.println(Collections.singletonList(new ArrayList<>()));
        System.out.println(Arrays.asList("1"));
    }

    public static void main(String[] args) {
        System.out.println(Collections.singletonList(new ArrayList<>()));
        System.out.println(Arrays.asList("1"));
    }
}
