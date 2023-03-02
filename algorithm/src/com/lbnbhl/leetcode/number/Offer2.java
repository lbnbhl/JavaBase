package com.lbnbhl.leetcode.number;

/**
 * @autor wwl
 * @date 2023/1/11-14:40
 */
public class Offer2 {
    public String addBinary(String a, String b) {
        int i = Integer.parseInt(a);
        int j = Integer.parseInt(b);
        int k=i+j;
        String s = String.valueOf(k);
        return s;
    }
}
