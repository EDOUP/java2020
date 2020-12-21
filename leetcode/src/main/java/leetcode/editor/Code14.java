package leetcode.editor;

import java.util.Arrays;

/**
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author edoup
 * @date 2020/12/20 22:54
 */
public class Code14 {

    public static void main(String[] args) {

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (String str : strs) {
            if (str.length() == 0) {
                return "";
            }
        }
        StringBuffer res = new StringBuffer();
        Arrays.sort(strs);
        int fistArrayLength = strs[0].length();
        int len = strs.length - 1;
        int lastArrayLength = strs[len].length();
        int min = Math.min(fistArrayLength, lastArrayLength);
        for (int i = 0; i < min; i++) {
            if (strs[0].charAt(i) == strs[len].charAt(i)) {
                res.append(strs[0].charAt(i));
            } else {
                break;
            }
        }

        return res.toString();
    }
}
