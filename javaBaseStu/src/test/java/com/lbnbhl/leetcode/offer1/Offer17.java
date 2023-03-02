package com.lbnbhl.leetcode.offer1;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * @autor wwl
 * @date 2022/10/10-16:32
 */
public class Offer17 {
    public int[] printNumbers(int n) {
        int m = 1;
        for (int i = 0; i < n; i++) {
            m *= 10;
        }
        int[] res = new int[m - 1];
        for (int i = 1; i < m; i++) {
            res[i] = i;
        }
        return res;
    }

}
