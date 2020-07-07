package com.edoup.thread.practise.jianzhi.recursion;

/**
 * <p>
 *
 *     我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 *     请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *  与JZ8跳台阶相同
 * </p>
 *
 * @author edoup
 * @date 2020/7/5 18:58
 */
public class SolutionJZ10 {

    public int RectCover(int target) {
        if (target == 0) {
            return 0;
        }
        int f = 1, g = 2;
        while (target-- > 1) {
            g += f;
            f = g - f;
        }
        return f;
    }

    public static void main(String[] args) {
        SolutionJZ10 jz10 = new SolutionJZ10();
        System.out.println(jz10.RectCover(10));
    }
}
