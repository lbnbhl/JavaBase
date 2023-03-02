package com.lbnbhl.leetcode.offer1;

import org.junit.Test;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * @autor wwl
 * @date 2022/9/26-16:33
 */
public class Offer45 {
    public String minNumber(int[] nums) {
        String a,b;
        StringBuilder res = new StringBuilder();
        int temp=0,k=0;
        for (int i=nums.length-1; i>=0; i--) {
            for (int j = nums.length - 1; j > nums.length - 1 - i; j--) {
                a= new String(""+nums[j]+nums[j-1]);
                b= new String(""+nums[j-1]+nums[j]);
                if (a.compareTo(b) < 0) {
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
            res=res.append(nums[nums.length-i-1]);
        }
        return String.valueOf(res);
    }

    @Test
    public void minNumberTest(){
        int[] nums=new int[]{3,30,34,5,9};
        String s = minNumber(nums);
        System.out.println(s);
    }
}

