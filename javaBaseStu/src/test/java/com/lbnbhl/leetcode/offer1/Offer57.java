package com.lbnbhl.leetcode.offer1;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * @autor wwl
 * @date 2022/9/23-15:01
 */
public class Offer57 {
    public int[] twoSum(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left<right){
            if (nums[left]+nums[right]==target)
                return new int[]{nums[left],nums[right]};
            else {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return null;
    }
}
