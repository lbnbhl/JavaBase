package com.lbnbhl.leetcode.offer2;

import org.junit.Test;

/**
 * @autor wwl
 * @date 2022/11/11-23:07
 * 题目：
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 */
public class Offer002 {

    public String addBinary(String a, String b) {

        StringBuilder res=new StringBuilder();

        int la=a.length()-1,lb=b.length()-1,co=0,j=lb,i=la;

        char c='0',d='0';

        while ( i>=0 || j>=0) {
            if (i < 0)
                c = '0';
            else
                c = a.charAt(i);
            if (j < 0)
                d = '0';
            else
                d = b.charAt(j);
            if (co == 1) {
                if (c == '1' && d == '1') {
                    res.insert(0, '1');
                } else if ((c == '1' && d == '0') || (c == '0' && d == '1')) {
                    res.insert(0, '0');
                } else if (c == '0' && d == '0') {
                    res.insert(0, '1');
                    co = 0;
                }
            } else {
                if (c == '1' && d == '1') {
                    res.insert(0, '0');
                    co = 1;
                } else if ((c == '1' && d == '0') || (c == '0' && d == '1')) {
                    res.insert(0, '1');
                } else if (c == '0' && d == '0') {
                    res.insert(0, '0');
                }
            }
            j--;
            i--;
        }
        if (co == 1 ) {
            res.insert(0, '1');
        }
        return res.toString();
    }

    @Test
    public void addBinaryTest(){
        String a="11",b="10";
        addBinary(a,b);
    }
}
