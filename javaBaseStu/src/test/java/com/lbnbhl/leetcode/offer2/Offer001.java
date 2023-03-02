package com.lbnbhl.leetcode.offer2;

import org.junit.Test;

/**
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 * @autor wwl
 * @date 2022/10/22-9:56
 */
public class Offer001 {
// 时间复杂度：O(1)

    public int divide(int a, int b) {

//        溢出处理
        if (a == Integer.MIN_VALUE && b == -1)

            return Integer.MAX_VALUE;
//最后的符号判断
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;

        //如果a为-2147483648 则 Math.abs(a) 也为 -2147483648
        a = Math.abs(a);

        b = Math.abs(b);

        int res = 0;

        for (int i = 31; i >= 0; i--) {

            // 首先，右移的话，再怎么着也不会越界

            // 其次，无符号右移的目的是：将 -2147483648 看成 2147483648

            // 注意，这里不能是 (a >>> i) >= b 而应该是 (a >>> i) - b >= 0

            // 这个也是为了避免 b = -2147483648，如果 b = -2147483648

            // 那么 (a >>> i) >= b 永远为 true，但是 (a >>> i) - b >= 0 为 false
//11111111
//00000001
            if ((a >>> i) - b >= 0) { // a >= (b << i)

                a -= (b << i);

                // 代码优化：这里控制 res 大于等于 INT_MAX

                if (res > Integer.MAX_VALUE - (1 << i)) {

                    return Integer.MIN_VALUE;

                }

                res += (1 << i);

            }

        }

        // bug 修复：因为不能使用乘号，所以将乘号换成三目运算符

        return sign == 1 ? res : -res;

    }

    /**
     * 整数除法
     * 1、大数问题
     * 2、时间复杂度
     * @param a
     * @param b
     * @return
     */
    public int divide1(int a, int b) {
        int h=Math.abs(a),res=0,sign=(a>0)^(b>0)?-1:1;
        b=Math.abs(b);
        if (h<0 && b==-1) return 2147483647;
        if (0<=h && h<b) return 0;
        h-=b;
        while (h>=0){
            h-=b;
            res++;
        }
        return sign == 1 ? res : -res;
    }

    public int divide3(int a, int b) {
        if(a==Integer.MIN_VALUE && b == -1){
            return Integer.MAX_VALUE;
        }
        long da= (long) a;
        long db =(long) b;
        boolean flag = false; //正数
        int res = 0;
        if(da<0){
            da=~da+1; //原码
            flag = !flag;
        }
        if(db<0) {
            db =~db+1;
            flag = !flag;
        }
        for(int i = 31;i>=0;i--){
            if(da>=(db<<i)){
                res|=(1<<i);
                da-=(db<<i);
            }
        }
        return flag?-res:res;

    }

    @Test
    public void divideTest(){
        System.out.println(Math.abs(-2147483648));
//        int i = divide(-2147483648, -2147483648);
        int i1 = divide3(2147483647, 2147483647);
        System.out.println(2147483647-(-2147483648));
        System.out.println("hh");
    }
}
//原码 11111111 : -2147483648
//补码 10000001 : -2147483648
//-11111111
