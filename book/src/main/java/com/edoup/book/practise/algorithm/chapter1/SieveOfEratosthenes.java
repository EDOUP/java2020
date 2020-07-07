package com.edoup.book.practise.algorithm.chapter1;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 埃拉托色尼筛选法
 * 给定一个大于1的正整数n,查找所有的质数
 * </p>
 *
 * @author edoup
 * @date 2020/6/21 12:39
 */
public class SieveOfEratosthenes {

    public static void main(String[] args) {
        int n = 10000 * 10000;
        List<Integer> res = findMethod(n);
        System.out.println(res.size());
    }

    private static List<Integer> findMethod(int n) {
        int[] a = new int[n+1];
        for (int i = 2; i <= n; i++) {
            a[i] = i;
        }

        for (int i = 2; i < (int) Math.floor(Math.sqrt(n)); i++) {
            if (a[i] != 0) {
                int j = i * i;
                while (j <= n) {
                    a[j] = 0;
                    j = j + i;
                }
            }
        }
        List<Integer> b = new LinkedList<>();
        for (int i : a) {
            if (a[i] != 0) {
                b.add(a[i]);
            }
        }
        return b;
    }

}
