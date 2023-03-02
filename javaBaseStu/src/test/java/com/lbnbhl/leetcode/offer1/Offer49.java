package com.lbnbhl.leetcode.offer1;

import org.junit.Test;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * @autor wwl
 * @date 2022/10/9-19:52
 */
public class Offer49 {
    public int nthUglyNumber(int n) {
        if (n==1) return 1;
        int j=1;
        for (int i = 1; i < n; i++) {
            j++;
            int flag=j;
            while (flag!=1){
                if (flag%2==0)
                    flag/=2;
                else if (flag%3==0)
                    flag/=3;
                else if (flag%5==0)
                    flag/=5;
                else {
                    i--;
                    break;
                }
            }
        }
        return j;
    }

    //大佬
        public int nthUglyNumber1(int n) {
            int a = 0, b = 0, c = 0;
            int[] dp = new int[n];
            dp[0] = 1;
            for(int i = 1; i < n; i++) {
                int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
                dp[i] = Math.min(Math.min(n2, n3), n5);
                if(dp[i] == n2) a++;
                if(dp[i] == n3) b++;
                if(dp[i] == n5) c++;
            }
            return dp[n - 1];
        }

    @Test
    public void nthUglyNumberTest(){
//        for (int i = 0; i < 18; i++) {
            System.out.println(nthUglyNumber(1690));
//        }

    }
}
