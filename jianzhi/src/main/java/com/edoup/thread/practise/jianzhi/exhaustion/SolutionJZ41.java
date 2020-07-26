package com.edoup.thread.practise.jianzhi.exhaustion;

import java.util.ArrayList;

/**
 * <p>
 * <h3>题目描述</h3>
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 * <br/>
 * <br/>
 * <h3>输出描述:</h3>
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * </p>
 *
 * @author edoup
 * @date 2020/7/7 23:48
 */
public class SolutionJZ41 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int plow = 1, phigh = 2;
        while (phigh > plow) {
            int cur = (plow + phigh) * (phigh - plow + 1) >> 1;
            if (cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = plow; i <= phigh; i++) {
                    list.add(i);
                }
                res.add(list);
                plow ++;
            }else if (cur < sum){
                phigh ++;
            }else {
                plow ++;
            }
        }
        return res;
    }

    public ArrayList<ArrayList<Integer> > FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // n 为项数
        for (int n = (int) Math.sqrt(2 * sum); n >= 2; n--) {
            if ((n & 1) == 1 && sum % n == 0 || (sum % n) * 2 == n) {
                ArrayList<Integer> list = new ArrayList<>();
                // sum / n ：中间值
                for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
                    list.add(k);
                }
                ans.add(list);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SolutionJZ41 jz41 = new SolutionJZ41();
        System.out.println(jz41.FindContinuousSequence(100));
        System.out.println(jz41.FindContinuousSequence2(100));
    }
}
