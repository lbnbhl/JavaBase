package com.lbnbhl.leetcode.offer1;

import org.junit.Test;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在
 * *范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * @autor wwl
 * @date 2022/9/14-16:57
 */
public class Offer53_2 {
    public int missingNumber(int[] nums) {
        int left=0,right=nums.length-1,mid=(right+left)/2;
        while (mid <= right && mid >= left) {
            if (nums[mid] != mid) {
                right = mid - 1;
                mid = (left + right) / 2;
            } else {
                left = mid + 1;
                mid = (left + right) / 2;
            }
        }
        return mid==nums[mid]?nums[mid]+1:nums[mid]-1;
    }

    @Test
    public void missingNumberTest(){
        int[] nums=new int[]{0,1,2,3,5};
        System.out.println(missingNumber(nums));
    }
}
