package com.lbnbhl.leetcode.offer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @autor wwl
 * @date 2022/11/15-17:26
 *
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
public class Offer007 {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        HashSet<Integer> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <length-2; i++) {
            for (int j = i+1; j < length-1; j++) {
                for (int k = j+1; k < length; k++) {
                    if (nums[i]+nums[j]+nums[k]==0) {
                        if (set.add(Math.abs(nums[i])^Math.abs(nums[j])^Math.abs(nums[k]))) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            res.add(list);
                        }
                    }
                }
            }
        }
        return res;
    }


}
