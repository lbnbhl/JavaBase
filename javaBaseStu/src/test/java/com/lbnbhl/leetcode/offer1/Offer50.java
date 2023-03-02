package com.lbnbhl.leetcode.offer1;

import org.junit.Test;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * @autor wwl
 * @date 2022/9/15-21:50
 */
public class Offer50 {
    public char firstUniqChar(String s) {
        int flag=0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (j!=i && chars[i] == chars[j]){
                    flag=1;
                    break;
                }
            }
            if (flag==0) return chars[i];
            else flag=0;
        }
        return ' ';
    }

    @Test
    public void firstUniqCharTest(){
        String s="cc";
        System.out.println(firstUniqChar(s));
    }
}
