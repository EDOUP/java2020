package com.edoup.base.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/7/12 12:26
 */
public class RandomTest {



    public static void main(String[] args) {
        List a = new ArrayList<>();
    }

    public Number findRepeatNumber(int[] nums) {
        int[] ints = Arrays.stream(nums).toArray();
        Object o = new Object();
        List a = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            if(a.contains(nums[i])){
                return nums[i];
            }else{
                a.add(nums[i]);
            }
        }
return null;
    }
}
