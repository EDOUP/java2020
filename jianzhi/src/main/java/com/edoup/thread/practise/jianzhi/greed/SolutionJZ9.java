package com.edoup.thread.practise.jianzhi.greed;

/**
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * </p>
 *
 * @author edoup
 * @date 2020/7/5 21:41
 */
public class SolutionJZ9 {

    public int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        }
        return 2 * JumpFloorII(target - 1);
    }

    public int JumpFloorII2(int target) {
        if (target == 1) {
            return 1;
        }
        return 1 << (target -1);
    }

    public static void main(String[] args) {
        SolutionJZ9 jz9 = new SolutionJZ9();
        jz9.JumpFloorII(1);
        jz9.JumpFloorII2(1);
    }


}
