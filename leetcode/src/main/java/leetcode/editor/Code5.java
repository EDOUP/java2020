package leetcode.editor;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/12/20 23:43
 */
public class Code5 {

    int begin = 0;
    int len = 0;

    public String longestPalindrome(String s) {

        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            palindrome(s, i, i);
            palindrome(s, i, i + 1);
        }
        return s.substring(begin, begin + len);


    }


    public void palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - left - 1 > len) {
            begin = left + 1;
            len = right - left - 1;
        }
    }
}
