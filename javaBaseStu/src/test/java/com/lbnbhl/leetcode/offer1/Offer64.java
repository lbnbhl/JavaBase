package com.lbnbhl.leetcode.offer1;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @autor wwl
 * @date 2022/9/29-19:10
 */
public class Offer64 {
    public int sumNums(int n) {
        int sum=0;
        boolean x=n>0 && n+sumNums(n-1)>0;
        return sum;
    }
}
