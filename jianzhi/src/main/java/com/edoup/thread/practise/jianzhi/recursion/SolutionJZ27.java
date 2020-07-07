package com.edoup.thread.practise.jianzhi.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/**
 * <p>
 *
 *     输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 *     例如输入字符串abc,
 *     则打印出由字符a,b,c
 *     所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
 * </p>
 *
 * @author edoup
 * @date 2020/7/5 19:04
 */
public class SolutionJZ27 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        char[] str1 = str.toCharArray();
        Permutation(str1, 0, set);
        list.addAll(set);
        Collections.sort(list);
        return list;
    }

    public void Permutation(char[] ch, int index, Set<String> set) {
        if (ch == null || index >= ch.length) {
            return;
        }
        set.add(String.valueOf(ch));
        for (int i = index; i < ch.length; i++) {
            swap(ch, index, i);
            Permutation(ch, ++index, set);
            swap(ch, --index, i);
        }
    }

    public void swap(char[] str, int m, int n) {
        if (m != n) {
            char k = str[m];
            str[m] = str[n];
            str[n] = k;
        }
    }

    public static void main(String[] args) {
        SolutionJZ27 jz27 = new SolutionJZ27();
        System.out.println(jz27.Permutation("abc"));
    }
}
