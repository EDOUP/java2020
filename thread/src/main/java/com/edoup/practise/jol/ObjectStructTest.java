package com.edoup.practise.jol;


import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

/**
 * 演示jol对象头功能
 */
public class ObjectStructTest {

    public static void main(String[] args) {

        One one = new One();
        System.out.println(VM.current().details());
        System.out.println();
        //查看对象内部信息
        System.out.println(ClassLayout.parseClass(One.class).toPrintable());
        System.out.println("--------------");
        System.out.println((ClassLayout.parseInstance(one).toPrintable()));
        System.out.println("-------------");
        //查看对象外部信息
        System.out.println((GraphLayout.parseInstance(one).toPrintable()));
        System.out.println("----------------");
        //获取对象总大小
        System.out.println(("size : " + GraphLayout.parseInstance(one).totalSize()));
    }

}

class One {
    String k = "123";
    int a = 100;
    byte b = 0x10;
    Integer c;
    boolean d;
    float e;
    Object f;
    Long g;
    char h;
    int i;
    short j;
    double l;
}


