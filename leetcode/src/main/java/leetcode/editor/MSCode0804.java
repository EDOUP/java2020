package leetcode.editor;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     子集问题
 * </p>
 *
 * @author edoup
 * @date 2020/11/28 1:27
 */
public class MSCode0804 {

    public static void main(String[] args) {
        MSCode0804 msCode0804 = new MSCode0804();
        int[] nums = new int[]{1, 2, 3};
        System.out.println(msCode0804.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        back(res, list,0, nums);
        return res;
    }

    public void back(List<List<Integer>> res, List<Integer> list, int n,int[] nums) {
        res.add(new ArrayList<>(list));
        for (int i = n; i < nums.length; i++) {
            list.add(nums[i]);
            back(res, list, i+1,nums);
            list.remove(list.size() - 1);
        }
    }
}
