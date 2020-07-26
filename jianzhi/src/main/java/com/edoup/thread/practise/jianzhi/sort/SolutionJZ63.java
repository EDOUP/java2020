package com.edoup.thread.practise.jianzhi.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <p>
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * </p>
 *
 * @author edoup
 * @date 2020/7/5 14:12
 */
public class SolutionJZ63 {

    private List<Integer> numList = new ArrayList<Integer>();

    public void Insert(Integer num) {
        numList.add(num);
        numList.sort((a, b) ->  a.compareTo(b));
    }

    public Double GetMedian() {
        if (numList.isEmpty()){
            return null;
        }
        if (numList.size() == 1) {
            return Double.valueOf(numList.get(0));
        }
        if (numList.size() % 2 != 0) {
            return Double.valueOf(numList.get(numList.size() >> 1));
        }
        int mid = numList.size() >> 1;
        return Double.valueOf(numList.get(mid) + numList.get(mid - 1)) / 2;
    }

    private  static  PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

    public static void main(String[] args) {
      /*  minHeap.add(2);
        minHeap.add(1);
        minHeap.add(4);
        minHeap.add(3);
        System.out.println(minHeap.peek());
        System.out.println(minHeap.poll());*/
        SolutionJZ63 solutionJZ63 = new SolutionJZ63();
        solutionJZ63.Insert(5);
        System.out.println(solutionJZ63.GetMedian());
        solutionJZ63.Insert(2);
        System.out.println(solutionJZ63.GetMedian());
        solutionJZ63.Insert(3);
        System.out.println(solutionJZ63.GetMedian());
        solutionJZ63.Insert(4);
        System.out.println(solutionJZ63.GetMedian());
        solutionJZ63.Insert(1);
        System.out.println(solutionJZ63.GetMedian());
    }
}
