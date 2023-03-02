package com.lbnbhl.leetcode.offer1;

import org.junit.Test;

/**
 * 统计一个数字在排序数组中出现的次数。
 * @autor wwl
 * @date 2022/9/14-11:21
 */
public class Offer53 {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1,mid=(right-left-1)/2,i=0,base;
        if (right==-1){return 0;}
        while (left<=mid && right>=mid && nums[mid]!=target){
            if (target>nums[mid]){
                left=mid+1;
                mid=(left+right)/2;
            }else {
                right=mid-1;
                mid=(left+right)/2;
            }
        }
        if (left>mid||right<mid){
            return 0;
        }else{
            base=mid;
            while ( mid< nums.length && nums[mid]==target){
                i++;
                mid++;
            }
            mid=base-1;
            while (mid>=0 && nums[mid]==target){
                i++;
                mid--;
            }
            return i;
        }
    }

    @Test
    public void searchTest(){
        int[] nums=new int[]{2,3,4};
        System.out.println(search(nums, 4));
    }
}
