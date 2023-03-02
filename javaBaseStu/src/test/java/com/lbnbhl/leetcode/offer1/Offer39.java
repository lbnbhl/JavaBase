package com.lbnbhl.leetcode.offer1;

import org.junit.Test;

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * @autor wwl
 * @date 2022/10/3-20:40
 */
public class Offer39 {
    public int majorityElement(int[] nums) {
        HashMap map=new HashMap();
        for (int num : nums) {
            Integer value = (Integer) map.put(num, 1);
            if (value != null) {
                if (value == nums.length / 2) return num;
                map.put(num, value + 1);
            }
        }
        return nums[0];
    }


//    摩尔投票法
    public int majorityElement1(int[] nums) {
        int x=0,votes=0;
        for (int num : nums) {
            if (votes==0)
                x=num;
            if (x==num){
                votes++;
            }else votes--;
        }
        return x;
    }

    @Test
    public void majorityElementTest(){
        int[] nums=new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement1(nums));
    }
}
