package leetcode.editor;

import java.util.Arrays;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/11/29 11:34
 */
public class Code976 {


    public static void main(String[] args) {

        Code976 code976 = new Code976();
        int[] a = new int[]{3,2,3,4};
        System.out.println(code976.largestPerimeter(a));
    }

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int max = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i-2] + A[i -1] > A[i]){
                max = A[i-2] + A[i-1] + A[i];
            }
        }
        return max;
    }
}
