package com.edoup.thread.practise.jianzhi.search;

/**
 * 在一个二维数组中（每个一维数组的长度相同）,
 * 每一行都按照从左到右递增的顺序排序,每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数,输入这样的一个二维数组和一个整数,判断数组中是否含有该整数。
 * <p>
 * [
 * [1,  4, 7,11,15],
 * [2,  5, 8,12,19],
 * [3,  6, 9,16,22],
 * [10,13,14,17,24],
 * [18,21,23,26,30]
 * ]
 */
public class SolutionJZ1 {

    /**
     * 从右上角开始，小的在左，大的在下
     * @param target
     * @param array
     * @return
     */
    public boolean find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }

        int rows = 0;
        int r = array.length -1;
        int cols = array[0].length - 1;
        while (rows <= r && cols >= 0) {
            int v = array[rows][cols];
            if (v == target) {
                return true;
            } else if (v < target) {
                rows++;
            }else{
                cols--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(new SolutionJZ1().find(31, array));
    }
}
