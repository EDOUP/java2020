package com.edoup.thread.practise.jianzhi.recursion;

/**
 * <p>
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 *
 * 斐波拉契数列变形
 * </p>
 *
 * @author edoup
 * @date 2020/7/5 16:34
 */
public class SolutionJZ8 {

    //迭代
    public int JumpFloor(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1 || target == 2) {
            return target;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    //动态规划
    public int JumpFloor2(int target) {
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
        SolutionJZ8 jz8 = new SolutionJZ8();
        System.out.println(jz8.JumpFloor(0));
        System.out.println(jz8.JumpFloor(1));
        System.out.println(jz8.JumpFloor(2));
        System.out.println(jz8.JumpFloor(3));
        System.out.println(jz8.JumpFloor(4));
        System.out.println(jz8.JumpFloor(5));
        System.out.println(jz8.JumpFloor(6));
        System.out.println(jz8.JumpFloor2(6));
    }


}
