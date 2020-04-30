package com.edoup.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/4/20 21:15
 */
public class TestListAdd {

    public static void main(String[] args){

        System.out.println("Test 10000000 List add start");

        System.out.println("10000000 Capacity: "+ listAdd(10000000,10000000));//指定容量
    //    System.out.println("Default Capacity: "+ listAdd(10000000));//默认容量


    }

    public static Long listAdd(int num){
        Long starTime = System.currentTimeMillis();
        List<Object> list = new ArrayList<>();
        for (Integer i = 0; i < num; i++) {
            list.add(i);
        }
        Long endTime = System.currentTimeMillis();
        return endTime - starTime;
    }

    public static Long listAdd(int capatity,int num){
        Long starTime = System.currentTimeMillis();
        List<Object> list = new ArrayList<>(capatity);
        for (Integer i = 0; i < num; i++) {
            list.add(i);
        }
        Long endTime = System.currentTimeMillis();
        return endTime - starTime;
    }
}