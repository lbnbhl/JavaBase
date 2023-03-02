package com.lbnbhl.leetcode.offer2;

import java.util.HashMap;

/**
 * @autor wwl
 * @date 2022/11/13-19:45
 * 题目：
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 */
public class Offer004 {

    /**
     * 暴力法，不会，只能这样了
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num,1);
            else map.put(num,0);
        }
        for (int num : nums) {
            if (map.get(num)==0)
                res=num;
        }
        return res;
    }

    /**
     * k神的有限状态自动机 + 位运算
     * @param nums
     * @return
     */

    public int singleNumber1(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }


}
