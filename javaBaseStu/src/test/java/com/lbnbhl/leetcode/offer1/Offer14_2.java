package com.lbnbhl.leetcode.offer1;

import org.junit.Test;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。
 * 请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * @autor wwl
 * @date 2022/10/11-16:27
 */
public class Offer14_2 {

    public int cuttingRope(int n) {
        int m=n,res=1,a,b;
        if (n%3!=0){
            m=n/3+1;
            m*=3;
            a=m-n;
            b=n/3+1;
            b=b-a;
            int ans = 1;
            int i=2;

            while(a!=0){
                if((a&1)!=0)        //如果n的当前末位为1
                    ans *= i;  //ans乘上当前的a
                i *= i;        //a自乘
                a >>= 1;       //n往右移一位
            }
            res=ans;
            ans=1;
            i=3;
            while(b!=0){
                if((b&1)!=0)        //如果n的当前末位为1
                    ans *= i;  //ans乘上当前的a
                i *= i;        //a自乘
                b >>= 1;       //n往右移一位
            }
            res=ans*res;
        }else {
            int i=3;
            b=n/3;
            while(b!=0){
                if((b&1)!=0)        //如果n的当前末位为1
                    res *= i;  //ans乘上当前的a
                i *= i;        //a自乘
                b >>= 1;       //n往右移一位
            }
        }
        return res;
    }

    @Test
    public void cuttingRopeTest(){
        System.out.println(cuttingRope(10));
    }
}
