package com.edoup.thread.practise.jianzhi.high;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * <p>
 *    输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * </p>
 *
 * @author edoup
 * @date 2020/7/19 14:39
 */
public class SolutionJZ29 {


    /**
     * 利用 PriorityQueue 特性
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length) {
            return list;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : input) {
            queue.add(i);
        }
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
