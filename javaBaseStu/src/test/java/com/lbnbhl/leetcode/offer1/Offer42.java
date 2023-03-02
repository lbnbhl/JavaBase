package com.lbnbhl.leetcode.offer1;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * @autor wwl
 * @date 2022/9/19-10:45
 */
public class Offer42 {
    public int maxSubArray(int[] nums) {
        int max = nums[0], sum = 0;
        for (int num : nums) {
            if (num > max) max = num;
            if (sum < 0) sum = num;
            else sum += num;
            max = Math.max(max, sum);
        }
        return max;
    }
}
