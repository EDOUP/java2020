package com.edoup.practise.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/4/22 14:13
 */
public class HashCodeTest {

    public static void main(String[] args) {
     /*   String a = "12";
        String b = "12";*/
     /*   String a = new String("12");
        String b = new String("12");*/
     /*   System.out.println(a == b);
        System.out.println(Integer.toHexString(a.hashCode()));
        System.out.println(Integer.toHexString(b.hashCode()));
        System.out.println(Integer.toHexString(System.identityHashCode(a)));
        System.out.println(Integer.toHexString(System.identityHashCode(b)));
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        System.out.println(ClassLayout.parseInstance(b).toPrintable());*/

        //Object o = new Object();
         Integer o = new Integer(1);
         //   Book o = new Book();
        //  int o = 1;
       // System.out.println(Integer.toHexString(o.hashCode()));
        System.out.println(Integer.toHexString(System.identityHashCode(o)));
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}

class Book {

  /*  @Override
    public int hashCode() {
        return 10;
    }*/

}
