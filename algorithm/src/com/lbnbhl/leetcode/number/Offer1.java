package com.lbnbhl.leetcode.number;

/**
 * @autor wwl
 * @date 2023/1/9-13:35
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 * https://leetcode.cn/problems/xoh6Oh/?envType=study-plan&id=lcof-ii&plan=lcof&plan_progress=c8v8wr1
 */
public class Offer1 {
    public int divide(int a, int b) {
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
            db = ~db+1;
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
}
