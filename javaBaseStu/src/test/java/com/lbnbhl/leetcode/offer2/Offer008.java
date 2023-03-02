package com.lbnbhl.leetcode.offer2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @autor wwl
 * @date 2022/11/16-19:35
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 双指针法
 */
public class Offer008 {

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE, left = 0, right = 0,sum=nums[0];
        while (res != 1 ) {
            if (sum < target ) {
                right++;
                if (right >= nums.length) break;
                sum+=nums[right];
            }else {
                res= Math.min(right-left+1,res);
                sum-=nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE?0:res;
    }

    public int minSubArrayLen1(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    @Test
    public void minSubArrayLenTest(){
        int[] nums=new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen1(7, nums));
    }
}
