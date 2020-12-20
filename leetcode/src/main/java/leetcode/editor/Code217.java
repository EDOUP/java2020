package leetcode.editor;

import java.util.HashSet;
import java.util.Set;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/12/13 20:42
 */
public class Code217 {

    public static void main(String[] args) {
        Code217 code217 = new Code217();
        int[] a = new int[]{1, 2, 3, 1};
        System.out.println(code217.containsDuplicate(a));
    }

    public boolean containsDuplicate(int[] nums) {
        Set a = new HashSet();
        Set b = new HashSet();
        for (int num : nums) {
            if (b.contains(num)) {
                a.add(num);
            } else {
                b.add(num);
            }
            if (a.contains(num)) {
                return true;
            }
        }
        return false;
    }
}
