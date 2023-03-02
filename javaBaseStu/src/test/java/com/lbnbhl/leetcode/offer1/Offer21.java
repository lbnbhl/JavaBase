package com.lbnbhl.leetcode.offer1;

import org.junit.Test;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分
 * @autor wwl
 * @date 2022/9/23-9:46
 */
public class Offer21 {
    public int[] exchange(int[] nums) {
        if (nums==null) return null;
        int temp,j= nums.length-1,i;
            for ( i=0 ; i <= j-1; i++) {
                temp=nums[i];
                if (temp%2==0){
                    while ( nums[j]%2!=1){
                        if (j==i) return nums;
                        j--;
                    }
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        return nums;
    }

    @Test
    public void exchangeTest(){
        int[] nums=new int[]{2};
        int[] exchange = exchange(nums);
        for (int i = 0; i < exchange.length; i++) {
            System.out.println(exchange[i]);
        }
    }
}
