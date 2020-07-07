package com.edoup.thread.practise.jianzhi;

/**
 * <p>
 *     给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
 *     每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
 *     例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
 *
 *     数学题
 * </p>
 *
 * @author edoup
 * @date 2020/7/5 22:24
 */
public class SolutionJZ67 {

    public int cutRope(int target) {
        if (target <= 4) {
            return target;
        }
        int res = 0;
        for (int i = 1; i < target; i++) {
            res = Math.max(res, i * cutRope(target - i));
        }
        return res;
    }

    public int cutRope2(int target) {
        int max = 1;
        if (target <= 3 && target > 0) {
            return target - 1;
        }
        while (target > 4) {
            target -= 3;
            max *= 3;
        }
        return max * target;
    }

    public static void main(String[] args) {
        SolutionJZ67 jz67 = new SolutionJZ67();
        System.out.println(jz67.cutRope(31));
    }
}
