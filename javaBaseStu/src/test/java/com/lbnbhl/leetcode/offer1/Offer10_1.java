package com.lbnbhl.leetcode.offer1;

/**
 * 题目：写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。
 * 斐波那契数列的表示：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * @autor wwl
 * @date 2022/9/18-15:30
 */
public class Offer10_1 {

    /**
     * 大神的动态规划算法
     * @param n
     * @return
     */
    public int fib(int n){
        int a=0,b=1,sum=1;
        if (n==0 || n==1) return n;
        for (int i = 0; i < n-2; i++) {
            a=b;
            b=sum;
            sum=(a+b)%1000000007;
        }
        return sum;
    }


    /**
     * 多计算了一次f（n-2),时间复杂度偏高
     * @param n
     * @return
     */
    public int fib1(int n) {
        if (n==1 || n==2) return n-1;
        return (fib1(n-1)+fib1(n-2))%1000000007;
    }

}
