package com.lbnbhl.leetcode.offer1;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * @autor wwl
 * @date 2022/9/18-16:08
 */
public class Offer10_2 {
    public int numWays(int n) {
        int a=1,b=2,sum=1;
        if (n==0 || n==1 || n==3) return n;
        for (int i = 0; i < n-3; i++) {
            a=b;
            b=sum;
            sum=(a+b)%1000000007;
        }
        return sum;
    }
}
