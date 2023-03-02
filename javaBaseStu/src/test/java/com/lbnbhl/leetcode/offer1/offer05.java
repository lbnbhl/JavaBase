package com.lbnbhl.leetcode.offer1;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @autor wwl
 * @date 2022/9/13-19:54
 */
public class offer05 {

//    public String replaceSpace(String s) {
//        String replace = s.replaceAll(" ","%20");
//        return replace;
//    }

    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c==' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
