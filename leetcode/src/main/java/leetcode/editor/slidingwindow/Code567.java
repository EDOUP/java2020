package leetcode.editor.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * <p>
 * 示例1:
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 * <p>
 * 示例2:
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 * <p>
 * 注意：
 * <p>
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 * <p>
 * 滑动窗口
 *
 * @author edoup
 * @date 2020/12/21 23:23
 */
public class Code567 {

    public static void main(String[] args) {
        Code567 code567 = new Code567();
        System.out.println(code567.checkInclusion("abcdxabcde",
                "abcdeabcdx"));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> windwos = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int vaild = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.get(c) != null) {
                windwos.put(c, windwos.getOrDefault(c, 0) + 1);
                if (windwos.get(c).equals(need.get(c))) {
                    vaild++;
                }
            }

            while (right - left >= s1.length()) {
                if (vaild == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (need.get(d) != null) {
                    if (windwos.get(d).equals(need.get(d))) {
                        vaild--;
                    }
                    windwos.put(d, windwos.get(d) - 1);
                }
            }

        }

        return false;
    }

}
