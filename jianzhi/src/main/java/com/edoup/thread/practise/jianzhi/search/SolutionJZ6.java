package com.edoup.thread.practise.jianzhi.search;


/**
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * </p>
 *
 * @author edoup
 * @date 2020/6/21 14:42
 */
public class SolutionJZ6 {
    public static void main(String[] args) {
        int[] a = new int[]{5,1,2,3, 4};
        //int[] a = new int[]{2,2,2,2,1,2};;
      //  int[] a = new int[]{ 2};
      //  System.out.println(minNumberInRotateArray(a));
        System.out.println(minNumberInRotateArray2(a));
    }

    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[0];
    }

    public static int minNumberInRotateArray2(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int left = 0;
        int right = array.length -1;
        int mid ;
        while (left <= right){
            mid = ( left + right) >> 1 ;
            if (mid != 0 && array[mid] < array[mid-1]) {
                return array[mid];
            }
            if (array[mid] < array[right]) {
                right = mid - 1;
            }else  {
                left = mid +1;
            }
        }
        return array[0];
    }

}