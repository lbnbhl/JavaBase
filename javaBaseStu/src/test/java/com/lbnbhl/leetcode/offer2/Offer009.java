package com.lbnbhl.leetcode.offer2;

import org.junit.Test;

/**
 * @autor wwl
 * @date 2022/11/17-11:47
 * 给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
 */
public class Offer009 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left=0,right=0,pro=nums[0],res=0;
        while (right<nums.length&&left<nums.length){
            if ( pro<k){
                res+=right-left+1;
                right++;
                if (right >= nums.length) break;
                pro*=nums[right];
            }else {
                pro/=nums[left];
                left++;
            }
        }
        return res;
    }

    @Test
    public void numSubarrayProductLessThanKTest(){
        int[] nums=new int[]{10,5,2,6};
        System.out.println(numSubarrayProductLessThanK(nums, 100));
    }
}
