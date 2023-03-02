package com.lbnbhl.leetcode.offer1;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * @autor wwl
 * @date 2022/10/2-15:28
 */
public class Offer56_1 {
    public int[] singleNumbers(int[] nums) {
//        temp为所有数异或的结果,m为temp从个位起第一个为1的数，可根据这位将数组分成两组
        int temp = 0, m = 1, left = 0, right = 0, n=0;
        for (int i = 0; i < nums.length; i++) {
            temp ^= nums[i];
        }

        n = m & temp;
        while (m!=n){
            m=m<<1;
            n = m & temp;
        }

        for (int i = 0; i < nums.length; i++) {
            if ((m & nums[i]) == m)
                left ^= nums[i];
            else
                right ^= nums[i];
        }

        return new int[]{left, right};
    }

    @Test
    public void singleNumbersTest(){
        int[] nums=new int[]{1,2,5,2};
        for (int i : singleNumbers(nums)) {
            System.out.println(i);
        }
    }
}
