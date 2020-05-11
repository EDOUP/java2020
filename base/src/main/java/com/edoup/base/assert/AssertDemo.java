package com.edoup.base;

/**
 * <p>
 *     assert 的使用
 *     运行时加 VM 参数  -ea
 * </p>
 *
 * @author edoup
 * @date 2020/5/2 16:18
 */
public class AssertDemo {

    public static void main(String[] args) {
        boolean isSafe = false;
        assert isSafe : "213";
        System.out.println("断言通过!");
    }

}
