package com.lbnbhl.leetcode.offer1;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * @autor wwl
 * @date 2022/10/3-21:25
 */
public class Offer66 {
    //超时
    public int[] constructArr(int[] a) {
        int temp;
        int[] b=new int[a.length];
        for (int i = 0; i < b.length; i++) {
            int sum=1;
            temp=a[i];
            a[i]=1;
            for (int j = 0; j < a.length; j++) {
                sum*=a[j];
            }
            b[i]=sum;
            a[i]=temp;
        }
        return b;
    }

//    大佬揭发
    public int[] constructArr1(int[] a) {
        int len = a.length;
        if(len == 0) return new int[0];
        int[] b = new int[len];
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for(int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }

}
