package com.lbnbhl.leetcode.number;

/**
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 * 动态规划思想
 * @autor wwl
 * @date 2023/1/11-14:58
 */
public class Offer3 {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i=1;i<n+1;)
            res[i] = res[i>>1] + (i++%2);
        return res;
    }
}
