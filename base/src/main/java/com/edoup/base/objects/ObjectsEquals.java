package com.edoup.base.objects;


import java.util.Objects;

/**
 * <p>
 * Objects equals
 * </p>
 *
 * @author edoup
 * @date 2020/5/2 14:39
 */
public class ObjectsEquals {

    public static void main(String[] args) {
        //Objects equals
       // System.out.println(Objects.equals(1, 1));
        String s1 = new String("123");
        String s2 = new String("123");
        System.out.println(s1 == s2);
        //s1不能为空
        System.out.println(s1.equals(s2));
        //s1可以为空
        System.out.println(Objects.equals(s1,s2));
        System.out.println(Objects.deepEquals(s1,s2));


        //Objects deepEquals 可以判断数组内容是否相等
       /* Integer[] int1 = {1, 2, 3};
        Integer[] int2 = {1, 2, 3};
        System.out.println(int1 == int2);
        System.out.println(int1.equals(int2));
        System.out.println(Objects.equals(int1, int2));
        System.out.println(Objects.deepEquals(int1, int2));*/
    }

}
