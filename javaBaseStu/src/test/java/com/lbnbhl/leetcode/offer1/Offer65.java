package com.lbnbhl.leetcode.offer1;

import org.junit.Test;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * @autor wwl
 * @date 2022/10/1-21:15
 */
public class Offer65 {
    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }

        // 转换成非进位和 + 进位
        return add(a ^ b, (a & b) << 1);
    }

    @Test
    public void addTest(){
        int a=12,b=9;
        add(a,b);
    }
}
