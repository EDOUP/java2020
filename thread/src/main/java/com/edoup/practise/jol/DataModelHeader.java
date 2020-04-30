package com.edoup.practise.jol;

import org.openjdk.jol.datamodel.X86_32_DataModel;
import org.openjdk.jol.datamodel.X86_64_COOPS_DataModel;
import org.openjdk.jol.datamodel.X86_64_DataModel;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.layouters.HotSpotLayouter;
import org.openjdk.jol.layouters.Layouter;

/**
 * <p>
 *     模拟不同 操作系统下 对象头信息
 * </p>
 *
 * @author edoup
 * @date 2020/4/18 23:18
 */
public class DataModelHeader {

    public static void main(String[] args) {
        Two two = new Two();
     //   Integer[] two = new Integer[]{1,2,3};
        Layouter l = new HotSpotLayouter(new X86_32_DataModel());
        System.out.println("***** " + l);//32位vm的内存布局
        System.out.println(ClassLayout.parseInstance(two, l).toPrintable());

        l = new HotSpotLayouter(new X86_64_DataModel());
        System.out.println("***** " + l);//64位vm的内存布局
        System.out.println(ClassLayout.parseInstance(two, l).toPrintable());

        l = new HotSpotLayouter(new X86_64_COOPS_DataModel());
        System.out.println("***** " + l);//64位开启指针压缩后的vm的内存布局
        System.out.println(ClassLayout.parseInstance(two, l).toPrintable());
    }
}

class Two {

}
