package com.edoup.thread.practise.jianzhi;

/**
 * <p>
 *     题目描述
 *     请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 *     例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * </p>
 *
 * @author edoup
 * @date 2020/5/3 15:52
 */
public class Solution2 {

    /**
     * java 方法
     * @param str
     * @return
     */
    public static String replaceSpace1(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }

    /**
     * 手动扩容，逐字符替换
     * @param str
     * @return
     */
    public static String replaceSpace2(StringBuffer str) {
        int blankNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                blankNum++;
            }
        }
        if (blankNum == 0) {
            return str.toString();
        }

        int oldLength = str.length();
        int newLength = oldLength + (blankNum << 1);
        str.setLength(newLength);
        int oldIndex = oldLength - 1;
        int newIndex = newLength - 1;
        for (; oldIndex >= 0; oldIndex--) {
            if (str.charAt(oldIndex) == ' ') {
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            } else {
                str.setCharAt(newIndex--, str.charAt(oldIndex));
            }
        }
        return str.toString();
    }

    /**
     * 手动扩容，使用char数组
     * @param str
     * @return
     */
    public static String replaceSpace3(StringBuffer str) {
        int blankNum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                blankNum++;
            }
        }
        if (blankNum == 0) {
            return str.toString();
        }
        int oldLength = str.length();
        int newLength = oldLength + (blankNum << 1);
        char[] newChar = new char[newLength];
        for (int i = 0, j = 0; i < oldLength; i++, j++) {
            if (str.charAt(i) == ' ') {
                newChar[j] = '%';
                newChar[j++] = '2';
                newChar[j++] = '0';
            }else {
                 newChar[j] = str.charAt(i);
            }
        }
        return new String(newChar);

    }

    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("We Are Happy");

        System.out.println(replaceSpace1(s));
        System.out.println(replaceSpace2(s));
        System.out.println(replaceSpace3(s));


    }
}
