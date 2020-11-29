package com.edoup.thread.practise.jianzhi;


import java.util.HashSet;
import java.util.Set;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/11/26 1:33
 */
public class JianZhi38 {

    public static void main(String[] args) {
        String s = "abc";
        JianZhi38 jianZhi38 = new JianZhi38();
        System.out.println(jianZhi38.permutation(s));
    }

    char[] c;

    public String[] permutation(String s) {
        Set<String> list = new HashSet<>();
        c = s.toCharArray();
        backtrack(0, list);
        return list.toArray(new String[list.size()]);
    }

    public void backtrack(int idx, Set list) {
        if (idx == c.length - 1) {
            list.add(String.valueOf(c));
            return;
        }
        for (int i = idx; i < c.length; i++) {
            if (list.contains(c[i])) {
                continue;
            }
            swap(i, idx);
            backtrack(idx +1, list);
            swap(i, idx);
        }
    }

    private void swap(int i, int x) {
        char temp = c[i];
        c[i] = c[x];
        c[x] = temp;
    }
}
