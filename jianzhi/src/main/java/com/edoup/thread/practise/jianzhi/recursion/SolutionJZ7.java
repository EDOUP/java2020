package com.edoup.thread.practise.jianzhi.recursion;

/**
 * <p>
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 * </p>
 *
 * @author edoup
 * @date 2020/7/5 16:34
 */
public class SolutionJZ7 {

    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 2) + Fibonacci(n - 1);
    }

    public int Fibonacci2(int n) {
        int f = 0, g = 1;
        while (n-- > 0) {
            g += f;
            f = g - f;
        }
        return f;
    }

    public static void main(String[] args) {
        SolutionJZ7 jz7 = new SolutionJZ7();
        System.out.println(jz7.Fibonacci(0));
        System.out.println(jz7.Fibonacci(1));
        System.out.println(jz7.Fibonacci(2));
        System.out.println(jz7.Fibonacci(3));
        System.out.println(jz7.Fibonacci(4));
        System.out.println(jz7.Fibonacci(5));
        System.out.println(jz7.Fibonacci(6));
        System.out.println(jz7.Fibonacci2(6));
    }


}
