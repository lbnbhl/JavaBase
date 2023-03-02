package com.lbnbhl.leetcode.offer1;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * @autor wwl
 * @date 2022/9/20-19:13
 *第k-1种有translateNum（k-1）
 */
public class Offer46 {

//    public int translateNum(int num) {
//        int last=num%10,a=0,b=num/10,result=0,flag=0;
//        if (b==0) return 1;
//        while (b>0){
//            a=b%10;
//            if (a*10+last>=0 && a*10<=25){
//            }else flag=0;
//        }
//        return result;
//    }

//    大佬
    public int translateNum(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while(num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }
}
