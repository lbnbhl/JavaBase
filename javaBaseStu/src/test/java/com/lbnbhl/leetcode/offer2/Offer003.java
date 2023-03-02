package com.lbnbhl.leetcode.offer2;

import org.junit.Test;


/**
 * @autor wwl
 * @date 2022/11/1-14:50
 * 题目：给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组.
 * 思路：每一个二进制数所包含1的个数。都可以在前一个数的基础上进行变化，因此使用动态规划思想求解
 * 1. 初始化d[0]=0,d[1]=1
 * 2. 前一个数记为d[i-1]，从最后一位找，找到第一个为0的位,所在位数记为k，可知 d[i]=d[i-1]-k+1
 */
public class Offer003 {

    @Test
    public int[] countBits(int n) {
        int[] res=new int[n+1];
        res[0]=0;
        for (int i = 1; i < n+1; i++) {
            int k=0,m=1;
            while ( (i-1 & m)==m ){
                k++;
                m=m<<1;
            }
            res[i]=res[i-1]-k+1;
        }
        return res;
    }

}