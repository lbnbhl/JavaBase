package com.lbnbhl.leetcode.offer1;

import org.junit.Test;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * @autor wwl
 * @date 2022/9/13-20:18
 */
public class offer58 {
//    public String reverseLeftWords(String s, int n) {
//        char[] chars = s.toCharArray();
//        StringBuilder result = new StringBuilder();
//        return result.append(chars,n,chars.length-n).append(chars,0,n).toString();
//    }

//    public String reverseLeftWords(String s, int n) {
//        char[] chars = s.toCharArray();
//        char[] result = new char[chars.length];
//        for (int i = n; i < chars.length; i++) {
//            result[i-n]=chars[i];
//        }
//        for (int i = 0; i < n; i++) {
//            result[chars.length-n+i]=chars[i];
//        }
//        return new String(result);
//    }

    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }

    @Test
    public void hh(){
        String s="12345";
        reverseLeftWords(s,2);
    }
}
